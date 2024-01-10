package Day7_112823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_Scroll {
public static void main(String[] args) throws InterruptedException {

    //you declare what driver you are using; browsing platforms
    WebDriverManager.chromedriver().setup();

    //declare the chrome options variable
    ChromeOptions options = new ChromeOptions();

    //add some options for chromeoptions
    options.addArguments("start-maximized");

    //open in incognito mode
    options.addArguments("incognito");
    //run in headless mode (runs in the background)
//        options.addArguments("headless");

    //define the webdriver with browsing platforms "Chrome" and pass the options argument
    //driver is the variable, it can say WebDriver benji
    WebDriver driver = new ChromeDriver(options);

    //navigate to yahoo
    //benji.navigate
    driver.navigate().to("https://www.mlcalc.com/");

    //declare javascript Executor
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    // scroll down 1500 pixels based on your need you can adjust the # by + or - 200
    jse.executeScript("scroll(0,1500)");
    //js.executeScript("window.scrollBy(0,1000)"); Scroll vertically down by 1000 pixels
    //wait 2 seconds
    Thread.sleep(2000);
    //scroll up to 400 pixels
    jse.executeScript("scroll(0,-400)");
    //wait 2 seconds
    Thread.sleep(2000);

    //store the calculate button in webelement variable
    WebElement calcbutton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
    //scroll into element
    jse.executeScript("arguments[0].scrollIntoView(true);", calcbutton);
    //wait 2 seconds
    Thread.sleep(2000);
    //quit driver
    driver.quit();
}//end of main
}//end of class
