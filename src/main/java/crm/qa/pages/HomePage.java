package crm.qa.pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//strong[normalize-space()='ashusharma6396']")
	WebElement userNameLabel;
	
	@FindBy(xpath=" //a[normalize-space()='Shop']")
	WebElement Shopbtn;
	
	@FindBy(xpath="//h3[normalize-space()='Selenium Ruby']")
	WebElement Productbtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyuserNameLabel() {
		 return userNameLabel.isDisplayed();
	}
     
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ProductPage ClickonButtons() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(Shopbtn));
        Shopbtn.click();
        
        scrollDown();
        
        wait.until(ExpectedConditions.visibilityOf(Productbtn));
        Productbtn.click();
		
		return new ProductPage();
	}

	private void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);"); 		
	}

}
