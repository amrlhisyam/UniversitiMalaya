
package VIVA;

import java.util.Scanner;

public class Q4group {
    public static void main(String[] args) {
      Scanner key = new Scanner (System.in) ; 
      int inputNumber ; 
      
        System.out.print("Please input a positive integer: ");
        
        do {
            String input = key.nextLine() ; 
            boolean isValid = true ; 
            if (input.isEmpty()) {
                isValid = false ; 
            }  
            else {
                for (int i = 0 ; i < input.length() ; i++) {
                    char c = input.charAt(i) ; 
                    if (i == 0 && c == '-') {
                    isValid = false ; 
                    break ; 
                    }
                    if(!Character.isDigit(c)) {
                        isValid = false ; 
                        break ; 
                    }
                }
            }
            if (isValid) {
                inputNumber = Integer.parseInt(input) ; 
                break ; 
            }
            else {
                System.out.print("Invalid input. Please re-input a valid +ve integer: ");
            }
        
        
        
        }while (true) ;
        
        System.out.println("You've inputed a valid integer!");
        
        if (inputNumber % 2 == 0 ){
            System.out.println("The integer is even!");
        }
        else{
            System.out.println("The integer is odd");
        }
    }
}
