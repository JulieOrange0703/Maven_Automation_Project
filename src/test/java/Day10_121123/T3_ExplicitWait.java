package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class T3_ExplicitWait {
    public static void main(String[] args) {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        //run in headless mode (runs in the background)
//options.addArguments("headless");

        //ALWAYS Declare variable "driver" for the WebDriver and give the variable "driver" value
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver,10);

        //declare your explicit wait statement here
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

//navigate to google site
        driver.navigate().to("https://www.google.com");

        //search for a car
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='q']"))).sendKeys("cars");
        }catch (Exception e){
            System.out.println("Unable to enter value on search field: " + e);
        }//end of search exception

        //submit
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='btnK']"))).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on search button: " + e);
        }//end of submit exception
//capture the result and print it
        try{
            String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='result-stats']"))).getText();
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);

        }//end of search result exception
}//end of main
}//end of class
