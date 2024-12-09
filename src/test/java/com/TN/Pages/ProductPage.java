package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement HPLaptop;
	
	@FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement productWarning;
	
	@FindBy(xpath = "//span[text() = 'Add to Cart']")
	private WebElement addToCartButton;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean displayStatusOfHPLaptop() {
		boolean status = HPLaptop.isDisplayed();
		return status;
	}
	
	public boolean displayStatusOfWarningMessage() {
		boolean status = productWarning.isDisplayed();
		return status;
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	
}
