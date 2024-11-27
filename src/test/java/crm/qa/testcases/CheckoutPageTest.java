package crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import crm.qa.base.TestBase;
import crm.qa.pages.BasketPage;
import crm.qa.pages.CheckoutPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.pages.OrderReceivedPage;
import crm.qa.pages.ProductPage;


public class CheckoutPageTest extends TestBase {
	LoginPage loginPage;
	HomePage  homePage;
    ProductPage productPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    OrderReceivedPage orderReceivedPage;

	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),  prop.getProperty("password"));
		productPage = new ProductPage(); 
	    basketPage = new BasketPage();
	    checkoutPage = new CheckoutPage();
	    orderReceivedPage = new OrderReceivedPage();
	}
	@Test
	public void clickonButtonTest() {
		 productPage = homePage.ClickonButtons();    
		 basketPage = productPage.ClickonButtons();
		 checkoutPage = basketPage.Clickbutton(); 
		 orderReceivedPage = checkoutPage.FillDetails();
	}
	
	@AfterMethod
	 public void tearDown() {
		 driver.quit();
     }

	
}