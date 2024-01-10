package Day13_121923;

import Day10_121123.Reusable_Methods;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends TestParent{
//the word EXTENDS TESTPARENT IS VERY IMPORTANT
    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods.sendKeysMethod(driver, "//*[@name= 'q']", "BMW", "SearchField");
        //hit submit on the google search button
        Reusable_Methods.submitMethod(driver, "//*[@name= 'btnK']", "Submit");
        Thread.sleep(1000);
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_searchForACar")
    public void tc002_captureSearchResult() {
        //store the search result into a string variable
        String result = Reusable_Methods.getTextMethod(driver, "//*[@id = 'result-stats']", "SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
    }//end of test case 2

}//end of class
