package com.TN.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.Pages.LandingPage;
import com.TN.Pages.ProductPage;
import com.TN.TestBase.TestBase;

public class SearchProductTest extends TestBase{

	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public ProductPage productpage;

	@BeforeMethod
	public void searchProductSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
	}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		landingpage = new LandingPage(driver);
		landingpage.enterValidProduct(dataprop.getProperty("validProduct"));
		landingpage.clickOnSearchButton();
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfHPLaptop());
	}
	
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		landingpage = new LandingPage(driver);
		landingpage.enterValidProduct(dataprop.getProperty("invalidProduct"));
		landingpage.clickOnSearchButton();
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfWarningMessage());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
