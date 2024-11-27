package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import crm.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	@FindBy(xpath="//button[@class='single_add_to_cart_button button alt']")
	WebElement AddtoBasketbtn;
	
	@FindBy(xpath="//a[@class='button wc-forward']")
	WebElement ViewBasketbtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public BasketPage ClickonButtons() {
		Actions actions = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(AddtoBasketbtn));
		actions.doubleClick(AddtoBasketbtn).perform();
		
		wait.until(ExpectedConditions.visibilityOf(ViewBasketbtn));
		actions.doubleClick(ViewBasketbtn).perform();		
		return new BasketPage();
	} 
	
	public String verifyProductPageTitle() {
        return driver.getTitle();
	}

}
