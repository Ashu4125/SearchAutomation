package crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import crm.qa.util.TestUtil;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;
 
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found: " + System.getProperty("user.dir") + "/src/main/java/crm/qa/config/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading properties from file: " + System.getProperty("user.dir") + "/src/main/java/crm/qa/config/config.properties");
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankur\\.cache\\selenium\\chromedriver\\win64\\130.0.6723.116\\chromedriver.exe");
            driver = new ChromeDriver();
        }

         
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }
}
