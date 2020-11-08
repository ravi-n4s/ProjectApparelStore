package com.project.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.pages.AuthenticationPage;
import com.project.pages.IndexPage;

public class Signin_Invalid extends BaseClass{
//	 3 sets of test data
//	 1. Invallid email ID - "Invalid email address" should be displayed
//	 2. password less than 5 char - "Invalid password" should be displayed
//	 3. wrong password - "Authentication failed" should be displayed
	
	@Test(dataProvider = "TestData")
	public void SignInInvalid(String... data){
		SoftAssert softAssert = new SoftAssert(); 
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		
		ap.SignInEmail(data[0]);
		ap.SignInPassword(data[1]);
		
		ap.clickSignInBtn();
		logger = extent.createTest(testContext.getRealClass().getSimpleName() + " - " + testContext.getCurrentInvocationCount());
		logger.createNode("checking colour of error message box");	
//		System.out.println("Get the css width value of ageTextbox = " + ap.ErrorBox.getCssValue("background-color"));
		softAssert.assertEquals(data[2], ap.ErrorBox.getCssValue("background-color"));
		logger.createNode("Checking whether the error message is as expected");	
		softAssert.assertTrue(ap.ErrorBoxContains(data[3]));  //Error message
		softAssert.assertAll();
	}

}
