package Day7_112823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_WebElement {
    public static void main (String[] args) throws InterruptedException {

        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //open in incognito mode
        options.addArguments("incognito");

        //run in headless mode (runs in the background)
//        options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo
        driver.navigate().to("https://www.mortgagecalculator.org/");

        //store the home value into web element website
        //JULIES COMMENT: web element is more professional to use
        //FIND WEB ELEMENT "HOME VALUE" BY ITS ID
        //Web Elements are: buttons,text fields, checkboxes and more
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));

        //clear the homevalue field
        //PERFORM ACTION OF CLEAR ON THE WEB ELEMENT "HOME VALUE"
        homeValue.clear();

        //type in 9000000 in the home value field
        //SENDS A SEQUENCE OF KEYSTROKES TO THE WEB ELEMENT, USUALLY USED TO ENTER TEXT INTO INPUT FIELDS
        homeValue.sendKeys("900000");

        //wait 2 seconds
        Thread.sleep(2000);

        //quit the breaker
        driver.quit();

    }//end of main
}//end of class
