package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h2[text() = 'Returning Customer']")
	private WebElement returningCustomer;
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayReturningCustomer() {
		boolean status = returningCustomer.isDisplayed();
		return status;
	}
	
	
	
}
