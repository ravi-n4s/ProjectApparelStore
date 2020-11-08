package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.GooglePlusPage;
import com.project.pages.IndexPage;
import com.project.pages.ProductPage;

public class ShareProduct_GooglePlus extends BaseClass{
	
	@Test(dataProvider = "TestData")
	public void ShareProductGooglePlus(String... data) {
		IndexPage ip = new IndexPage(driver);
		
		ProductPage pp = ip.clickOnFeaturedItem();
		pp.clickGooglePlusBtn();
		GooglePlusPage gpp= pp.switchToGooglePlusPage();
				
		gpp.setEmail(data[0]);
		logger = extent.createTest("Share product - G+ ");
		Assert.assertEquals(gpp.getEmail(), data[0]);
		
	}
}
