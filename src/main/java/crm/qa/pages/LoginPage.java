package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@title='Automation Practice Site']")
	WebElement atlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateatlogo() {
		return atlogo.isDisplayed();
	}

	public HomePage login(String un , String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
			
		return new HomePage();
	}
}
