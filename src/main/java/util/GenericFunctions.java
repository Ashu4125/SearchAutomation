package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions {
	
	
	public void ElementToBeClickCheck(WebDriver driver, WebElement ele ,int timeOut)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	}		

}
