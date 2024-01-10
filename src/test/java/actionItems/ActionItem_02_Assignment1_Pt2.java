package actionItems;

import java.util.ArrayList;

public class ActionItem_02_Assignment1_Pt2 {
    public static void main (String[] args) {


        //declare an arraylist as String data type with the variable "region" as a new array list
        ArrayList<String> region = new ArrayList<>();
        region.add("Alaska");
        region.add("Wyoming");
        region.add("Vermont");
        region.add("Rhode Island");

        //declare an arraylist as Integer data type with the variable "areaCode" as a new array list
        ArrayList<Integer> areaCode = new ArrayList<>();

        //add Integer values to variable "areaCode" in the array list
        areaCode.add(201);
        areaCode.add(307);
        areaCode.add(802);
        areaCode.add(401);

        //set the initial start point for iteration which is 0, 0 is the index value for Alaska which is listed first
        int i = 0;
        while (i < region.size()) {

            //print out the value region and areaCode
            System.out.println("My region is " + region.get(i) + " " + "and my area code is" + " " + areaCode.get(i));

            //increment operator
            //i++; is the same as i = i + 1;
            i = i + 1;

        } //end of while loop

    }//end of main

}//end of class
