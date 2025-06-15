/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial3;

import java.util.Scanner;

public class T3Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //a.
        if(3 * 8 == 27);
        System.out.println("True");
        //else 
        System.out.println("False");
        
        // b.
        System.out.print("Enter an integer: ");
        int integer = input.nextInt();
        if (integer % 2 == 0)
            System.out.println("Even");
        else if (integer % 2 != 0)
            System.out.println("Odd");
        else 
            System.out.println("Input error");
        
        //c.
        System.out.print("Enter a character: ");
        char letter = input.next().charAt(0);
            if(letter >= 'A' && letter <= 'Z')
                System.out.println("CAPITAL LETTER");
            else if(letter >= 'a' && letter <= 'z')
                System.out.println("small letter");
            else 
            System.out.println("Not alphabetical character");
        
        //d. https://www.geeksforgeeks.org/sort-string-characters/?ref=header_outind
        // https://www.w3schools.com/java/ref_string_comparetoignorecase.asp
         System.out.print("Enter two words: ");
        String wordOne = input.nextLine();
        String wordTwo = input.nextLine();

               if (wordOne.compareToIgnoreCase(wordTwo) < 0) {
            System.out.println(wordOne + " comes before " + wordTwo);
        } else if (wordOne.compareToIgnoreCase(wordTwo) > 0) {
            System.out.println(wordTwo + " comes before " + wordOne);
        } else {
            System.out.println("Both strings are equal");
        }

        //e.
        
        System.out.print("Enter: ");
        int day = input.nextInt();
        
        switch(day){
            case 0 -> System.out.println("Saturday");
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            default -> System.out.println("Wrong input");
        }
           
    }
}
