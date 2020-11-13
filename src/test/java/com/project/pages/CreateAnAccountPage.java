package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage {
	@FindBy(xpath="//*[@id='id_gender1']")
	private WebElement TitleMr;

	@FindBy(xpath = "//*[@id='id_gender2']")
	private WebElement TitleMrs;
	
	@FindBy(id = "customer_firstname")
	private WebElement FirstNameTextBox; 
	
	@FindBy(id = "customer_lastname")
	private WebElement LastNameTextBox;
	
	@FindBy(id = "email")
	private WebElement EmailTextBox; 
	
	@FindBy(id = "passwd")
	private WebElement PasswordTextBox; 
	
	@FindBy(xpath = "//*[@id='days']")
	private WebElement DOB_date;
	
	@FindBy(xpath = "//*[@id='months']")
	private WebElement DOB_month;
	
	@FindBy(xpath = "//*[@id='years']")
	private WebElement DOB_year;
	
	@FindBy(xpath = "//*[@id='newsletter']")
	private WebElement NewsLetterCheckbox;
	
	@FindBy(xpath = "//*[@id='optin']")
	private WebElement SpecialOffersCheckbox;
	
	@FindBy(xpath = "//*[@id='address1']")
	private WebElement AddressTextBox;
	
	@FindBy(xpath = "//*[@id='address2']")
	private WebElement AddressLn2TextBox;
	
	@FindBy(xpath = "//*[@id='city']")
	private WebElement CityTextBox;
	
	@FindBy(xpath = "//*[@id='id_state']")
	private WebElement StateDropDown;
	
	@FindBy(xpath = "//*[@id='postcode']")
	private WebElement ZipCodeTextBox;
	
	@FindBy(xpath = "//*[@id='id_country']")
	private WebElement CountryDropDown;
	
	@FindBy(xpath = "//*[@id='other']")
	private WebElement AdditionalInfoTextBox;
	
	@FindBy(xpath = "//*[@id='phone']")
	private WebElement HomePhoneTextBox;
	
	@FindBy(xpath = "//*[@id='phone_mobile']")
	private WebElement MobileTextBox;
	
	@FindBy(xpath = "//*[@id='alias']")
	private WebElement AliasAddressTextBox;
	
	@FindBy(xpath = "//*[@id='submitAccount']/span")
	private WebElement RegisterBtn;
	
	@FindBy(xpath = "//*[@id='center_column']/div")
	private WebElement ErrorBox;
	
	WebDriver driver = null;
	public CreateAnAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitle(String title){
		if(title.equals("Mr.")){
			TitleMr.click();
			}
		else
			TitleMrs.click();
//		for(WebElement Title : TitleList){
//			System.out.println("Title is " + Title);
//			if(Title.getAttribute("value").trim().equals(title)){
//				if(!Title.isSelected()){
//					Title.click();
//					break;
//				}
//			}
//								
//		}
	}

	public void setFirstName(String FirstName) {
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(FirstName);
	}

	public void setLastName(String LastName) {
		LastNameTextBox.clear();
		LastNameTextBox.sendKeys(LastName);
	}

	public void setEmailTextBox(String email) {
		EmailTextBox.clear();
		EmailTextBox.sendKeys(email);
	}

	public void setPassword(String Password) {
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(Password);
	}

	public void setDOB_date(String date){
		Select dateDropDown = new Select(DOB_date);
		List<WebElement> j = dateDropDown.getOptions();
		for(WebElement i : j){
			if(i.getText().trim().equalsIgnoreCase(date))
				i.click();
//				dateDropDown.selectByVisibleText(i.getText());
		}
	}

	public void setDOB_month(String month){
		Select monthDropDown = new Select(DOB_month);
		List<WebElement> j = monthDropDown.getOptions();
		for(WebElement i : j){
			if(i.getText().trim().equalsIgnoreCase(month))
				i.click();
		}
	}

	public void setDOB_year(String year){
		Select yearDropDown = new Select(DOB_year);
		List<WebElement> j = yearDropDown.getOptions();
		for(WebElement i : j){
			if(i.getText().trim().equalsIgnoreCase(year))
				i.click();
		}
	}
	public void setNewsLetterCheckbox() {
		if(!NewsLetterCheckbox.isSelected())
			NewsLetterCheckbox.click();
	}

	public void setSpecialOffersCheckbox() {
		if(!SpecialOffersCheckbox.isSelected())
			SpecialOffersCheckbox.click();
	}

	public void setAddress(String address) {
		AddressTextBox.clear();
		AddressTextBox.sendKeys(address); 
	}

	public void setAddressLn2(String addressLn2) {
		AddressLn2TextBox.clear();
		AddressLn2TextBox.sendKeys(addressLn2);
	}

	public void setCity(String city) {
		CityTextBox.clear();
		CityTextBox.sendKeys(city);
	}

	public void setState(String state) {
		Select stDropDown = new Select(StateDropDown);
		List<WebElement> j = stDropDown.getOptions();
		for(WebElement i : j){
			if(i.getText().trim().equalsIgnoreCase(state))
				i.click();
		}
	}

	public void setZipCode(String zipCode) {
		ZipCodeTextBox.clear();
		ZipCodeTextBox.sendKeys(zipCode);
	}

	public void setCountry(String country) {
		Select ctryDropDown = new Select(CountryDropDown);
		List<WebElement> j = ctryDropDown.getOptions();
		for(WebElement i : j){
			if(i.getText().trim().equalsIgnoreCase(country))
				i.click();
		}
	}

	public void setMobile(String mobile) {
		MobileTextBox.clear();
		MobileTextBox.sendKeys(mobile);
	}
	
	public MyAccountPage clickRegisterBtn() {
		RegisterBtn.click();
		return new MyAccountPage(driver);
	}
	
	public boolean ErrorBoxContains(String error){
		return ErrorBox.getText().contains(error);
	}

}
