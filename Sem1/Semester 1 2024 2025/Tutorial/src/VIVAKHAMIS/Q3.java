// still has error
package VIVAKHAMIS;

import java.util.Scanner ; 
public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int number;  
        while (true) {
            System.out.print("Enter a number:");
            number = input.nextInt() ; 
                if (number > 0) {
                break ; 
        }
                else {
                    System.out.println("please enter a positive integer");
                }
        }
        int counter = 0 ;
        int sum = 0 ;
        long product = 1 ;
        for ( int i = 1 ; i <= number ; i++) {
            if ( number % i == 0) {
            counter++ ; 
            sum += i ; 
            product *= i;
            }
        }
        if ( counter == 2) {
            System.out.println("Integer is a prime number");
            System.out.println("The factor of this integer are: \n1 and " + number);
        }
        else {
            System.out.println("Integer is not a prime number, it has " + counter + " factors");
            System.out.println("The factor of this integer are: ");
            for ( int i = 1 ; i <= number ; i++) {
                if(number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
        //printing sum
        System.out.println();
        System.out.println("The sum of factor is: " + sum);
        // printing product
        if ( product < Integer.MAX_VALUE) {
        System.out.println("The product of the factors is " + product);
        }
        else {
            System.out.println("The product of the factor is too large too display");
        }
        // checking if it is a perfect number
        if ( sum == number) {
            System.out.println(number + " is a perfect number");
        }
        else {
            System.out.println(number + " is not a perfect number");
        }
        // printing prime numbers between 2 and variable number
        System.out.print("Prime numbers between 2 and " + number+ ": ");
        for (int i = 1 ; i < number ; i++) {
            counter = 0 ;
            for ( int j = 1; j <= i ; j++) {
                if (i%j == 0) {
                counter++ ; 
                }
            }
            if (counter == 2) {
            System.out.print(i+ " " );
            }
        }
        System.out.println();
    }
}
