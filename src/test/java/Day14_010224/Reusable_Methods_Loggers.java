package Day14_010224;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

import static Day13_121923.TestParent.logger;

public class Reusable_Methods_Loggers {

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

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS,"Successfully able to submit" + elementName );
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
            logger.log(LogStatus.FAIL,"unable to submit" + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of submit method

    public static String getTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //only method with a return, that's why it doesn't have void. versus void that doesnt have a return like click and submit method
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS,"Successfully able to get text" + elementName );
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL,"unable to get text" + elementName);
        }
        return result;
    }//end of capture text method

    public static String getTitleMethod(WebDriver driver, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            String actualTitle = driver.getTitle();
            System.out.println("My title is" + " " + actualTitle);
            logger.log(LogStatus.PASS,"Successfully able to get title" + elementName );

        }catch (Exception e) {
            System.out.println("Unable to get Title" + elementName + e);
            logger.log(LogStatus.FAIL,"unable to get title" + elementName);
        }
        return result;
    }//end of get title method

    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
           WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
           element.click();
            logger.log(LogStatus.PASS,"Successfully able to click by index" + elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to click by index" + elementName);
        }
    }//end of click method

    public static void clickByIndexMethodVisible(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
           WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
           element.click();
            logger.log(LogStatus.PASS,"Successfully able to click by index" + elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to click by index" + elementName);
        }
    }//end of click method

    //create a sendKey method. this will be a void because there is no results
    public static void sendKeysMethod(WebDriver driver, String xpath, String sendKeysValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(sendKeysValue);
            logger.log(LogStatus.PASS,"Successfully able to send keys" + elementName );

        } catch (Exception e) {
            System.out.println("Unable to type in" + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to send keys" + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of sendKey method

    public static void sendKeys2Method(WebDriver driver, String xpath, String userValue ,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully able to send keys" + elementName );
        }catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to send keys" + elementName);
        }// end of try catch
    }//end of send keys method
    public static void scrollIntoElement(WebDriver driver,String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS,"Successfully able to scroll into" + elementName );
        } catch (Exception e){
            System.out.println("Unable to scroll into" + elementName + ";" + e);
            logger.log(LogStatus.FAIL,"unable to scroll into" + elementName);
        }
    }//end of scroll into Element method

    public static void scroll(WebDriver driver, String x, String y, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy("+ x + " , " + y + ")");
            logger.log(LogStatus.PASS,"successfully able to scroll" );
        } catch (Exception e) {
            System.out.println("Unable to scroll because" + ";" + e);
            logger.log(LogStatus.FAIL,"unable to scroll");
        }
    }//end of scroll into Element method

    //create a scroll method
    public static void scrollAction(WebDriver driver,String xpath,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(xpath);
            logger.log(LogStatus.PASS,"Successfully able to scroll ");

        } catch (Exception e) {
            System.out.println("Unable to scroll " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll " + e);
           // getScreenShot(driver,xpath,logger);
        }//end of try and catch

    }//end of scrollAction

    public static void selectByVisibleTextMethod(WebDriver driver, String xpath, String selectValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementDropDown = new Select(element);
            elementDropDown.selectByVisibleText(selectValue);
            logger.log(LogStatus.PASS,"successfully able to Select " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select" + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to select" + elementName);
        }
    }//end of select by visible method

    public static void switchTabsByIndex(WebDriver driver, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS,"Successfully switched tabs " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch tab" + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to switch" + elementName);

        }//end of catch
    }//end of switchTabsByIndex method

    public static void mouseAction(WebDriver driver,String xpath,ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e){
            System.out.println("Unable to move mouse to" + elementName + ";" + e);
            logger.log(LogStatus.FAIL,"unable to click on " + elementName);
        }
    }//end of scroll into Element method

    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click method

    //create a boolean method
    public static void booleanisConditionTrue(boolean bool, ExtentTest logger){
        if(bool == true) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        }else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method

    //this will pass if the checkbox is checked

    public static void booleanisConditionFalse(boolean bool, ExtentTest logger) {
        if (bool == false) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

}//end of class
//this will pass if the check is not checked because it makes the condition false