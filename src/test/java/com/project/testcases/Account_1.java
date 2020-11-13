package com.project.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.AuthenticationPage;
import com.project.pages.CreateAnAccountPage;
import com.project.pages.IndexPage;
import com.project.pages.MyAccountPage;
import com.project.utils.TempMailGetter;

public class Account_1 extends BaseClass {
	
	@Test(dataProvider = "TestData")
	public void RegisterAccount(String... data) throws InterruptedException, IOException
	{
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		ip = null;
		
		//Running every time requires a new address, so implemented temp mail getter
		ap.enterEmailAddress(TempMailGetter.getTempMail());
//		ap.enterEmailAddress("ayex443@aieen.com");
		
		CreateAnAccountPage caap = ap.clickOnCreateAnAccountBtn();
		
		caap.selectTitle(data[0]);
		caap.setFirstName(data[1]);
		caap.setLastName(data[2]);
		caap.setPassword(data[3]);
		caap.setDOB_date(data[4]);
		caap.setDOB_month(data[5]);
		caap.setDOB_year(data[6]);
		
		caap.setAddress(data[7]);
		caap.setCity(data[8]);
		caap.setState(data[9]);
		caap.setZipCode(data[10]);
		caap.setCountry(data[11]);
		caap.setMobile(data[12]);
		MyAccountPage mp = caap.clickRegisterBtn();
		
		caap = null; 
		logger = extent.createTest(testContext.getRealClass().getSimpleName());
		logger.createNode("Checking for Welcome message");
		Assert.assertTrue(mp.AccountInfoContains(data[13]));
		 
	}
}
