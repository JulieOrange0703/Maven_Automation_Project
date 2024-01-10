package Day3_111423;

import java.util.ArrayList;

public class voting {
    public static void main(String[] args){

        ArrayList<Integer> votingAge = new ArrayList<>();
        votingAge.add(21);
        votingAge.add(15);
        votingAge.add(25);
        votingAge.add(45);

        for (int i = 0; i < votingAge.size() ; i++){

            Integer votingAgeResults = votingAge.get(i);

            if (votingAgeResults >= 18) {
                System.out.println("Congratulations, you can vote at your age of " + votingAge.get(i));
            }
                else{
                    System.out.println("Sorry, youre are too young at the age of " + votingAge.get(i));
            }

        }//end of for loop

    }//end of main


}//end of class
