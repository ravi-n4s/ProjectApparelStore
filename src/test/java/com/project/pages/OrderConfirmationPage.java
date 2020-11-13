package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	@FindBy(xpath = "//*[@id='center_column']/p[1]")
	private WebElement ConfirmationMessage;
	
	WebDriver driver = null;
	public OrderConfirmationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean ConfirmationMessageContains(String message){
		return ConfirmationMessage.getText().toUpperCase().contains(message.toUpperCase());		
	}
}
