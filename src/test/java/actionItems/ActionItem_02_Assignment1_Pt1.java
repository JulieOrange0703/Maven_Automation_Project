package actionItems;

import java.util.ArrayList;

public class ActionItem_02_Assignment1_Pt1 {
    public static void main(String[] args) {


        //declare an arraylist variable as a new array list
        //THIS IS STRING DATATYPE
            ArrayList<String> region = new ArrayList<>();

            //add (String) values to each variable "region" in the array list
            region.add("Alaska"); //index 0
            region.add("Wyoming"); //index 1
            region.add("Vermont"); //index 2
            region.add("Rhode Island"); // index 3

        // declare an integer arraylist as a new array list
        //THIS IS INTEGER DATATYPE
        ArrayList<Integer> areaCode = new ArrayList<>();

        //add (Integer) values to each variable "area code" in the array list
        areaCode.add(201); // Add Alaska area code "201" to area code array list
        areaCode.add(307); // Add Wyoming area code "307" to area code array list
        areaCode.add(802); // Add Vermont area code "802" to area code array list
        areaCode.add(401); // Add Rhode Island area code "401" to area code array list

        //add for loop for iteration (since both index values are the same, I can use either area code or region to define iteration count)
        for (int i = 0; i < region.size(); i++) {

            //print out all the regions from the arraylist
                System.out.println("My region is " + region.get(i) + " " + "and my area code is" + " " + areaCode.get(i));
            }//end of loop
        }//end of main

} //end of class


