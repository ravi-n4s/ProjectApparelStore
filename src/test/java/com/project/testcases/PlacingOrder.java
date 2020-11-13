package com.project.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.AddressesPage;
import com.project.pages.AuthenticationPage;
import com.project.pages.CartSummaryPage;
import com.project.pages.IndexPage;
import com.project.pages.OrderConfirmationPage;
import com.project.pages.OrderSummaryPage;
import com.project.pages.PaymentPage;
import com.project.pages.ShippingPage;

public class PlacingOrder extends BaseClass{
	
	@Test(dataProvider = "TestData")
	public void PlacingOrderPayByWire(String... data) throws InterruptedException {
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		ap.SignInEmail("fibefi9357@adeata.com");
		ap.SignInPassword("password");
		ap.clickSignInBtn();
		ip = ap.clickOnHomeLogo();
		ip.clickOnDresses();
		ip.clickOnCasualDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		ip.clickOnContinueShoppingBtn();
		ip.clickOnDressesNav();
		ip.clickOnEveningDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		ip.clickOnContinueShoppingBtn();
		ip.clickOnDressesNav();
		ip.clickOnSummerDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		CartSummaryPage csp = ip.clickOnProceedBtn();
		AddressesPage add = csp.clickOnProceedBtnSignedIn();
		ShippingPage ship = add.clickOnProceedBtn();
		ship.clickOnTncCheckBox();
		PaymentPage pay = ship.clickOnProceedBtn();
		OrderSummaryPage osp = pay.clickOnPayByCheck();
		OrderConfirmationPage ocp = osp.clickOnIConfirmBtn();
		logger = extent.createTest(testContext.getRealClass().getSimpleName() + " Pay By Check");
		logger.createNode("Checking for Success message in green coloured Box");
		Assert.assertTrue(ocp.ConfirmationMessageContains("Your order on My Store is complete"));	
		
	}
	
	@Test(dataProvider = "TestData")
	public void PlacingOrderPayByCheck(String... data) throws InterruptedException {
		IndexPage ip = new IndexPage(driver);
		AuthenticationPage ap = ip.clickSignIn();
		ap.SignInEmail(data[0]);
		ap.SignInPassword(data[1]);
		ap.clickSignInBtn();
		ip = ap.clickOnHomeLogo();
		ip.clickOnDresses();
		ip.clickOnCasualDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		ip.clickOnContinueShoppingBtn();
		ip.clickOnDressesNav();
		ip.clickOnEveningDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		ip.clickOnContinueShoppingBtn();
		ip.clickOnDressesNav();
		ip.clickOnSummerDressesLink();
		ip.mouseHover();
		ip.AddCartBtn();
		
		CartSummaryPage csp = ip.clickOnProceedBtn();
		AddressesPage add = csp.clickOnProceedBtnSignedIn();
		ShippingPage ship = add.clickOnProceedBtn();
		ship.clickOnTncCheckBox();
		PaymentPage pay = ship.clickOnProceedBtn();
		OrderSummaryPage osp = pay.clickOnPayByWire();
		OrderConfirmationPage ocp = osp.clickOnIConfirmBtn();
		
		logger = extent.createTest(testContext.getRealClass().getSimpleName() + " Pay By Wire Transfer");
		logger.createNode("Checking for Success message in green coloured Box");
		Assert.assertTrue(ocp.ConfirmationMessageContains(data[2]));			
	}	
}
