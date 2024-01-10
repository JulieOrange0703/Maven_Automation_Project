package Day8_120423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SelectBy_XpathText {

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

        //navigate to yahoo
        driver.navigate().to("https://www.mortgagecalculator.org/");

        Thread.sleep(3000);

        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeVal.clear();
        homeVal.sendKeys("45000");

        //click on dropdown
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();

        driver.findElement(By.xpath("//*[text()='Jan']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Dec']")).click();

        Thread.sleep(4000);

        driver.quit();

    }//end of main

}//end of class
