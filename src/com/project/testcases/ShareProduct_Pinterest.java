package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.pages.IndexPage;
import com.project.pages.PinterestPage;
import com.project.pages.ProductPage;

public class ShareProduct_Pinterest extends BaseClass{
	
	@Test(dataProvider = "TestData")
	public void ShareProductPinIt(String... data) {
		SoftAssert softAssert = new SoftAssert();
		IndexPage ip = new IndexPage(driver);
		
		ProductPage pp = ip.clickOnFeaturedItem();
		pp.clickPinterestBtn();
		PinterestPage pin = pp.switchToPinterestPage();
				
		pin.clickLoginBtn();
		pin.setEmail(data[0]);
		pin.setPassword(data[1]);
		
//		logger = extent.createTest("Share Product - PinIt");
		softAssert.assertEquals(pin.getEmail(), data[0]);
		softAssert.assertEquals(pin.getPassword(), data[1]);
		softAssert.assertAll();
		
	}
}
