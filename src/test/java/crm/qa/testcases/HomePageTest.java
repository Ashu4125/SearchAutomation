package crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import crm.qa.base.TestBase;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.pages.ProductPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
  
	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "My Account – Automation Practice Site");
	}

	@Test(priority = 2)
	public void VerifyuserNameLabel() {
		Assert.assertTrue(homePage.verifyuserNameLabel());
	}
	
	@Test(priority = 3)
	public void ClickonButtonTest() {
		productPage = homePage.ClickonButtons();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
