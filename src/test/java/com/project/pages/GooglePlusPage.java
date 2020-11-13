package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePlusPage {
	
	@FindBy(xpath = "//*[@id='identifierId']")
	private WebElement EmailTextBox;
	
	WebDriver driver = null;
	public GooglePlusPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String email){
		EmailTextBox.clear();
		EmailTextBox.sendKeys(email);
	}
	
	public String getEmail(){
		return EmailTextBox.getAttribute("value");
	}
}
