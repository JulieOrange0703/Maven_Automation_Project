package Day14_010224;

import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_YahooBooLean extends TestParent {
    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Methods.clickMethod(driver, "//*[text() = 'Sign in']", "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertTrue(isStaySignedInChecked);
    }//end of tc 01

    @Test
    public void tc002_verifySignInOptionIsUnchecked(){
        //click on the checkbox to uncheck it
        Reusable_Methods.clickMethod(driver, "//*[@class= 'stay-signed-in checkbox-container']", "checkbox");
        //should store false value since checkbox is not checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertFalse(isStaySignedInChecked);
    }//end of tc002

}//end of class
