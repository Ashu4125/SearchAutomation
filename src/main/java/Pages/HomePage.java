package Pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.TestBase;
import util.GenericFunctions;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//span[@role='presentation']")
	WebElement closepopup;
	
	@FindBy(xpath = "(//span[contains(text(), 'From')])[1]")
	WebElement FromLocationTextbox;
    
    @FindBy(xpath = "//span[text()='From']/following-sibling::input")
    WebElement enterOriginplace;
    
    @FindBy(xpath ="(//span[contains(text(), 'To')])[1]")
    WebElement ToClickLocationTextbox;
    
    @FindBy(xpath = "//span[text()='To']/following-sibling::input")
    WebElement enterDestinationlace; 
    
    @FindBy(xpath ="//span[contains(text(), 'Departure')]")
    WebElement DeparturedateTextbox;
    
    
    @FindBy(xpath = "//span[contains(text(),'Travellers & Class')]")
    WebElement ClickTravellersTextBox;
    
    @FindBy(xpath = "//span[text()='SEARCH FLIGHTS']")
    WebElement searchFlightsBtn;
    
    @FindBy(xpath = "//span[contains(text(), 'Got it!')]//parent::button")
    WebElement AfterSearchPopup;
    
    
   
    public WebDriverWait wait;
    GenericFunctions genefun = new GenericFunctions();
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    
    }
	
    public void closePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(closepopup));
        closepopup.click();

        // Switch back to default content after interacting with the popup
        driver.switchTo().defaultContent();
    }
    
    public void CLickOnFromLocation() {
    	genefun.ElementToBeClickCheck(driver,FromLocationTextbox,10);
    	FromLocationTextbox.click();
    }
  //div[contains(@aria-label, 'Jan 06 2025') and contains(@class,'DayPicker')]
    public void enterOriginCity(String FromCity) {
    	enterOriginplace.sendKeys(FromCity);
        WebElement EnterOriginCity = driver.findElement(By.xpath("//span[contains(text(),'"+ FromCity +"')]/ancestor::li"));
        wait.until(ExpectedConditions.elementToBeClickable(enterOriginplace));
        EnterOriginCity.click();
        
    }
    
    public void ClickOnTOLocation() {
    	ToClickLocationTextbox.click();
    }

    public void enterDepartureCity(String ToCity) {
    	enterDestinationlace.sendKeys(ToCity);
        WebElement EnterDestinationCity = driver.findElement(By.xpath("//span[contains(text(),'"+ ToCity +"')]/ancestor::li"));
        EnterDestinationCity.click();
        
    }
    
    public void selectDate(String selectDate) {	
        wait.until(ExpectedConditions.elementToBeClickable(DeparturedateTextbox));
        DeparturedateTextbox.click();
        WebElement SelectDate = driver.findElement(By.xpath("//div[contains(@aria-label, '" + selectDate + "') and contains(@class,'DayPicker')]"));
        SelectDate.click();
         
    }
    
    public void ClickOnTravellersTextBox() {
    	wait.until(ExpectedConditions.elementToBeClickable(ClickTravellersTextBox));
    	ClickTravellersTextBox.click();
    }
    
    public void selectAdult( int adultCount  ,String paxtype )
    
    {
    	for(int i=2; i<=adultCount; i++) {
    	WebElement travellers = driver.findElement(By.xpath("//p[text()='" + paxtype + "']/parent::div//span[3]")); 
    	travellers.click();
    	}	
    }
    
    public ResultsPage ClickOnSearchFlightsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsBtn));
        searchFlightsBtn.click();
        return new ResultsPage(driver); 
    }
        
        public boolean   PopupAfterFlightSearch(){
        	
        	boolean  status = false;
       
	        wait.until(ExpectedConditions.elementToBeClickable(AfterSearchPopup));
	        status= AfterSearchPopup.isDisplayed();
	        AfterSearchPopup.click();

        	return status;
        }

}

