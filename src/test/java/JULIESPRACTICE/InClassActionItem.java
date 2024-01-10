package JULIESPRACTICE;

import Day10_121123.Reusable_Methods;
import Day13_121923.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class InClassActionItem extends TestParent{

    @Test
    public void lifeTime() throws InterruptedException {
        //navigate
        driver.navigate().to("https://www.lifetime.life/");
        Reusable_Methods.getTitleMethod(driver,"Life Time Healthy Way of Life | Join  \n");
        Reusable_Methods.clickMethod(driver,"//*[@class='navbar-toggler ms-n1']","Find a Location Menu");
        ArrayList<WebElement> optionsItems = new ArrayList<>(driver.findElements(By.xpath("//*[@class='nav-link ']")));
        System.out.println("There are " + optionsItems.size() + " options to choose from \n");

        if (optionsItems.size() > 1) {
            Reusable_Methods.clickByIndexMethodVisible(driver,"//*[@class='nav-link ']",0,"Athletic County Club");
        } else {
            System.out.println("My options items list is empty");
        }
        Reusable_Methods.sendKeysMethod(driver,"//*[contains(@data-testid,'find-location')]","11225","Location Text Field");
        Reusable_Methods.clickByIndexMethod(driver,"//*[@class='pac-item']",0,"Location Drop Down Field Google");
        Reusable_Methods.clickMethod(driver,"//*[contains(@class,'outline-dark b')]","Services Filter");

        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-controls='program-filter']",0,"Programs Dropdown");
        Reusable_Methods.clickMethod(driver,"//*[@id='program-pilates']","Pilates");

        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-controls='program-filter']",1,"Services Dropdown");
        Reusable_Methods.clickMethod(driver,"//*[@id='service-massage']","Service Filter Massage");

        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-controls='program-filter']",2,"Features and Amenities Dropdown");
        Reusable_Methods.clickMethod(driver,"//*[@id='feature-lifespa']","LifeSpa");
        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-controls='program-filter']",2,"Features and Amenities Dropdown");
        Reusable_Methods.clickByIndexMethod(driver,"//*[contains(@class,'btn btn-dark')]",0,"First filter searched result");
        Reusable_Methods.scrollIntoElement(driver,"//*[@class='club-details']","Search Result Club Details");

        String resultClubDetails = Reusable_Methods.getTextMethod(driver,"//*[@class='club-details']","Search Result Club Details");
        System.out.print("Club Result Details are\n" + resultClubDetails);

        Reusable_Methods.clickMethod(driver,"//*[@class='btn btn-simple btn-sm']","Explore Membership");
        Reusable_Methods.clickByIndexMethod(driver,"//*[@class='btn btn-dark']",0,"Join Today Button");
        Reusable_Methods.scrollIntoElement(driver,"//*[@id='move-forward-btn']","Move Forward Button");
        Reusable_Methods.clickMethod(driver,"//*[@id='card-select-membership-0']","Select Membership");

        String summaryDetails = Reusable_Methods.getTextMethod(driver,"class='col-xs-12 col-md-6 col-lg-5 col-xl-4']","Summary Details");
        System.out.println("Here are my Membership Details \n" + summaryDetails);



    }//end of testcase



}//end of class
