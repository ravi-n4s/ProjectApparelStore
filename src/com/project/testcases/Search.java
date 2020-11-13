package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.IndexPage;
import com.project.pages.SearchedPage;

public class Search extends BaseClass {
//	WebDriver driver = null;
	
	@Test(dataProvider = "TestData")
	public void SearctTestCase(String... data){
		IndexPage ip = new IndexPage(driver);
		
		ip.setSearchTextBox(data[0]);
		SearchedPage sp = ip.clickOnSearchBtn();
		
		logger = extent.createTest("Search");
//		System.out.println("visible items : "+sp.countNumberOfVisibleItems());
//		System.out.println("Expected Number of Items : "+ sp.getNumberOfExpectedItems());
		Assert.assertEquals(sp.countNumberOfVisibleItems(), sp.getNumberOfExpectedItems());
	}

}
