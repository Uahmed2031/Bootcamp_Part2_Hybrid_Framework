package com.TN.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.Pages.AccountPage;
import com.TN.Pages.LandingPage;
import com.TN.Pages.LoginPage;
import com.TN.TestBase.TestBase;

public class LoginTest extends TestBase{

	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public LoginPage loginpage;
	public AccountPage accountPage;

	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountDropdown();
		landingpage.clickOnLoginOption(); 
		
	}
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton(); // system navigate to AccoutPage
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.validateDisplayStatusOfLogoutLink());
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithValidEmailInvalidPassword() {	
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.retrieveInvalidLoginWarningText();
		String expectedWarningMessage = dataprop.getProperty("invalidLoginWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
