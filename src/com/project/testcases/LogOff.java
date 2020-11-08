package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.pages.AuthenticationPage;
import com.project.pages.IndexPage;
import com.project.pages.MyAccountPage;

public class LogOff extends BaseClass {
	
	@Test(dataProvider = "TestData")
	public void Logoff(String... data){
		SoftAssert softAssert = new SoftAssert();
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		ip=null;
		
		ap.SignInEmail(data[0]);
		ap.SignInPassword(data[1]);
		MyAccountPage mp = ap.clickSignInBtn();
		
		//checking whether logged in by checking page title
		softAssert.assertTrue(mp.titleContains(data[2]));
		
		ap = mp.clickOnSigOut();
		//checking whether logged out by checking page title
		logger = extent.createTest("LogOff test case");
		softAssert.assertTrue(ap.titleContains(data[3]));
		softAssert.assertAll();
		
	}

}
