package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.AuthenticationPage;
import com.project.pages.IndexPage;
import com.project.pages.MyAccountPage;
import com.project.pages.ProductPage;

public class Review extends BaseClass{
//	WebDriver driver = null;
	
	@Test(dataProvider = "TestData")
	public void WriteAReview(String... data){
		IndexPage ip = new IndexPage(driver);

		AuthenticationPage ap = ip.clickSignIn();
		ap.SignInEmail(data[0]);
		ap.SignInPassword(data[1]);
		
		MyAccountPage mp = ap.clickSignInBtn();
		mp.clickOnHomeBtn();
		
		ProductPage pp = ip.clickOnFeaturedItem();
		pp.clikOnReviewLink();
		pp.qualityRating(data[2]); // Cancel Rating also can be given here
		pp.setReviewTitle(data[3]);
		pp.setReviewComment(data[4]);
		pp.clickSendBtn();
		
		logger = extent.createTest(testContext.getRealClass().getSimpleName());
		logger.createNode("Checking for Error Pop-up asking for more than 50 char");
		Assert.assertTrue(pp.PopupContains(data[5]));
	}

}
