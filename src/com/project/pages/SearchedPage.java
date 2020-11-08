package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedPage {
	@FindBy(xpath = "//*[@id='center_column']/h1/span[2]")
	private WebElement NumberOfItems;
	
//	@FindBy(className = "product-image-container")
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	private List<WebElement> ItemContainerByClass;
	
	@FindBy(xpath = "//*[@id='manufacturers_block_left']/div/ul/li/a")
	private WebElement ManufacturerLink;
	
	@FindBy(xpath = "////*[@id='center_column']/p")
	private WebElement NoResultsMessage;
	
	@FindBy(xpath = "//*[@id='center_column']/h1")
	private WebElement ProductsByManufacturerHeader;
	
	WebDriver driver =null;
	public SearchedPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfExpectedItems(){
		try{
		if(NoResultsMessage.isDisplayed())
			return 0;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		return Integer.parseInt(NumberOfItems.getText().replaceAll("[^0-9]", ""));
	}
	
	public int countNumberOfVisibleItems(){
		System.out.println("list : "+ItemContainerByClass);
//		for(WebElement i : ItemContainerByClass){
//			System.out.println(i.getText());
//		}
		return ItemContainerByClass.size();
	}
	
	public String clickOnManufacturerLink(){
		ManufacturerLink.click();
		return ManufacturerLink.getText();
	}
	
	public Boolean HeaderContains(String header){
		return ProductsByManufacturerHeader.getText().toUpperCase().contains(header.toUpperCase());
	}
}
