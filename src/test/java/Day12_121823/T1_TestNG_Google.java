package Day12_121823;

import Day10_121123.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_TestNG_Google {

    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver(){
        driver = Reusable_Methods.setUpDriver();
    }//end of before suite

    @Test (priority = 1)
    public void searchForACar() {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");

        //search for BMW
        Reusable_Methods.sendKeysMethod(driver, "//*[@name= 'q']", "BMW", "SearchField");

        //hit submit on the google search button
        Reusable_Methods.submitMethod(driver, "//*[@name='btnK']", "Submit");

    }//end of testcase1


    @Test(priority = 2)
    public void getTextMethod(){
        //store the search result into a string variable
        String result = Reusable_Methods.getTextMethod(driver,"//*[@id = 'result-stats']", "Search Result");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is" + searchResultArray[1]);
    }//end of test case 2

}
