package Day9_120523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class GEICOTESTING {
public static void main(String[] args) {


//setup the chromedriver with webdrivermanager
    WebDriverManager.chromedriver().setup();

    //declare the chrome options
    ChromeOptions options = new ChromeOptions();

    //add some options for chromeoptions
    options.addArguments("start-maximized");

    //run in headless mode (runs in the background)
    //options.addArguments("headless");
    //define the webdriver and pass the options argument
    WebDriver driver = new ChromeDriver(options);


     //navigate to Geico
        driver.navigate().to("https://sales.geico.com/quote");

    try{
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@id, 'labelFor')]")));

        ArrayList<WebElement> firstYes= new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id, 'labelFor')]")));
        firstYes.get(0).submit();
    }catch(Exception e) {
        System.out.println("Unable to click yes button for reason " + e);
    }
}//end of main
}//end of class
