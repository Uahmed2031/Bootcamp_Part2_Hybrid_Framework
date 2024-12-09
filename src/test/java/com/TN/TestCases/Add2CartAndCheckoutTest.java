package com.TN.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.Pages.Add2CartPage;
import com.TN.Pages.CheckoutPage;
import com.TN.Pages.LandingPage;
import com.TN.Pages.ProductPage;
import com.TN.Pages.ShoppingCartPage;
import com.TN.TestBase.TestBase;

public class Add2CartAndCheckoutTest extends TestBase{

	public Add2CartAndCheckoutTest() throws Exception {
		super();
		
	}
	
	public WebDriver driver;
	public LandingPage landingpage;
	public ProductPage productpage;
	public Add2CartPage add2cartpage;
	public ShoppingCartPage shoppingcartpage;
	public CheckoutPage checkoutpage;
	
	@BeforeMethod
	public void Setup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));		
	}
	
	@Test
	public void addValidProductToCart() {
		landingpage = new LandingPage(driver);
		landingpage.enterValidProduct(dataprop.getProperty("validProduct"));
		landingpage.clickOnSearchButton();
		
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfHPLaptop());
		productpage.clickOnAddToCartButton();
		add2cartpage = new Add2CartPage(driver);
		add2cartpage.clickOnAddToCartButton();
		Assert.assertTrue(add2cartpage.displayStatusOfSuccessMessage());
		
		shoppingcartpage = new ShoppingCartPage(driver);
		shoppingcartpage.clickOnShoppingCartLink();
		Assert.assertTrue(shoppingcartpage.displayStatusOfHPLaptop());
		shoppingcartpage.clickOnCheckoutLink();
		
		checkoutpage = new CheckoutPage(driver);
		checkoutpage.displayReturningCustomer();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
