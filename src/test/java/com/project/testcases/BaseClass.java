package com.project.testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.project.utils.PropertyReader;

import au.com.bytecode.opencsv.CSVReader;

public class BaseClass 
{
	WebDriver driver = null;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;
	
	 @BeforeSuite
	 public void startReport(){
	     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyReport.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	     extent.setSystemInfo("Host Name", "SoftwareTesting");
	     extent.setSystemInfo("Environment", "Automation Testing");
	     extent.setSystemInfo("User Name", "Srinivas Sannidhi");
		 htmlReporter.config().setDocumentTitle("Automation Report");
		 htmlReporter.config().setReportName("Selenium Regression Test Suite");
		 htmlReporter.config().setTheme(Theme.STANDARD);		
	 }
	
	@BeforeMethod
	public void initiateDriver() throws IOException{
		
		String browser = PropertyReader.ReadProperty("browser");
		if(browser.trim().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
			driver = new ChromeDriver();
		}else if(browser.trim().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", PropertyReader.ReadProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
		}else if(browser.trim().equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", PropertyReader.ReadProperty("iedriverpath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(PropertyReader.ReadProperty("appurl"));
	}
	
	public String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException{
		//for that we need to reference another jar files 
		//one for the extent report and another is for snapshot
		//common-io jars - reference it in the project
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir")+"/Screenshots/" + ScreenshotName + dateName + ".png"; 
		//added common-io jars
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
	ITestNGMethod testContext = null;
	@DataProvider(name = "TestData")
	public String[][] getData(ITestNGMethod testContext) throws IOException { 
		this.testContext = testContext;
		System.out.println("|"+testContext.getRealClass().getSimpleName()+"|");
		CSVReader reader = null;
		try{
			reader = new CSVReader(new FileReader(PropertyReader.ReadProperty(testContext.getRealClass().getSimpleName())));
		}
		catch (NullPointerException e) {
		    e.printStackTrace();
		  } 
		
		// this will load content into list
		List<String[]> li=reader.readAll();
		
		// create Iterator reference
		Iterator<String[]> iter= li.iterator();
		
		String[][] creds = new String[li.size()-1][iter.next().length];		
		for(int i=0; iter.hasNext(); i++){
			creds[i] = iter.next();
		}
		return creds;
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException	{
		if(result.getStatus() == ITestResult.FAILURE){
			//log the results
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed ", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed ", ExtentColor.RED));
			logger.fail("Test Case Failed Snapshot is below - " + logger.addScreenCaptureFromPath(getScreenshot(driver,result.getName())));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));
			logger.log(Status.SKIP,"Snapshot is below - " + logger.addScreenCaptureFromPath(getScreenshot(driver,result.getName())));
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed ", ExtentColor.GREEN));
			logger.log(Status.PASS,"Snapshot is below - " + logger.addScreenCaptureFromPath(getScreenshot(driver,result.getName())));
		}
		
		// logic for closing driver
		driver.quit();
		driver=null;
	}
	
	@AfterSuite
	public void stopTest()	{
		extent.flush(); //at the end of all tests - it will append the test results to the htmlreport when flushed
	}
	
}
