package Day3_111423;

import java.util.ArrayList;

public class T1_Whileloop {
    public static void main (String[] args){

        //declare an array list of boroughs
        ArrayList<String> boroughs = new ArrayList<>();
        boroughs.add("Brooklyn");
        boroughs.add("Manhattan");
        boroughs.add("Queens");
        boroughs.add("Bronx");
        boroughs.add("Staten Island");

        //set the initial counter for the while loop
        int i = 0;
        while (i < boroughs.size()) {
            //iteration
            //first 0 < 5
            //second 1 < 5
            //sixth it becomes false because 5 < 5 is not correct

            //print out the value of i to see which iteration we are on
            System.out.println("Index number or iteration number is " + i );

            //print out all the boroughs
            System.out.println("My borough is " + boroughs.get(i));

            //increment operator
            //counter
            //i++; is the same as i = i + 1;
            i = i + 1;

        } //end of while loop
    } //end of main



} // end of class
