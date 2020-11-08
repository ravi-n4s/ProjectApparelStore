package com.project.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver = null;
	@FindBy(xpath = "//*[@id='product_comments_block_extra']/ul/li/a")
	private WebElement WriteAReviewLink;
	
	@FindBy(className = "star")
	private List<WebElement> QualityRating;
	
	@FindBy(xpath = "//*[@id='comment_title']")
	private WebElement ReviewTitleTextBox;
	
	@FindBy(xpath = "//*[@id='content']")
	private WebElement ReviewCommentTextBox;
	
	@FindBy(xpath = "//*[@id='submitNewMessage']/span")
	private WebElement SendBtn;
	
	@FindBy(xpath = "//*[@id='new_comment_form_footer']/p[2]/a")
	private WebElement CancelLink;
	
	@FindBy(xpath = "//*[@id='product']/div[2]/div/div/div/p[1]")
	private WebElement PopupMessagePostReviewSubmit;
	
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[1]")
	private WebElement TweetBtn;
	
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[2]")
	private WebElement FacebookShareBtn;
	
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[3]")
	private WebElement GooglePlusShareBtn;
	
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[4]")
	private WebElement PinterestBtn;
	
	public ProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clikOnReviewLink(){
		WriteAReviewLink.click();
	}
	
	public void setReviewTitle(String title){
		ReviewTitleTextBox.clear();
		ReviewTitleTextBox.sendKeys(title);
	}
	
	public void setReviewComment(String comment){
		ReviewCommentTextBox.clear();
		ReviewCommentTextBox.sendKeys(comment);
	}
	
	public void qualityRating(String rating){
		for(WebElement star : QualityRating){
			if(star.getText().trim().equalsIgnoreCase(rating))
				star.click();
		}
	}
	
	public void clickSendBtn(){
		SendBtn.click();
	}
	
	public Boolean PopupContains(String message){
		return PopupMessagePostReviewSubmit.getText().toLowerCase().contains(message.toLowerCase());
	}
	
	public void clickTweetBtn(){
		TweetBtn.click();
	}
	
	public void clickFShareBtn(){
		FacebookShareBtn.click();
	}
	
	public void clickGooglePlusBtn(){
		GooglePlusShareBtn.click();
	}
	
	public void clickPinterestBtn(){
		PinterestBtn.click();
//		return new PinterestPage(driver);
	}
	
	static String ParentWindow = null;
	public PinterestPage switchToPinterestPage(){
		
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i1 = s.iterator();
		ParentWindow = driver.getWindowHandle();
		String ChildWindow = null;
		while(i1.hasNext()){
			ChildWindow = i1.next();
			if(!ParentWindow.equals(ChildWindow))
			{
//				System.out.println("current window handle : "+driver.getWindowHandle());
				driver.switchTo().window(ChildWindow);
				break;
			}
		}		
		return new PinterestPage(driver);
	}
	
	public GooglePlusPage switchToGooglePlusPage(){
		
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i1 = s.iterator();
		ParentWindow = driver.getWindowHandle();
		String ChildWindow = null;
		while(i1.hasNext()){
			ChildWindow = i1.next();
			if(!ParentWindow.equals(ChildWindow))
			{
//				System.out.println("current window handle : "+driver.getWindowHandle());
				driver.switchTo().window(ChildWindow);
				break;
			}
		}
		
		return new GooglePlusPage(driver);
	}
	
	public FacebookPage switchToFacebookPage(){
		
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i1 = s.iterator();
		ParentWindow = driver.getWindowHandle();
//		System.out.println("Parent : "+ParentWindow);
		String ChildWindow = null;
		while(i1.hasNext()){
			ChildWindow = i1.next();
			if(!ParentWindow.equals(ChildWindow))
			{
//				System.out.println("current window handle : "+driver.getWindowHandle());
				driver.switchTo().window(ChildWindow);
				break;
			}
		}
		
		return new FacebookPage(driver);
	}

	public void getHandleBack(){
		System.out.println("printing in get Handle function :"+ParentWindow);
		driver.switchTo().window(ParentWindow);
		ParentWindow = null;
//		return new ProductPage(driver);
	}
	
	public Boolean verifyUrl(String str){
		return driver.getCurrentUrl().contains(str);
	}
}