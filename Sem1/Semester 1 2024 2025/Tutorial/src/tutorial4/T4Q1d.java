package tutorial4;

import java.util.Scanner;

public class T4Q1d {
    public static void main(String[] args) {
        //d
        Scanner input = new Scanner (System.in) ;
        System.out.print("Enter a number: ");
        int givenNum = input.nextInt();
        int a , sum=0 ;
        for (a = 1 ; a < givenNum ; a++){
            sum += a;
        }
        System.out.println("Sum of numbers from 1 to " + givenNum + " is " + sum);
    }
}


