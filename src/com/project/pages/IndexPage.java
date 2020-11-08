package com.project.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	Actions actions = null;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement SignIn;
	
	@FindBy(xpath = "//*[@id='search_query_top']")
	private WebElement SearchTextBox;
	
	@FindBy(xpath = "//*[@id='searchbox']/button")
	private WebElement SearchIcon;
	
	@FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/h5/a")
	private WebElement FeaturedItem;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement DressesLink;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement AddToCartBtn;
	
	@FindBy(xpath = "//*[@id='subcategories']/ul/li[1]/div[1]/a/img")
	private WebElement CasualDressesCat;
	
	@FindBy(xpath = "//*[@id='subcategories']/ul/li[2]/div[1]/a/img")
	private WebElement EveningDressesCat;
	
	@FindBy(xpath = "//*[@id='subcategories']/ul/li[3]/div[1]/a/img")
	private WebElement SummerDressesCat;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	private WebElement ContinueShoppingBtn;
	
	@FindBy(xpath = "//*[@id='columns']/div[1]/a[3]")
	private WebElement DressesNavLink;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	private WebElement ToBeHoveredForCartBtn;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	private WebElement ProceedToCheckoutBtn;	
	
	WebDriver driver;
	public IndexPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AuthenticationPage clickSignIn(){
		SignIn.click();
		return new AuthenticationPage(driver);
	}
	
	public void setSearchTextBox(String searchQuery){
		SearchTextBox.clear();
		SearchTextBox.sendKeys(searchQuery);
	}
	
	public SearchedPage clickOnSearchBtn(){
		SearchIcon.click();
		return new SearchedPage(driver);
	}
	
	public ProductPage clickOnFeaturedItem(){
		FeaturedItem.click();
		return new ProductPage(driver);
	}
	
	public void clickOnDresses(){
		DressesLink.click();
	}
	
	public void clickOnDressesNav(){
		DressesNavLink.click();
	}
	
	public void clickOnCasualDressesLink(){
		CasualDressesCat.click();
	}
	
	public void clickOnEveningDressesLink(){
		EveningDressesCat.click();
	}
	
	public void clickOnSummerDressesLink(){
		SummerDressesCat.click();
	}
	
	public void AddCartBtn(){
		AddToCartBtn.click();
	}
	
	public void mouseHover() throws InterruptedException{
		actions = new Actions(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ToBeHoveredForCartBtn);
		
		actions.moveToElement(ToBeHoveredForCartBtn).build().perform();
	}
	
	public void clickOnContinueShoppingBtn(){
		ContinueShoppingBtn.click();
	}
	
	public CartSummaryPage clickOnProceedBtn(){
		ProceedToCheckoutBtn.click();
		return new CartSummaryPage(driver);
	}
		
}
