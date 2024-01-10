package actionItems;

public class ActionItem_02_Assignment2 {
    public static void main(String[] args) {

        // declare grade as int variable and give value. Change variable's value manually to prove if statement
        int grade = 92;

        //if statement grade ranges

        if (grade >= 90 && grade <= 100) {
            System.out.println("Grade is A");
        }//end if statement for variable value range 90 to 100

        else if (grade >= 80 && grade <= 89) {
            System.out.println("Grade is B");
        }//end if statement for variable value range 80 to 89

        else if (grade >= 70 && grade <= 79) {
            System.out.println("Grade is C");
        }//end if statement for variable value range 70 to 79

        else if (grade >= 60 && grade <= 69) {
            System.out.println("Grade is D");
        }//end if statement for variable range 60 to 69

        else {
            System.out.println("Grade is F");
        }//end if else statement


}//end of main


}// end of class
