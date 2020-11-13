package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.AuthenticationPage;
import com.project.pages.IndexPage;
import com.project.pages.MyAccountPage;

public class Signin_Valid extends BaseClass{
	private static int count = 1;
	
	@Test(dataProvider = "TestData")
	public void SignIn(String... d){
		IndexPage ip = new IndexPage(driver);
		ip.clickSignIn();
		ip=null;
		
		AuthenticationPage ap = new AuthenticationPage(driver);
//		ap.SignInEmail("fibefi9357@adeata.com");
//		ap.SignInPassword("password");
		ap.SignInEmail(d[0]);
		ap.SignInPassword(d[1]);
		MyAccountPage mp = ap.clickSignInBtn();
		logger = extent.createTest(testContext.getRealClass().getSimpleName());
		Assert.assertTrue(mp.isSignOutDisplayed());
	}	

}
	
	


