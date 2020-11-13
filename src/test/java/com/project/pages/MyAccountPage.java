package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	private WebElement Signout;
	
	@FindBy(xpath = "//*[@id='center_column']/p")
	private WebElement AccountInfo;	
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li/a/span")
	private WebElement HomeBtn;
	
	public MyAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean isSignOutDisplayed(){
		return Signout.isDisplayed();
	}
	
	public AuthenticationPage clickOnSigOut(){
		Signout.click();
		return new AuthenticationPage(driver);
	}
	
	public Boolean AccountInfoContains(String message){
		return AccountInfo.getText().contains(message);		
	}
	
	public void clickOnHomeBtn(){
		HomeBtn.click();
	}
	
	public Boolean titleContains(String message){
		return driver.getTitle().equalsIgnoreCase(message);
	}
}
