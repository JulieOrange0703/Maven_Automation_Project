package Day3_111423;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class T4_ConditionWithLoop {
    public static void main (String [] args) {

        String[] fruitBasket = new String[] {"Orange", "Apple", "Mango", "Grape"};

    //pick out only apple from the basket / array
        //start the for loop because we need to check everything in the basket / array

        for (int i = 0; i < fruitBasket.length; i++) {
            // == (double equal sign) means its a comparison operator
            //= (single equal sign) assigns a value to a variable

            if (fruitBasket[i] == "Apple") {
                System.out.println("An apple a day keeps the defects away");
            }//end of it clause

            else if (fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            }//end of else if

            //JULIES COMMENT THE ORDER OF THE FRUITS IN THE BASKET, LINE PRINT WILL PRINT WHICH FRUIT COMES FIRST
        }//end for loop


    }// end of main


} //end of class