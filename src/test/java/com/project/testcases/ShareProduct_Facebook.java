package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.FacebookPage;
import com.project.pages.IndexPage;
import com.project.pages.ProductPage;

public class ShareProduct_Facebook extends BaseClass{
	
	@Test(dataProvider = "TestData")
	public void ShareProductFacebook(String... data) {
		IndexPage ip = new IndexPage(driver);
		
		ProductPage pp = ip.clickOnFeaturedItem();
		pp.clickFShareBtn();
		FacebookPage fp = pp.switchToFacebookPage();
		
		pp = fp.closeWindow();
		pp.getHandleBack();
		logger = extent.createTest(testContext.getRealClass().getSimpleName());
		logger.createNode("Getting control back to the Store");
		Assert.assertTrue(pp.verifyUrl(data[0]));
				
	}
}
