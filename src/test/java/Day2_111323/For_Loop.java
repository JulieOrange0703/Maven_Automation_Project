package Day2_111323;

import java.util.ArrayList;

public class For_Loop {

    public static void main(String[] args) {
        //declare an arraylist variable

        ArrayList<String> countries = new ArrayList<>();
        //add some values to the countries array list
        countries.add("USA"); //index 0
        countries.add("INDIA"); //index 1
        countries.add("PAKISTAN"); //index 2
        countries.add("BANGLADESH"); // index 3
        countries.add("MEXICO"); // index 4

        //print out all the countries from the arraylist
        for (int i = 0; i < countries.size(); i++) {


            //print out the value of i to see which iteration we are on
            System.out.println("Index number or iteration number is " + i);
            //print out all the countries
            System.out.print("My country is " + countries.get(i));
        }
    }//end of loop

}//end of class
