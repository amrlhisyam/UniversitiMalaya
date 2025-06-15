package VIVA ; 
import java.util.Scanner;

public class Q5Draft {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in) ; 
        String number ;
        System.out.print("Enter: ");
        number = input.nextLine() ; 
        
        
        
        
        int counter = 1 ; 
        int group = 1 ;
        int maxRepeat = 0 ;
        char longestChar = number.charAt(0) ;
        int sumLengths = 1 ;
        
        String number01 = number.trim() ;
        System.out.println(number01);
        
        for ( int k = 0 ; k < number01.length() ; k++) {
            if ( number01.charAt(k) == '-' ) {
                System.out.println("Negative Number!!") ;
                System.out.println("Enter a Positive integer.") ;
                return ; 
            }
            
            else if ( number01.charAt(k) >= 'A' && number01.charAt(k) <= 'z' ) {
                System.out.println("Invalid integer!!");
                System.out.println("Enter a Valid Integer.");
                return ; 
            }
        }
        /*
        String Length: The length() method of a string returns the number of characters in that string. 
        If number has a length of n, valid indices for characters in the string are from 0 to n - 1.
        
        for ( int i = 0 ; i < number.length()  ; i ++) {
            if ( number.charAt(i) == number.charAt( i + 1))
        
        Loop Condition: In your loop, i starts at 0 and increments until it is less than number.length().
        When i reaches n - 1 (the last valid index), i + 1 will equal n, which is out of bounds for the string.
        */
        
        
        
        
        for ( int i = 0 ; i < number01.length() - 1 ; i ++) {
            if ( number01.charAt(i) == number01.charAt( i + 1)) {
                counter++ ; 
                
            }
            else {
                if (counter > maxRepeat) { // this ensure that when two digits of same lengths encounter , the first one to appear will be displayed
                maxRepeat = counter ;
                longestChar = number01.charAt(i) ;
                }
                group++ ; 
                counter = 1 ;
            }
        
           sumLengths++ ;     
        
        }
        
        // example input = 111234444 
        // after 3 , the group increment by 1 more
        // 4 will have counter increment but no way to check wether it is the longest or not
        // --> due to no new group present
        // this will check if it is the new maxRepeat holder
        if (counter > maxRepeat) {
            maxRepeat = counter ; 
            longestChar = number.charAt(number01.length() - 1) ; // just take whatever the last digit is // need to minus 1 because charAt() start at 0 
            // otherwise it will be out of bound
            
        }
        
        
       
        
        /* Uninitialized Variable: longestchar is declared but not assigned a value before it is used in the print statement.
           If the loop never finds any repeating characters, longestchar will remain uninitialized.
        
            char longestchar ; 
            System.out.println(longestchar) ;
            
        Possible Scenarios: If number has no repeating characters, 
        the if block that assigns a value to longestchar will never be executed, leaving longestchar uninitialized.
        */
        
        System.out.println("Total number of digits group: " + group);
        System.out.println("The digit forming the longest is " + longestChar + " with lengths of " + maxRepeat);
        System.out.println("The sum of lengths of all digits group is " + sumLengths );
        
        System.out.println(group);
        System.out.println(longestChar + "  " + maxRepeat);
        System.out.println(sumLengths);
        
    }
}