package VIVAKHAMIS;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers [0 to stop]: ");
        
        int score;
        int high = 0 ;
        int second = 0;
        int counter = 0; 
        int counter2 = 0; 
        int sum = 0; 
        int negative = 0; 

        do {
            score = input.nextInt(); 
            
            if (score != 0) { 
                sum += score; 
                
                if (score < 0) {
                    negative++; 
                }
                
                
                if (score > high) {
                    second = high; 
                    counter2 = counter; 
                    high = score; 
                    counter = 1; 
                } else if (score == high) {
                    counter++; 
                } else if (score > second) {
                    second = score; 
                    counter2 = 1; 
                } else if (score == second) {
                    counter2++; 
                }
            }
        } while (score != 0); 

        
        System.out.println("The largest number is " + (high == Integer.MIN_VALUE ? "none" : high));
        System.out.println("The occurrence count of the largest number is " + counter);
        System.out.println("The second-largest number is " + (second == Integer.MIN_VALUE ? "none" : second));
        System.out.println("The occurrence count of the second-largest number is " + counter2);
        System.out.println("The total sum of all numbers is " + sum);
        if (negative > 0) {
            System.out.println("Negative numbers were entered");
        }

        input.close(); // Close the scanner
    }
}