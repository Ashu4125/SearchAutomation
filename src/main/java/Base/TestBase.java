package Base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.TestUtil;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
public class TestBase {

    public static Properties prop;
    public static WebDriver driver;
    private static ScreenRecorder screenRecorder;
    public TestBase() {
        try {
            // Initialize properties object
            prop = new Properties();
            
            // Attempt to load config.properties from the classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config/config.properties");
            
            // Check if the properties file is found in the classpath
            if (inputStream == null) {
                System.out.println("config.properties file not found in classpath.");
                throw new RuntimeException("config.properties not found in the classpath");
            }
            
            // Load properties from the file
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading properties from config.properties file", e);
        }
    }

    public static void initialization() throws HeadlessException, IOException, AWTException {
        // Fetch browser name from the properties file
        String browserName = prop.getProperty("browser");
        File file = new File("TestRecordings");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(screenSize);

        screenRecorder = new ScreenRecorder(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(),
                captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file);

        screenRecorder.start();
        
        // Initialize driver based on the browser specified
        if ("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankur\\.cache\\selenium\\chromedriver\\win64\\130.0.6723.116\\chromedriver.exe");
        
            
            ChromeOptions options = new ChromeOptions();
            // Add the argument to disable the automation detection
            options.addArguments("--disable-blink-features=AutomationControlled");

            // Initialize the WebDriver with ChromeOptions
             driver = new ChromeDriver(options);
            
        } else {
            throw new RuntimeException("Unsupported browser specified in config.properties: " + browserName);
        }

        // Maximize browser window and delete all cookies
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        // Set timeouts for page load and implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        
        // Open the URL from the properties file
        driver.get(prop.getProperty("url"));
    }
    
    
    public static void quitBrowser() throws IOException
    
    {
    	screenRecorder.stop();
    	if (driver != null) {
            driver.quit();
        }
    }
   
}
