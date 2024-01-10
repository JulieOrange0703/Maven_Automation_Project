package Day8_120423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_Tabs {
    public static void main(String[] args) throws InterruptedException {
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

        //navigate to fidelis care site
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();

        //click on shop for a plan again inside the menu
        Thread.sleep(2000); //adding additional wait because we are getting element not interactable exception

        //
        driver.findElements(By.xpath("//*[text()='Shop for a Plan']")).get(0).click();

        //click on find a doctor button
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();
        Thread.sleep(5000);

        //call ArrayList function to store the tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to new tab 1
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);

        //enter a zipcode on search location field
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");
        Thread.sleep(3000);

        //close this new tab
        driver.close();

        //switch back to default tab
        driver.switchTo().window(tabs.get(0));

        Thread.sleep(3000);

        //click on find a doctor link from the bottom
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(1).click();
        Thread.sleep(3000);

        driver.close();

    }//end of main
}//end of class
