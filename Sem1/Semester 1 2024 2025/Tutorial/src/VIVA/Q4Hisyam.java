package VIVA ; 

import java.util.Scanner ; 

public class Q4Hisyam {
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in) ;
        String integer ;
        
        boolean isValid  ; 
        int number ; 
        
        System.out.print("Enter a positive integer: ");
        integer = input.nextLine() ;    
        
        do {
            isValid = Valid(integer) ;

            if (!isValid) {
                System.out.print("Invalid input. Please re-input a valid +ve integer:  ");
                integer = input.nextLine() ;
            }

            else {
                System.out.println("You've inputed a valid integer!");
            }
        }
        while(!isValid) ;
        
        number = Integer.parseInt(integer);
        
        if (number%2 == 0 ) {
            System.out.println("The integer is even");
        }
        
        else {
            System.out.println("The integer is odd");
        }
        
        
    }
    
    public static boolean Valid (String integerString) {
        if ( integerString.isEmpty()) {
                return false ;
            }
        for ( int i = 0 ; i < integerString.length() ; i++) {
            if (integerString.charAt(i) < '0' || integerString.charAt(i)> '9') {
                return false ; 
            }
        } 
        
        return true ; 
    }
}