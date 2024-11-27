package crm.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import crm.qa.base.TestBase;

public class BasketPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Selenium Ruby')]")
	WebElement Productlabel;
	
	@FindBy(xpath="//a[contains(text(), 'Proceed to Checkout')]")
	WebElement ProceedToCheckoutbtn;
	
	public BasketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage Clickbutton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(ProceedToCheckoutbtn));
        ProceedToCheckoutbtn.click();
		
		return new CheckoutPage();
	}
	
	

}
