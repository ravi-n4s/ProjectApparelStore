package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.IndexPage;
import com.project.pages.SearchedPage;

public class Search extends BaseClass {
	
	@Test(dataProvider = "TestData")
	public void SearctTestCase(String... data) throws InterruptedException{
		IndexPage ip = new IndexPage(driver);
		
		ip.setSearchTextBox(data[0]);
		SearchedPage sp = ip.clickOnSearchBtn();
		
		logger = extent.createTest(testContext.getRealClass().getSimpleName() );
		Thread.sleep(2000); //for the page to load, without this sleep all the Visible items are not loading/appearing and giving wrong result
		
		Assert.assertEquals(sp.countNumberOfVisibleItems(), sp.getNumberOfExpectedItems());
	}

}
