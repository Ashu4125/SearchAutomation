package crm.qa.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import crm.qa.base.TestBase;
import crm.qa.pages.BasketPage;
import crm.qa.pages.CheckoutPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.pages.OrderReceivedPage;
import crm.qa.pages.ProductPage;
import crm.qa.util.TestUtil;

public class OrderReceivedPageTest extends TestBase {
	LoginPage loginPage;
	HomePage  homePage;
    TestUtil  testUtil;
    ProductPage productPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    OrderReceivedPage orderReceivedPage;
	
	public OrderReceivedPageTest() {
		super();
	}
	
	@BeforeSuite
	public void SetUp() {
		initialization();
		testUtil = new TestUtil();
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
		 orderReceivedPage.verifyOrderLabel();
	}
	
	  @AfterSuite
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 


}
