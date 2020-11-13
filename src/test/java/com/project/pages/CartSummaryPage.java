package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
	
	@FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
	private WebElement ProceedToCheckoutBtn;
	
	WebDriver driver = null;
	public CartSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddressesPage clickOnProceedBtnSignedIn(){
		ProceedToCheckoutBtn.click();
		return new AddressesPage(driver);
	}
}
