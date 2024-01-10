package Day14_010224;

import Day13_121923.TestParent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Day13_121923.TestParent.driver;
import static Day13_121923.TestParent.logger;

public class T3_YahooExtent_Enhanced extends TestParent {

    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Methods_Loggers.clickMethod(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if condition is true
        Reusable_Methods_Loggers.booleanisConditionTrue(isStaySignedInChecked, logger);
    }//end of tc 01
}
