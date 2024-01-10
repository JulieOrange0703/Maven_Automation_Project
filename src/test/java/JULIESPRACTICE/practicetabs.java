package JULIESPRACTICE;

import Day10_121123.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;

public class practicetabs {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = Reusable_Methods.setUpDriver();

            //navigate to fidelis care site
            driver.navigate().to("https://www.fideliscare.org");

            //click on shop for a plan

            Reusable_Methods.clickMethod(driver,"//*[@class='btn btn-block btn-lg root btn-primary']","Shop for a Plan");

            Thread.sleep(2000);

            Reusable_Methods.clickByIndexMethod(driver,"//*[text()='Shop for a Plan']",0,"Shop for a Plan");

            //Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class,'_yb_q22uj')]", 2, "yahoo headers");

            Thread.sleep(3000);

            //click on find a doctor button
            Reusable_Methods.clickByIndexMethod(driver,"//*[@href='/Find-A-Doctor']",0,"Find A Doctor");

            Thread.sleep(1000);

            Reusable_Methods.switchTabsByIndex(driver,1, "Tab2");

            Thread.sleep(3000);
            //enter a zipcode on search location field
           Reusable_Methods.sendKeysMethod(driver,"//*[@id='searchLocation']","11218","Zip Code Field");

           Thread.sleep(2000);
           //close this new tab
            driver.close();

            Thread.sleep(3000);

            //switch back to default tab
            Reusable_Methods.switchTabsByIndex(driver,0,"Tab1");

            Thread.sleep(3000);
            //click on find a doctor link from the bottom
            Reusable_Methods.clickByIndexMethod(driver,"//*[@href='/Find-A-Doctor']",1,"Find A Doctor");

            driver.quit();

        }//end of main
    }//end of class

