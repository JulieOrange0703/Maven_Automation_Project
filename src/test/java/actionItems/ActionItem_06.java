package actionItems;

import Day10_121123.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_06 {

    public static void main(String[] args) throws InterruptedException {

        //use reusable method to set up driver
        WebDriver driver = Reusable_Methods.setUpDriver();

        //.add is for adding values to a String ArrayList;.put is for hashmap
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11225");
        zipCodes.add("33579");
        zipCodes.add("10001");

        for (int i = 0; i < zipCodes.size(); i++) {

            //navigate to
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");


            Reusable_Methods.clickMethod(driver, "//*[@data-e2e-name='find_a workshop']", "Find A Workshop");

            Reusable_Methods.clickMethod(driver, "//*[text()= 'In-Person']", "In-Person Link");

            Reusable_Methods.clickMethod(driver, "//*[@id='location-search']", "Zip Code Field");

            Reusable_Methods.sendKeysMethod(driver, "//*[@id='location-search']", zipCodes.get(i), "Zip Code Field");

            Reusable_Methods.clickMethod(driver,"//*[@id='location-search-cta']","Location Search");

            //create an array list using web element for "studioLocationLinks" and give it value for those links
            ArrayList<WebElement> studioLocationLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

//create if statement for each iteration listed in AI

//use == to write about logic, this is why i am NOT using i=0 this means the value of i is 0
            //create if logic for how I want it to click studio links
            if (i == 0) {
                Reusable_Methods.clickByIndexMethod(driver,"//*[@class='linkUnderline-1_h4g']",1,"Studio Link");
            } else if (i == 1) {
                Reusable_Methods.clickByIndexMethod(driver,"//*[@class='linkUnderline-1_h4g']",2,"Studio Link");
            } else if (i == 2) {
                Reusable_Methods.clickByIndexMethod(driver,"//*[@class='linkUnderline-1_h4g']",0,"Studio Link");
            }

            //get text of studio name and address
            String studioNameResult = Reusable_Methods.getTextMethod(driver,"//*[@class='locationName-1jro_']","Studio Result Name");

            String studioScheduleTableResult = Reusable_Methods.getTextMethod(driver,"//*[@id='studioWorkshopSchedule']","Studio Result Name");

            //use reusable method for scroll into Element and go to studio schedule table
            Reusable_Methods.scrollIntoElement(driver,"//*[@id='studioWorkshopSchedule']","Studio Schedule Table");

            System.out.println("The schedule for" + " " + studioNameResult + " is " + studioScheduleTableResult);

            driver.quit();

        }//end of loop
    }//end of main
}//end of class