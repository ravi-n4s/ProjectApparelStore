package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	private WebElement PayByWire;
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
	private WebElement PayByCheck;
	
	WebDriver driver = null;
	public PaymentPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPayByWire(){
		PayByWire.click();
		return new OrderSummaryPage(driver);
	}
	
	public OrderSummaryPage clickOnPayByCheck(){
		PayByCheck.click();
		return new OrderSummaryPage(driver);
	}
}
