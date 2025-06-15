
package VIVAKHAMIS;

import java.util.Scanner ; 
public class Q1 {
    public static void main(String[] args) {
        //prompt input number from user
        Scanner input = new Scanner(System.in) ;
        System.out.print("Enter a number: ");
        int number = input.nextInt() ; 
        //
        int temp,digit, counter = 0,sum = 0 ;
        temp = number ; 
        while(number>0){
            number = number/10;
            counter++;
        }
        while (temp > 0) {
            digit = temp%10 ;
            System.out.println(digit);
            temp = temp/10 ;
            counter-- ;
            sum += digit ;
        }
        System.out.println(sum);
        
        }
    }

