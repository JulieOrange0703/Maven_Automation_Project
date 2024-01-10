package Day4_112023;

public class T2_SplitCommand {
    public static void main(String[] args){
        //declare a string variable with a single message
        String message = "My name is John";

        //declare an array to store the split message
        String[] splitMessage = message.split("");

        //print out only john from the message string
        System.out.println("The name is" + splitMessage[3]);

        //we are adding _ this is where we are splitting it on
        //split based on _
        String message2 = "Automation_01";
        String[] splitMessage2 = message2.split("_");

    }//end of main
}//end of class
