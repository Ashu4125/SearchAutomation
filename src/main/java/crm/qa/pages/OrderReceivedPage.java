package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import crm.qa.base.TestBase;

public class OrderReceivedPage extends TestBase {
	
	@FindBy(xpath="//p[@class='woocommerce-thankyou-order-received']")
	WebElement CnfOrdr;
	
	public OrderReceivedPage() {	
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrderLabel() {
		 return CnfOrdr.isDisplayed();
		 
	
	}
	
}
