package actionItems;

import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import Day14_010224.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ActionItem8 extends TestParent {

    @Test
    public void tc1_verifyHealthfirstTitle() {
        //navigate to google web page
        driver.navigate().to("https://www.healthfirst.org");
        //store the title of healthfirst page
        String actualTitle = driver.getTitle();
        //store the expected title
        String expectedTitle = "NY Health Insurance Information | Healthfirst";
        Assert.assertEquals(actualTitle, expectedTitle);
    }//end of tc 1

    @Test (dependsOnMethods = "tc1_verifyHealthfirstTitle")
    public void tc2_printDifferentTypesOfMTLCPlans() throws InterruptedException {
        driver.navigate().to("https://healthfirst.org/medicare-long-term-care-plans");
        String mltcSummary = Reusable_Methods_Loggers.getTextMethod(driver,"//*[@class='up-hero']",logger,"Summary");
        System.out.println("The summary for Medicare Advantage and MLTC Plan:" + mltcSummary + "\n");

        ArrayList<WebElement> medicareAdvantagePlans = new ArrayList<>(driver.findElements(By.xpath("//*[@class='col-lg-12 col-md-12 mb-1']")));
        System.out.println("There are " + medicareAdvantagePlans.size() + " MTLC Plans");

        //use for loop to print how many medicare advantage plans there are
        for (int i = 0; i < medicareAdvantagePlans.size(); i++) {
            System.out.println(medicareAdvantagePlans.get(i).getText());
        }//end of for loop

    }//end of tc2

    @Test (dependsOnMethods = "tc2_printDifferentTypesOfMTLCPlans")
    public void tc3_signaturePPOCallBack() throws InterruptedException {

        driver.navigate().to("https://healthfirst.org/medicare-long-term-care-plans");
        //click Signature PPO plan
        Reusable_Methods_Loggers.scroll(driver,"0","800",logger);
        Thread.sleep(5000);
        Reusable_Methods_Loggers.scrollIntoElement(driver,"//*[@class='plans-list-item-head-link']",logger,"Signature PPO");
        Reusable_Methods_Loggers.clickByIndexMethod(driver,"//*[@class='plans-list-item-head-link']", 0, logger, "Click Signature PPO");
        String signaturePPOdetails = Reusable_Methods_Loggers.getTextMethod(driver, "//*[@class='plan-header-wrap']", logger, "Signature PPO details");
        System.out.println("The Details for Signature PPO \n" + signaturePPOdetails);
        Reusable_Methods_Loggers.clickMethod(driver, "//*[@class='contact-link']",logger, "Contact Us Link");

    }
//end of tc3

    @Test (dependsOnMethods = "tc3_signaturePPOCallBack")
    public void tc4_requestACallBackForm() throws InterruptedException {
        Reusable_Methods.scrollIntoElement(driver, "//*[@class='form-pop']", "Request A Callback");
        Thread.sleep(3000);
        Reusable_Methods_Loggers.clickMethod(driver, "//*[@class='form-pop']", logger, "Click Request a Callback");
        Reusable_Methods_Loggers.clickMethod(driver, "//*[@class='nice-select custom-select wide']", logger,"Select");
        Reusable_Methods_Loggers.clickMethod(driver, "//*[@class='option selected focus']", logger,"Select option");
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name='contact[first_name]']", "Becky", logger,"Enter First Name");
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name='contact[last_name]']", "Johnson", logger,"Enter Last Name");
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name='contact[phone]']", "6468521234", logger,"Phone Number");
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name='contact[email]']", "Becky123@yahoo.com", logger,"Enter Email");
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name='contact[zip]']", "11225", logger,"Enter Zip Code");

    }// end of tc4

    @Test (dependsOnMethods = "tc4_requestACallBackForm")
        public void tc5_verifyStaySignedInIsChecked() {
        //click on i authorize checkbox
            Reusable_Methods_Loggers.clickMethod(driver, "//*[@id='signature']", logger,"I authorize Healthfirst box");
            //store checked option into a boolean variable
            boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='signature']")).isSelected();
            Reusable_Methods_Loggers.booleanisConditionTrue(isStaySignedInChecked, logger);
            //print out if checkbox is checked
            System.out.println("The checkbox is checked: " + isStaySignedInChecked);
            //assert if its true
            Assert.assertTrue(isStaySignedInChecked);
        }//end of tc 05


}//end of class











