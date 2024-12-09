package com.TN.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.TN.Pages.AccountSuccessPage;
import com.TN.Pages.LandingPage;
import com.TN.Pages.RegisterPage;
import com.TN.TestBase.TestBase;
import com.TN.Utilities.Utils;

public class RegisterTest extends TestBase{

	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void registerSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountDropdown();
		landingpage.clickOnRegisterOption();
	}
	
	@Test(priority=1)
	public void verifyRegisterWithMandatoryDetails() {
		
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Utils.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnContinueButton(); //navigates to Account Success Page
		accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccess());
		
	}
		
	@Test(priority=2)
	public void verifyRegisterWithIncorrectConfirmPassword() {
		registerpage = new RegisterPage(driver);	
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Utils.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("invalidPassword"));
		registerpage.selectYesSubscribeRadioButton();
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.displayStatusOfIncorrectConfirmPassword());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
