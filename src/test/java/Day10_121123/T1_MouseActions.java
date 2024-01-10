package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {

    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //run in headless mode (runs in the background)
//options.addArguments("headless");

        //ALWAYS Declare variable "driver" for the WebDriver and give the variable "driver" value
        WebDriver driver = new ChromeDriver(options);

        //I am telling "driver" to navigate to
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        //declare the mouse actions
        Actions mouseAction = new Actions(driver);

        //hover to Quick Tools Module
        WebElement quickTool = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        mouseAction.moveToElement(quickTool).perform();

        //click on track a package using mouse click
        WebElement tracPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        mouseAction.moveToElement(tracPackage).click().perform();

//type invalid tracking number on tracking search field
        Thread.sleep(5000);
        WebElement searchField  = driver.findElement(By.xpath("//*[@aid='tracking-input']"));
        //when the element is under textarea, you may need to click
        // on that text box first and then use sendKeys
        mouseAction.moveToElement(searchField).click().sendKeys("45623233223351523123").perform();



    }//end of class
}//end of main
