package com.project.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	@FindBy(xpath = "//*[@id='email_create']")
	private WebElement EmailAddressTextBox; 
	
	@FindBy(xpath = "//*[@id='SubmitCreate']/span")
	private WebElement CreateAnAccountBtn;
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement SignInEmail;
	
	@FindBy(xpath = "//*[@id='passwd']")
	private WebElement SignInPassword;
	
	@FindBy(xpath = "//*[@id='SubmitLogin']/span")
	private WebElement SignInBtn;

	@FindBy(xpath = "//*[@id='login_form']/div/p[1]/a")
	private WebElement ForgotPasswordLink;

	@FindBy(xpath = "//*[@id='center_column']/div[1]")
	public WebElement ErrorBox;

	@FindBy(xpath = "//*[@id='order_step']/li[1]/a")
	private WebElement ProgressBar;

	@FindBy(xpath = "//*[@id='header_logo']/a/img")
	private WebElement HomeLogo;
	
	
	WebDriver driver = null;
	public AuthenticationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String email){
		EmailAddressTextBox.clear();
		EmailAddressTextBox.sendKeys(email);
	}
	
	public CreateAnAccountPage clickOnCreateAnAccountBtn(){
		CreateAnAccountBtn.click();
		return new CreateAnAccountPage(driver);
	}
	
	public void SignInEmail(String email){
		SignInEmail.clear();
		SignInEmail.sendKeys(email);
	}
	
	public void SignInPassword(String password){
		SignInPassword.clear();
		SignInPassword.sendKeys(password);
	}
	
	public MyAccountPage clickSignInBtn(){
		SignInBtn.click();
		return new MyAccountPage(driver);
	}
	
	public IndexPage clickOnHomeLogo(){
		HomeLogo.click();
		return new IndexPage(driver);
	}
	
	public Boolean ErrorBoxContains(String error){
		return ErrorBox.getText().contains(error);
	}
	
	public Boolean titleContains(String message){
		return driver.getTitle().equalsIgnoreCase(message);
	}


}
