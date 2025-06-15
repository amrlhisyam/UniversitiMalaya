/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

// leap year is evenly divisible by 4 
// leap year is not evenly divisible by 100 eg: 1900 but evenly divisible by 400

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        boolean isLeapYear = 
                ((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0));
        System.out.println(year + " is a leap year is " + isLeapYear);
    }
    
}
