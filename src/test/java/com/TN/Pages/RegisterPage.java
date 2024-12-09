package com.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname") 
	private WebElement firstNameTextBox;	
	
	@FindBy(id = "input-lastname") 
	private WebElement lastNameTextBox;
	
	@FindBy(id = "input-email") 
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone") 
	private WebElement telephoneTextBox;
	
	@FindBy(id = "input-password") 
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm") 
	private WebElement confirmPasswordTextBox;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement yesSubscribeRadioButton;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[text() = 'Password confirmation does not match password!']")
	private WebElement incorrectConfirmPasswordWarning;
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String firstnameText) {
		firstNameTextBox.sendKeys(firstnameText);
	}
	
	public void enterLastName(String lastnameText) {
		lastNameTextBox.sendKeys(lastnameText);
	}	
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}
	
	public void selectYesSubscribeRadioButton() {
		yesSubscribeRadioButton.click();
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}
		
	public void clickOnContinueButton() {
		continueButton.click();
	}	
	
	public boolean displayStatusOfIncorrectConfirmPassword() {
		boolean displayStatus = incorrectConfirmPasswordWarning.isDisplayed();
		return displayStatus;
	}
	
}
