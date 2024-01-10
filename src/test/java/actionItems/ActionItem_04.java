package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.DriverManager;
import java.util.ArrayList;

public class ActionItem_04 {
public static void main(String[] args) throws InterruptedException {

    //declare what driver you are using; browsing platforms
    WebDriverManager.chromedriver().setup();

    //set up chrome options variable "options"
    ChromeOptions options = new ChromeOptions();

    //Add options to chrome options, have browser open on start-maximized
    options.addArguments("start-maximized");

    //Add options to incognito, this puts google into incognito mode
    options.addArguments("incognito");

    //declare the webdriver variable and set up as chrome options
    WebDriver driver = new ChromeDriver(options);


    //.add is for adding values to a String ArrayList;.put is for hashmap
    ArrayList<String> zipCodes = new ArrayList<>();
    zipCodes.add("11225");
    zipCodes.add("33579");
    zipCodes.add("10001");

    for (int i = 0; i < zipCodes.size(); i++) {

        //navigate to
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

//sleep for 3 seconds
        Thread.sleep(1000);

        WebElement findaworkshop = driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']"));
        findaworkshop.click();

        //sleep for 3 seconds
        Thread.sleep(1000);

        //declare webelement "In person link" as a variable and give it a x path value
        WebElement inPersonLink = driver.findElement(By.xpath("//*[text()= 'In-Person']"));
        inPersonLink.click();

        //sleep for 3 seconds
        Thread.sleep(1000);

        //declare webelement "In zipCodeField" as a variable and give it a x path value
        WebElement zipCodeField = driver.findElement(By.xpath("//*[@id='location-search']"));

        //click the zipcode field
        zipCodeField.click();
        Thread.sleep(1000);

        //clear the zipcode field
        zipCodeField.clear();

        //send keys into the zip code field
        zipCodeField.sendKeys(zipCodes.get(i));
        Thread.sleep(2000);

        //declare webelement "location search" as a variable and give it a x path value
        WebElement locationSearch = driver.findElement(By.xpath("//*[@id='location-search-cta']"));
       locationSearch.click();

       //sleep for 2 seconds
        Thread.sleep(2000);

        //create an array list using web element for "studioLocationLinks" and give it value for those links
ArrayList<WebElement> studioLocationLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

//create if statement for each iteration listed in AI

//use == to write about logic, this is why i am NOT using i=0 this means the value of i is 0
        //create if logic for how I want it to click studio links
        if (i == 0) {
            studioLocationLinks.get(1).click();
        } else if (i == 1) {
           studioLocationLinks.get(2).click();
        } else if (i == 2) {
            studioLocationLinks.get(0).click();
        }

        //sleep for two seconds
        Thread.sleep(2000);

        //declare webelement "studio result name" as a variable and give it a x path value
        WebElement studioResultName = driver.findElement(By.xpath("//*[@class='locationName-1jro_']"));

        //declare webelement "studio result address" as a variable and give it a x path value
        WebElement studioResultAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']"));

        //print out studio name and address
        System.out.println("The address for " + studioResultName.getText() + " is " + studioResultAddress.getText());
        Thread.sleep(2000);

        //Declare javascript executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //wait 2 seconds
        Thread.sleep(2000);

        //declare webelement "studio schedule table" as a variable and give it a x path value
        WebElement studioScheduleTable = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));

        //scroll into web element for studio schedule table
        jse.executeScript("arguments[0].scrollIntoView(true);", studioScheduleTable);

        //Print out the schedule with the studio name and table
        //wheelchair comment prints also because thats information provided in the box of the xpath
System.out.println("The schedule for" + " " + studioResultName.getText() + " is " + studioScheduleTable.getText());
    }//end of loop

}//end of main
}//end of class

