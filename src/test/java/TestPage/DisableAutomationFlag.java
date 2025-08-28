package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomationFlag {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankur\\.cache\\selenium\\chromedriver\\win64\\130.0.6723.116\\chromedriver.exe");

        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Add the --disable-blink-features=AutomationControlled flag
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Optional: Suppress "Chrome is being controlled by automated software" banner
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to Goibibo
        driver.get("https://www.goibibo.com/");

        // Perform your automation tasks here

        // Close the browser
        driver.quit();
    }
}

