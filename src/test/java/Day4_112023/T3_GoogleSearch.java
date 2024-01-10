package Day4_112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException{
        //setup the chromedrive with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to google webpage
        driver.navigate().to("https://www.rakuten.com");

        //maximize the driver
        driver.manage().window().maximize();

        //pause current thread for 3 seconds
        Thread.sleep(3000);

        //quit the browser
        driver.quit();



    }//end of main
}//end of class
