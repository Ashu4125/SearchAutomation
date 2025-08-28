package TestPage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.HomePage;
import Pages.ResultsPage;
public class FlightSearchTest extends TestBase {
    public HomePage homepage;
    public ResultsPage resultspage;

    
    public FlightSearchTest() {
        super(); 
    }

    @BeforeSuite
    public void setUp() throws HeadlessException, IOException, AWTException {
        initialization();
        homepage = new HomePage(driver);
    }

    @Test
    public void testClosePopup() {
        homepage.closePopup();
       
    }

    @Test
    public void testSearchFlights() throws IOException {
    	
        homepage.CLickOnFromLocation();
    	homepage.enterOriginCity("Goa");
    	homepage.enterDepartureCity("Mumbai");
    	homepage.selectDate("Jan 10 2025");
    	homepage.ClickOnTravellersTextBox();
    	homepage.selectAdult(2, "Adults");
    	homepage.ClickOnSearchFlightsButton();
    	boolean status =  homepage.PopupAfterFlightSearch();
    	Assert.assertEquals(true, status,"Search result display of flight");
      
    }
        @AfterSuite
        public void Close() throws IOException
        {
        	quitBrowser(); 
        	
           
        }
        
    }


