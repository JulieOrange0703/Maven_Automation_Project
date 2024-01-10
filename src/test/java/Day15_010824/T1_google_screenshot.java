package Day15_010824;

import Day13_121923.TestParent;
import Day14_010224.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

public class T1_google_screenshot extends TestParent {

    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name= 'q']", "BMW", logger, "SearchField");
        //hit submit on the google search button
        Reusable_Methods_Loggers.submitMethod(driver, "//*[@name= 'btnKlp']", logger,"Submit");
        Thread.sleep(1000);
    }//end of test case 1


}
