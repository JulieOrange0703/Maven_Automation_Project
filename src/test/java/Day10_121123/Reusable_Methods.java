package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class Reusable_Methods {

    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        //we need to be able to use the driver to interact with other web elements, we need to
//return a driver to use that driver to interact with Webelement *JULIE*
        WebDriverManager.chromedriver().setup();
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return a driver instance
        return driver;
    }//end of setupdriver method


    //create a click method to click on any web element
    //static allows me to call the code on another class
    //void methods have no return values. just executes
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }//end of click method

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
        }
    }//end of submit method

    public static String getTextMethod(WebDriver driver, String xpath, String elementName) {
        //only method with a return, thats why it doesnt have void. versus void that doesnt have a return like click and submit method
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
        }
        return result;
    }//end of capture text method

    public static String getTitleMethod(WebDriver driver, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            String actualTitle = driver.getTitle();
            System.out.println("My title is" + " " + actualTitle);

        } catch (Exception e) {
            System.out.println("Unable to get Title" + elementName + e);
        }
        return result;
    }//end of get title method

    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click method

    public static void clickByIndexMethodVisible(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click method

    //create a sendKey method. this will be a void because there is no results
    public static void sendKeysMethod(WebDriver driver, String xpath, String sendKeysValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(sendKeysValue);

        } catch (Exception e) {
            System.out.println("Unable to type in" + elementName + ":" + e);
        }
    }//end of sendKey method

    public static void sendKeysFahadMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
        }// end of try catch
    }//end of send keys method

    public static void scrollIntoElement(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll into" + elementName + ";" + e);
        }

    }//end of scroll into Element method



    public static void selectByVisibleTextMethod(WebDriver driver, String xpath, String selectValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementDropDown = new Select(element);
            elementDropDown.selectByVisibleText(selectValue);
        } catch (Exception e) {
            System.out.println("Unable to select" + elementName + ":" + e);
        }
    }//end of select by visible method

    public static void switchTabsByIndex(WebDriver driver, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Unable to switch tab" + elementName + ":" + e);

        }//end of catch
    }//end of switchTabsByIndex method

    public static void scroll(WebDriver driver, String x, String y) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy("+ x + " , " + y + ")");
        } catch (Exception e) {
            System.out.println("Unable to scroll because" + ";" + e);
        }
    }//end of scroll into Element method

    public static void mouseAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("Unable to move mouse to" + elementName + ";" + e);
        }
    }//end of scroll into Element method
//end of class

    public static void hardAssertMethod(WebDriver driver, String expectedTitle, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, expectedTitle);
        } catch (Exception e) {
            System.out.println("Unable to perform hard assert to" + elementName + ";" + e);


        }
    }
}