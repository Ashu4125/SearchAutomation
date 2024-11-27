package crm.qa.testcases;

import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.pages.ProductPage;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import crm.qa.base.TestBase;
import crm.qa.pages.BasketPage;

public class ProductPageTest extends TestBase{

	LoginPage loginPage;
	HomePage  homePage;
	ProductPage productPage;
	BasketPage basketPage;
	
	public ProductPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),  prop.getProperty("password"));
		productPage = new ProductPage(); 
	    basketPage = new BasketPage(); 
	}
		@Test
		public void ClickonButtonTest() {
		productPage = homePage.ClickonButtons();
	    basketPage = productPage.ClickonButtons();
	   
	}
	
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
      }
	 
}
