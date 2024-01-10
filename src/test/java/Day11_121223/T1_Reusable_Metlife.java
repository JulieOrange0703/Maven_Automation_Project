package Day11_121223;

import Day10_121123.Reusable_Methods;
import org.openqa.selenium.WebDriver;

public class T1_Reusable_Metlife {
    public static void main(String[] args) {
        //instantiate the driver
        WebDriver driver = Reusable_Methods.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.metlife.com/");

        //click on the solutions tab
        Reusable_Methods.clickMethod(driver, "//*[@aria-controls = 'section1']", "Solutions Tab");
        //click on the dental menu
        Reusable_Methods.clickMethod(driver, "//*[text() = 'Dental']", "Solutions Tab");
        //quit the driver
        driver.quit();
    }//end of main

}//end of class
