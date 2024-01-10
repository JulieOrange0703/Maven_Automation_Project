package actionItems;

import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import org.testng.annotations.Test;

public class ActionItem_07 extends TestParent {

    @Test
    public void tc001_dentalCoverage() throws InterruptedException{
        //navigate to fidelis.org
        driver.navigate().to("https://www.fideliscare.org");
        //click on search element on top right
        Reusable_Methods.clickByIndexMethod(driver,"//*[@class='dropdown-toggle']",1,"Search");
        Reusable_Methods.sendKeysMethod(driver,"//*[@class='form-control search-input']","get dental coverage","Search Field");
        Reusable_Methods.clickByIndexMethod(driver,"//*[@class='btn btn-primary btn-search']",0,"Text Box Search");
        //store the search result
        String searchResults = Reusable_Methods.getTextMethod(driver,"//*[@class='gsc-result-info']","Search Results");
        //declare an array[] to split the string, split the result
        String[] searchResultArray = searchResults.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
        Reusable_Methods.clickByIndexMethod(driver,"//*[@href='https://www.fideliscare.org/Blog/Get-Dental-Coverage']",0,"Get Dental Coverage Link");

    }//end of testcase1

    @Test(dependsOnMethods = "tc001_dentalCoverage")
    public void tc002_switchTabs() throws InterruptedException {

        Reusable_Methods.switchTabsByIndex(driver,1,"Dental Coverage Tab");
Reusable_Methods.sendKeysMethod(driver,"//*[@id='firstName']","Penelope","First Name Field");
Reusable_Methods.sendKeysMethod(driver,"//*[@id='lastName']","Cruz","Last Name Field");
Reusable_Methods.sendKeysMethod(driver,"//*[@id='zipCode']","11225","Zip Code Field");
Reusable_Methods.selectByVisibleTextMethod(driver,"//*[@id='county']","New York","Select County");
Reusable_Methods.sendKeysMethod(driver,"//*[@id='phoneNumber']","7187351668","Enter Phone Number Field");
Reusable_Methods.sendKeysMethod(driver,"//*[@id='email']","P.cruz@yahoo.com","Enter Email Field");
Reusable_Methods.clickMethod(driver,"//*[text()='By checking this box you are agreeing to have a Fidelis Care representative contact you about health insurance.']","Contact me check box");
Reusable_Methods.clickMethod(driver,"//*[@type='submit']","Contact Me Button");
String thankYouMessage = Reusable_Methods.getTextMethod(driver,"//*[@class='alert alert-success']","Thank You for Submission");
System.out.println("My final result for submission is: \n" + thankYouMessage + "\n");

driver.close();

    }//end of testcase2

   @Test(dependsOnMethods = "tc002_switchTabs")
    public void tc003_memberOnlinePortal() {
       Reusable_Methods.switchTabsByIndex(driver, 0, "Switch back to Default tab");
       Reusable_Methods.clickByIndexMethod(driver, "//*[@class='tool dropdown login']", 0, "Log In Button");
       Reusable_Methods.clickByIndexMethod(driver, "//*[@href='https://members.fideliscare.org/en-us/fidelislogin']", 0, "Member Provider Portal");
       Reusable_Methods.switchTabsByIndex(driver, 1, "Switch to Member Online Portal");

       String helpfulHints = Reusable_Methods.getTextMethod(driver, "//*[@id='dnn_TipsContentPanel']", "Helpful Hints 1");

       System.out.println("Fidelis Help Hints are:\n" + helpfulHints);
       // "\n" allows me to print to a new line

       driver.close();
   }//end of testcase 3
    }//end of class
