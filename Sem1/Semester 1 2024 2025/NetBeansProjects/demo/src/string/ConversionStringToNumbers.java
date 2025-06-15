/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;

import java.util.Scanner;
public class ConversionStringToNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer");
        String number = input.nextLine();
        // convert number that is received as string into integer for calculation
        int numberint = Integer.parseInt(number);
        System.out.println(numberint);
        System.out.println(numberint + 1); // it become 123 + 1 = 124
        System.out.println(number + 1); // output is 1231 , no addition happen
        
        // convert number that is r eceived as string in double
        String num = input.nextLine();
        double numdouble = Double.parseDouble(num);
        System.out.println(numdouble);
        System.out.println(numdouble+1);
        System.out.println(num+1);
        
        
    }
 
}
