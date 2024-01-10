package Day6_112723;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void  main(String[] args) throws InterruptedException {

        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //open in cognito mode
        options.addArguments("incognito");

        //run in headless more
        options.addArguments("headless");

        //define the webdriver and pass the options argument
        //open chrome browser the way i want you to base on the options i provided above
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");

        //wait 3 seconds
        Thread.sleep(300);

        //quit the driver
        driver.quit();


    }//end of main


}//end of class
