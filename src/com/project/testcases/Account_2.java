package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.AuthenticationPage;
import com.project.pages.CreateAnAccountPage;
import com.project.pages.IndexPage;

public class Account_2 extends BaseClass{
	@Test(dataProvider = "TestData")
	public void RegisterAccount(String... data) {
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		ip = null;
		
//		ap.enterEmailAddress(TempMailGetter.getTempMail());
		ap.enterEmailAddress(data[0]);
		
		CreateAnAccountPage caap = ap.clickOnCreateAnAccountBtn();
		
		try {
			caap.selectTitle(data[1]);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		caap.setFirstName(data[2]);
		caap.setLastName(data[3]);
		caap.setPassword(data[4]);
		caap.setDOB_date(data[5]);
		caap.setDOB_month(data[6]);
		caap.setDOB_year(data[7]);
		
		caap.setAddress(data[8]);
		caap.setCity(data[9]);
		caap.setState(data[10]);
		caap.setZipCode(data[11]);
		caap.setCountry(data[12]);
		caap.setMobile(data[13]);
		caap.clickRegisterBtn();
		logger = extent.createTest("Registering account with less than 5 char");
		Assert.assertTrue(caap.ErrorBoxContains(data[14]));
		
	}
	
}
