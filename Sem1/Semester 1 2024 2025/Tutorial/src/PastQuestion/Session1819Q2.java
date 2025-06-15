package PastQuestion;


import java.util.*;

public class Session1819Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int number ; 
        int factorNum ; 
        int i = 0;
        int k = 0;
       

        
        while (true) {
            System.out.print("Enter a number (-1 to quit) : ");
            number = input.nextInt() ;
            
            if (number == -1) {
                break ;
            }
            k++ ;
            
            System.out.print("Enter a factor: ");
            factorNum = input.nextInt() ;
            boolean answer = (number % factorNum == 0); 
            
            if(answer == true) {
                System.out.println(factorNum + " is a factor of " + number + "? (true/false): " + answer);
                System.out.println("Your answer is correct");
                i++;
            }
            else {
                System.out.println(factorNum + " is a factor of " + number + "? (true/false): " + answer);
                System.out.println("Your answer is incorrect");
                
            }
            
            input.nextLine();
        
        }
            System.out.print("The final score is " + i + "/" + k + "\n");
        
        
        
    }
 
}
