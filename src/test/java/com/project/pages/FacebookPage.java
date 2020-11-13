package com.project.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement EmailTextBox;
	
	@FindBy(xpath = "//*[@id='pass']")
	private WebElement PasswordTextBox;
	
	WebDriver driver = null;
	public FacebookPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
//	public ProductPage switchToProductPage(){
//		
//		Set<String> s = driver.getWindowHandles();
//		Iterator<String> i1 = s.iterator();
//		String ChildWindow = null;
//		while(i1.hasNext()){
//			ChildWindow = i1.next();
//		}
//		
//		System.out.println("current window handle : "+driver.getWindowHandle());
//		driver.switchTo().window(ChildWindow);
//		
//		return new ProductPage(driver);
//	}
	
	public ProductPage closeWindow(){
		driver.close();
		return new ProductPage(driver);
	}
}
