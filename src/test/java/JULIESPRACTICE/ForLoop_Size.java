package JULIESPRACTICE;

public class ForLoop_Size {
        public static void main(String[] args) {
            // This is a Linear array of strings display using []
            // Declare a string variable products and give it values

            String[] products = {"Perfume", "Lipstick", "Foundation", "Mascara"};

            // Access elements of the array using a loop

            //you use .LENGTH when values are listed from left to right
            //use .SIZE when values are listed up and down

           for (int i = 0; i < products.length; i++) {

               System.out.println("Product available at Sephora: " + products[2]);


            }
        }
    }


