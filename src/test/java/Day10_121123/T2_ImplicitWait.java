package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {
    public static void main(String[] args) throws InterruptedException {
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

        //declare your implicit wait statement here
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //I am telling "driver" to navigate to
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);

        //search for a car
        try{
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        }catch (Exception e){
            System.out.println("Unable to enter value on search field: " + e);
        }//end of search exception

        //submit
        try{
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on search button: " + e);
        }//end of submit exception
//capture the result and print it
        try{
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);
        }//end of search result exception

}//end of main
}//end of class


//Implicit Wait, applied globally to the entire script. This wait time is for all elements.
//waits for the presence of elements
//Explicit Wait, applied to a specific condition. This wait time is used for a particular element and condition.
//This is flexible, it waits for different condition ex: visibility,presence, clickability

//Explicit waits for more precise control over the synchronization in my automation scripts. Explicit is more powerful and specific