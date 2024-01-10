package Day8_120423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
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
        driver.navigate().to("https://www.mortgagecalculator.org/");

        //wait 3 seconds
        Thread.sleep(3000);


        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeVal.clear();
        homeVal.sendKeys("45000");

        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("9000");

        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        Select startMonthDropdown = new Select(startMonth);

        startMonthDropdown.selectByVisibleText("Jan");
        startMonthDropdown.selectByVisibleText("Dec");

    }//end of main

}//end of class
