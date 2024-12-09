package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add2CartPage {

	public WebDriver driver;
	
	@FindBy(id = "button-cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	private WebElement successMessage;
	
	
	
	public Add2CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
			
	public boolean displayStatusOfSuccessMessage() {
		boolean status = successMessage.isDisplayed();
		return status;
	}
	
	
}
