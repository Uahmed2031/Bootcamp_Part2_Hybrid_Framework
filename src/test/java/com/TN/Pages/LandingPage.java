package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountdropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchTextBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;	
	
		
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMyAccountDropdown() {
		MyAccountdropdown.click();
	}
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	public void clickOnRegisterOption() {
		registerOption.click();
	}
	
	public void enterValidProduct(String validProductText) {
		searchTextBox.sendKeys(validProductText);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	
	
	
}
