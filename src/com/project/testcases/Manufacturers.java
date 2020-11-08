package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.IndexPage;
import com.project.pages.SearchedPage;

public class Manufacturers extends BaseClass {
//	WebDriver driver = null;
	
	@Test(dataProvider = "TestData")
	public void SearctTestCase(String... data){
		IndexPage ip = new IndexPage(driver);
		
		ip.setSearchTextBox(data[0]); //fashion
		SearchedPage sp = ip.clickOnSearchBtn();
		String header = sp.clickOnManufacturerLink();
//		logger = extent.createTest("Manufacturers");
		logger = extent.createTest(testContext.getRealClass().getSimpleName());
		Assert.assertTrue(sp.HeaderContains(header));
	}
}
