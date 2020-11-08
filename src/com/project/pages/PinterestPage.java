package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinterestPage {
	
	@FindBy(xpath = "//*[@id='__PWS_ROOT__']/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/div[2]/button/div")
	private WebElement LogInBtn;
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement EmailTextBox;
	
	@FindBy(xpath = "//*[@id='password']")
	private WebElement PasswordTextBox;
	
	WebDriver driver = null;
	public PinterestPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginBtn(){
		LogInBtn.click();		
	}
	
	public void setEmail(String email){
		EmailTextBox.clear();
		EmailTextBox.sendKeys(email);
	}
	
	public void setPassword(String password){
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(password);
	}
	
	public String getEmail(){
		return EmailTextBox.getAttribute("value");
	}
	
	public String getPassword(){
		return PasswordTextBox.getAttribute("value");
	}
	
}
