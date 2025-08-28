package util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
	
    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        
        if (driver == null) {
            System.out.println("Driver is null. Screenshot cannot be taken.");
            return;
        }

        // Capture the screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Get current project directory
        String currentDir = System.getProperty("user.dir");
        
        // Ensure the screenshots directory exists, create if not
        File screenshotDir = new File(currentDir + "/screenshots/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir(); // Create the directory if it does not exist
        }

        // Define the destination file name using timestamp
        File destinationFile = new File(screenshotDir + "/" + System.currentTimeMillis() + ".png");

        // Copy the screenshot to the destination file
        FileUtils.copyFile(scrFile, destinationFile);

        // Optionally, log the location of the saved screenshot
        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
    }
    
   
}
