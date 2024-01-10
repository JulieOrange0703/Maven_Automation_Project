package Day2_111323;

public class T1_LinearArray {
    public static void main(String[] args) {

        //declare a string array variable
        //An array is a collection of multiple values of the same type(String or Integer) in a single variable name

        String[] zipCode;
        zipCode = new String[]{"11210", "11120", "11230", "11217"};



        //print out the first zip code
        System.out.println("the first zipcode is " + zipCode[0]);

        //print out the third zip code
        System.out.println("the third zipcode is " + zipCode[2]);

        //declare an int array
        int[] studentGrades = new int[]{90, 94, 50, 65};

        //print out the second students grade
        System.out.println("the second student grade is " + studentGrades[1]);
    } //end of main method
} // end of class
