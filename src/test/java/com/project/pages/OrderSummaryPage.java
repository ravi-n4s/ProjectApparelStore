package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button/span")
	private WebElement IConfirmBtn;
	
	WebDriver driver = null;
	public OrderSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnIConfirmBtn(){
		IConfirmBtn.click();
		return new OrderConfirmationPage(driver);
	}
}
