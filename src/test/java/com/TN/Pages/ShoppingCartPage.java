package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public WebDriver driver;
	
	@FindBy(linkText = "Shopping Cart")
	private WebElement shoppingCartLink;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement HPLaptop;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutLink;
	
	
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnShoppingCartLink() {
		shoppingCartLink.click();
	}
	
	public boolean displayStatusOfHPLaptop() {
		boolean status = HPLaptop.isDisplayed();
		return status;
	}
	
	public void clickOnCheckoutLink() {
		checkoutLink.click();
	}
	
}


