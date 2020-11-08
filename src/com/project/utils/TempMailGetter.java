package com.project.utils;

//import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempMailGetter {

	public static String getTempMail() throws IOException {
		WebDriver driver1 = null;	
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		String FilePath = ProjectPath + "/" + "TempMailFile.xlsx";
//		File file = new File(FilePath);
//		Workbook wb = new XSSFWorkbook();
//		FileOutputStream fos = new FileOutputStream(file);	
		
		System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver1 = new ChromeDriver(options);
		driver1.get("https://temp-mail.org/en/api/");
		WebDriverWait wait = new WebDriverWait(driver1, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='click-to-copy']")));
		String str = driver1.findElement(By.xpath("//*[@id='mail']")).getAttribute("value");
		driver1.quit();
		return str;
			
	}

}
