package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	
	@FindBy(xpath = "//*[@id='form']/p/button/span")
	private WebElement ProceedToCheckoutBtn;
	
	@FindBy(xpath = "//*[@id='cgv']")
	private WebElement TOSCheckBox;
	
	WebDriver driver = null;
	public ShippingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnProceedBtn(){
		ProceedToCheckoutBtn.click();
		return new PaymentPage(driver);
	}
	
	public void clickOnTncCheckBox(){
		TOSCheckBox.click();
	}
}
