package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem_03 {
    public static void main(String[] args) throws InterruptedException {

//setup the chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();

//define webdriver
        WebDriver driver = new ChromeDriver();

        // wait 2 seconds
        Thread.sleep(2000);

//values for sports variable in new arraylist
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Volleyball");
        sports.add("Soccer");
        sports.add("Pickleball");
        sports.add("Golf");
        sports.add("Swimming");

        for(int i = 0;i < sports.size();i++){

//wait 3 seconds
            Thread.sleep(3000);

            //navigate to bing home page
            driver.navigate().to("https:www.bing.com");

//maximize the window
            driver.manage().window().maximize();

            //search for each sport using relative x path
            //x path is finding the location of the element for the search field
            //this code tells the system to send the keys of the value in sports variable listed above
            driver.findElement(By.xpath("//*[@name= 'q'] ")).sendKeys(sports.get(i));

            //hit submit for search results
            driver.findElement(By.xpath("//*[@id='sb_form_q'] ")).submit();

            Thread.sleep(2000);

//capture the search results message using getText
            String searchResult = driver.findElement(By.xpath("//*[@id= 'b_tween']")).getText();

//use split method to get the number only and print it
            String[] arrayResult = searchResult.split(" ");

//After message is split, print out only the search number for each value
            System.out.println("My search number for sports " + sports.get(i) + " " + "is" + " " + arrayResult[1]);

        }//end of for loop

//quit the driver
        driver.quit();

    }//end of main
} //end of class
