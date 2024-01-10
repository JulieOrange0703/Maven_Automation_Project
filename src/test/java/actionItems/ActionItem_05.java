package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ActionItem_05 {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //run in headless mode (runs in the background)
        //options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> firstName = new ArrayList<>();

        //add some values to the first name
        firstName.add("Jane");
        firstName.add("Tisharie");

        ArrayList<String> lastName = new ArrayList<>();
        //add some values to the last name
        lastName.add("Anderson");
        lastName.add("John");

        ArrayList<String> zipCode = new ArrayList<>();
        //add some values to the zipCode
        zipCode.add("11213");
        zipCode.add("10016");

        ArrayList<String> dob = new ArrayList<>();
        //add some values to the dob
        dob.add("12151987");
        dob.add("01201991");

        ArrayList<String> vehicleYear= new ArrayList<>();
        vehicleYear.add("2022");
        vehicleYear.add("2023");

        ArrayList<String> vehicleMake= new ArrayList<>();
        vehicleMake.add("Toyota");
        vehicleMake.add("BMW");

        ArrayList<String> vehicleModel= new ArrayList<>();
        vehicleModel.add("Prius");
        vehicleModel.add("M5");

        ArrayList<String> daysPerWeek= new ArrayList<>();
        daysPerWeek.add("5");
        daysPerWeek.add("2");

        ArrayList<String> miles= new ArrayList<>();
        miles.add("15");
        miles.add("5");

        for (int i = 0; i < firstName.size(); i++) {

            //navigate to Geico
            driver.navigate().to("https://www.geico.com");
            Thread.sleep(2000);

            //Create WebElement ArrayList because there are multiple checkboxes with the same x path
            ArrayList<WebElement> insTypeCheckbox = new ArrayList<>(driver.findElements(By.xpath("//*[@class='product-checkbox']")));
            Thread.sleep(1000);

            //click on autocheckbox
            try{
            insTypeCheckbox.get(0).click();
        } catch(Exception e){
            System.out.println("Unable to check Insurance Type Checkbox because " + e);
        }

            //click on "Start my quote"
             try{
            driver.findElement(By.xpath("//*[contains(@data-link-name,'Start My Quote')]")).click();
        }catch(Exception e) {
            System.out.println("Unable to click Start My Quote because " + e);
        }
        Thread.sleep(2000);

        //enter real zip code
            try{
            driver.findElement(By.xpath("//*[@id= 'bundle-modal-zip']")).sendKeys(zipCode.get(i));
        }catch(Exception e) {
            System.out.println("Unable to type Zip Code because " + e);
        }
        Thread.sleep(2000);

        //check homeowners checkbox
            try {
                insTypeCheckbox.get(6).click();
            } catch (Exception e){
                System.out.println("Unable to check Homeowners Checkbox because " + e);
            }
            Thread.sleep(5000);

            //click continue
           ArrayList<WebElement> continueButton = new ArrayList<>(driver.findElements(By.xpath("//*[@value='Continue']")));
            try {
                continueButton.get(0).click();

            }catch(Exception e){
            System.out.println("Unable to click continue because " + e); }
            Thread.sleep(5000);

//Enter your date of birth

            try {
                driver.findElement(By.xpath("//*[@aria-label='Date of Birth']")).sendKeys(dob.get(i));
            }catch(Exception e){
                    System.out.println("Unable to enter Date of Birth because " + e); }
            Thread.sleep(2000);


            //Click Next
            try {
               WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
               nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //Enter First Name
            try {
                WebElement firstNameField = driver.findElement(By.xpath("//*[@aria-label='First Name']"));
                firstNameField.clear();
                firstNameField.sendKeys(firstName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter first name because " + e);
            }
            Thread.sleep(5000);

            //Enter last Name
            try {
                WebElement lastNameField = driver.findElement(By.xpath("//*[@aria-label='Last Name']"));
                lastNameField.clear();
                lastNameField.sendKeys(lastName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter last name because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
               WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
               nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(8000);

            //Enter valid address
            try {
                WebElement currentAddress = driver.findElement(By.xpath("//*[@placeholder='Enter a location']"));
                currentAddress.sendKeys("1640 Carroll Street");
            }catch(Exception e){
                System.out.println("Unable to enter address because " + e);
            }
            Thread.sleep(8000);

            //enter apt number
            try {
                WebElement aptNumber = driver.findElement(By.xpath("//*[@aria-label='Apt #']"));
                aptNumber.sendKeys("1D");
            }catch(Exception e){
                System.out.println("Unable to enter apt number because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(15000);

            //Click on yes radio button
            try {
                WebElement yesRadioButton = driver.findElement(By.xpath("//*[@id='labelForYes']"));
                yesRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click yes radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //click on No
            try {
                WebElement noRadioButton = driver.findElement(By.xpath("//*[@id='labelForNo']"));
                noRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click no radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //click yes
            try {
                WebElement yesRadioButton = driver.findElement(By.xpath("//*[@id='labelForYes']"));
                yesRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click yes radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //Enter prior address
            try {
                WebElement priorAddress = driver.findElement(By.xpath("//*[contains(@class,'address-search-field')]"));
                priorAddress.sendKeys("323 Midwood Street");
            }catch(Exception e){
                System.out.println("Unable to enter prior address because " + e);
            }
            Thread.sleep(5000);

            //Enter prior apt#
            try {
                WebElement priorAptNumber = driver.findElement(By.xpath("//*[contains(@aria-label,'Apt #')]"));
                priorAptNumber.sendKeys("1F");
            }catch(Exception e){
                System.out.println("Unable to enter prior apt number because " + e);
            }
            Thread.sleep(5000);

            //enter prior zip code
            try {
                WebElement priorAptNumber = driver.findElement(By.xpath("//*[contains(@aria-label,'5-Digit')]"));
                priorAptNumber.sendKeys("11225");
            }catch(Exception e){
                System.out.println("Unable to enter prior zipcode because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(8000);

            //click on No
            try {
                WebElement noRadioButton = driver.findElement(By.xpath("//*[@id='labelForNo']"));
                noRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click no radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //select year
            try {
                //Create WebElement variable for select year drop down
                WebElement selectYear = driver.findElement(By.xpath("//*[@aria-label='Year']"));

                //create a Select variable
                Select selectYearDropdown = new Select(selectYear);
                //tell selectVariable "selectYearDropdown" how to select value and iterate by calling data from my array list "vehicleYear" I created above
                selectYearDropdown.selectByValue(vehicleYear.get(i));
            }catch(Exception e){
                System.out.println("Unable to select vehicle year from drop down because " + e);
            }
            Thread.sleep(5000);

            //Select Make
            try {
                //Create WebElement variable for select make drop down
                WebElement selectMake = driver.findElement(By.xpath("//*[@aria-label='Make']"));

                //create a Select variable
                Select selectMakeDropDown = new Select(selectMake);
                selectMakeDropDown.selectByValue(vehicleMake.get(i));
            }catch(Exception e){
                System.out.println("Unable to select vehicle make from drop down because " + e);
            }
            Thread.sleep(5000);

            //Select Model
            try {
                //Create WebElement variable for select model drop down
                WebElement selectModel = driver.findElement(By.xpath("//*[@aria-label='Model']"));

                //create a Select variable
                Select selectModelDropDown = new Select(selectModel);
                selectModelDropDown.selectByValue(vehicleModel.get(i));
            }catch(Exception e){
                System.out.println("Unable to select vehicle model from drop down because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //click on Leased
            try {
                WebElement leasedRadioButton = driver.findElement(By.xpath("//*[@id='labelForL']"));
                leasedRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click leased radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //choose Commute
            try {
                WebElement commuteRadioButton = driver.findElement(By.xpath("//*[@id='labelForC']"));
                commuteRadioButton.click();
            }catch(Exception e){
                System.out.println("Unable to click commute radio button because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //Choose days per week
            try {
                WebElement selectDaysPerWeek = driver.findElement(By.xpath("//*[@aria-label='Days per Week']"));
                //create a Select variable
                Select selectDaysPerWeekDropDown = new Select(selectDaysPerWeek);
                selectDaysPerWeekDropDown.selectByValue(daysPerWeek.get(i));
            }catch(Exception e){
                System.out.println("Unable to select Days Per Week from drop down because " + e);
            }
            Thread.sleep(3000);

            //Enter how many miles
            try {
                WebElement commuterMilesOneWayField = driver.findElement(By.xpath("//*[@data-formotivid='GiveMilesOneWay']"));
                commuterMilesOneWayField.sendKeys(miles.get(i));
            }catch(Exception e){
                System.out.println("Unable to enter one way commuter miles because " + e);
            }
            Thread.sleep(5000);

            //Click on Next
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);

            //Click on Next again
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(5000);


            //Click on Next again
            try {
                WebElement nextButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                nextButton.click();
            }catch(Exception e){
                System.out.println("Unable to click next because " + e);
            }
            Thread.sleep(7000);

            //Select Gender
            try {
                //Create WebElement variable for select model drop down
                WebElement selectGender = driver.findElement(By.xpath("//*[@aria-label='Gender']"));

                //create a Select variable
                Select selectGenderDropDown = new Select(selectGender);
                selectGenderDropDown.selectByVisibleText("Female");

            }catch(Exception e){
                System.out.println("Unable to select gender from drop down because " + e);
            }
            Thread.sleep(5000);

            //Click on agree and continue button
            try {
                WebElement agreeAndContinueButton = driver.findElement(By.xpath("//*[contains(@class,'btn btn')]"));
                agreeAndContinueButton.click();
            }catch(Exception e){
                System.out.println("Unable to click agree and continue button because " + e);
            }
            Thread.sleep(5000);

            driver.quit();

        }//end of for loop
    }//end of main
}//end of class
