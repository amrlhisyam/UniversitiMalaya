package PastQuestion;
/*Each staff will be given a random ID (integer) which is a five digit number starting 
from 10000 to 99999 every week. The staff will be selected randomly for weekend 
duty based on the ID. Starting from the left, if the second digit is an odd number and 
the fourth digit is an even number, the staff will be selected. Write a Java program to 
simulate the situations for N staff.*/

// random number --> 5 digit --> 
// final min = 10000 max = 99999
// selected randomly for weekend duty --> based on id
// if second digit = odd && 4th digit = even --> selected

import java.util.Random;
import java.util.Scanner; 

public class Session1819Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in) ;
        System.out.print("Enter the number of staff [N]: ");
        int numStaff = input.nextInt(); 
        
        Random s = new Random();
        int min = 10000; 
        int max = 99999;
        
        int second , forth ; 
        int i=0;
        
        int n ; 
        for( n = 0 ; n < numStaff ; n ++){
            int id = s.nextInt(min,max);
            System.out.println(id);
            second = (id % 10000) / 1000 ; 
            forth = (id % 100) / 10 ;
            
            if ( second % 2 != 0 && forth % 2 == 0){
                System.out.println("Weekend Duty");
                i++;
            }
            else {
                System.out.println("Weekend Off");
            }
            
        }
        
        System.out.println("The number of staffs work during weekend is " + i );
    }
    
}
