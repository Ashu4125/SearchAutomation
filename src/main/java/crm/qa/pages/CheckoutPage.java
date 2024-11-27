package crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import crm.qa.base.TestBase;

public class CheckoutPage extends TestBase{
      
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='billing_last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='billing_email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement PhnNo;
	
	@FindBy(xpath="//span[@class='select2-arrow']")
	WebElement CountryArrow;
	
	@FindBy(xpath="//div[@id='select2-result-label-1101']")
	WebElement India;
	
	@FindBy(xpath="//input[@id='billing_address_1']")
	WebElement Address;
	
	@FindBy(xpath="//input[@id='billing_city']")
	WebElement City;
	
	@FindBy(xpath="(//span[@role='presentation'])[2]")
	WebElement StatenameArrow;
	
	@FindBy(xpath="//div[@id='select2-result-label-1384']")
	WebElement UttarPradesh;
	
	@FindBy(xpath="//input[@id='billing_postcode']")
	WebElement PostCode;
	
	@FindBy(xpath="//input[@id='payment_method_cod']")
	WebElement Tickbtn;
	
	@FindBy(xpath="(//input[@id='place_order'])[1]")
	WebElement PlaceOrderbtn;
	
      public CheckoutPage() {	
		PageFactory.initElements(driver, this);
      } 
 
      public OrderReceivedPage FillDetails() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	  wait.until(ExpectedConditions.visibilityOf(FirstName));
    	  
    	  FirstName.sendKeys("Ashu");
    	  LastName.sendKeys("Sharma");
    	  Email.sendKeys("ashusharma6396gmail.com");
    	  PhnNo.sendKeys("6396525252");
    	  Address.sendKeys("Vill-PaliBegpur ,Dist- Bulandshahr");
    	  City.sendKeys("Bulandshahar");
    	  PostCode.sendKeys("203001");
    	  Tickbtn.click();
    	  doubleClick(PlaceOrderbtn);
    	  
    	  return new OrderReceivedPage();
    	  
      }
      
      private void doubleClick(WebElement element) {
          Actions actions = new Actions(driver);
          actions.doubleClick(element).perform();
      }
  
      
      
}
