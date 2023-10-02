package org.example;

import java.util.Scanner;  // Import the Scanner class
public class inputs {
        public static float askForInput() {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter number");

            String a = myObj.nextLine();  // Read user input
            return Float.parseFloat(a);  // Output user input
        }
}
