package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
	
	@FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
	private WebElement ProceedToCheckoutBtn;
	
	WebDriver driver = null;
	public AddressesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnProceedBtn(){
		ProceedToCheckoutBtn.click();
		return new ShippingPage(driver);
	}
}
