package JULIESPRACTICE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class practice123 {
    public static void main (String [] args) {


        ArrayList <String> fruitBaskets = new ArrayList<>();
        fruitBaskets.add("Orange");
        fruitBaskets.add("Apple");
        fruitBaskets.add("Mango");

        //pick out only apple from the basket / array
        //start the for loop because we need to check everything in the basket / array

        for (int i = 0; i < fruitBaskets.size(); i++) {
            // == (double equal sign) means its a comparison operator
            //= (single equal sign) assigns a value to a variable

            if (fruitBaskets.get(i).equals("Apple")) {
                System.out.println("An apple a day keeps the defects away");
            }//end of it clause

            else if (fruitBaskets.get(i).equals("Grape")) {
                System.out.println("My fruit is " + fruitBaskets.get(i));
            }//end of else if

            //JULIES COMMENT THE ORDER OF THE FRUITS IN THE BASKET, LINE PRINT WILL PRINT WHICH FRUIT COMES FIRST
        }//end for loop


    }// end of main


} //end of class