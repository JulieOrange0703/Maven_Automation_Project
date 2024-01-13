package actionItems;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Day14_010224.Reusable_Methods_Loggers.getScreenShot;

public class ActionItem9 {

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
}//end of class
