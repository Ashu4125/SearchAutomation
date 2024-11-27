package crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import crm.qa.base.TestBase;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;

 public class LoginpageTest extends TestBase {
	 LoginPage loginPage;
	 HomePage homePage;
	public LoginpageTest() {
		super();	
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
	  loginPage = new LoginPage();  
	}
	
	@Test(priority=1)
	public void atlogoTest() {
		boolean flag = loginPage.validateatlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void loginTest() {
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
