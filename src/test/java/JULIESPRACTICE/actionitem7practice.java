package JULIESPRACTICE;

import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import org.testng.annotations.Test;

public class actionitem7practice extends TestParent {
    @Test
    public void tc003_memberOnlinePortal() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org");
        Reusable_Methods.scroll(driver,"0","200");

        Thread.sleep(5000);
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='tool dropdown login']", 0, "Log In Button");
        Reusable_Methods.clickByIndexMethod(driver, "//*[@href='https://members.fideliscare.org/en-us/fidelislogin']", 0, "Member Provider Portal");
        Reusable_Methods.switchTabsByIndex(driver, 1, "Switch to Member Online Portal");

        String helpfulHints = Reusable_Methods.getTextMethod(driver, "//*[@id='dnn_TipsContentPanel']", "Helpful Hints 1");

        System.out.println("Fidelis Help Hints are:\n" + helpfulHints);
        // "\n" allows me to print to a new line
        Thread.sleep(3000);
    }
}//end of testcase3



