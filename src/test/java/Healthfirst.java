import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Healthfirst extends TestParent {
public static void main(String[] args) throws InterruptedException {


    WebDriverManager.chromedriver().setup();
    //set chrome options arguments
    ChromeOptions options = new ChromeOptions();
    //set the condition to incognito mode
    options.addArguments("incognito");
    //set the condition to maximize/fullscreen your driver
    options.addArguments("start-maximized");
    //for mac use full screen
    //options.addArguments("start-fullscreen");
    //define the webdriver I am going to use
    WebDriver driver = new ChromeDriver(options);

driver.navigate().to("");
Reusable_Methods.clickMethod(driver,"//*[@class='button-common loc-btn button-blue']","clickbutton");
Thread.sleep(3000);
driver.quit();

}//
}//end of class
