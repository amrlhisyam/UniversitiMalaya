/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;

import java.util.Scanner;

/**
 *
 * @author Hisyam
 */
public class subString {
    public static void main(String[] args) {
        String message = "Welcome to Java";
        System.out.println(message);
        System.out.println(message.substring(2));
        System.out.println(message.substring(0,11));
        String submessage = message.substring(0,11) + "HTML";
        System.out.println(submessage);
        
        // return tha index of the first occurence of ch in the string
        // if no match return -1
        System.out.println(message.indexOf('b'));
        System.out.println(message.indexOf('a')); // a occur at index 12
        
        
        System.out.println(message.indexOf('e' , 2)); // start find match from index 2
        // the e at index 1 is ignore
        // retunr -1 if mismatched
        
        String m2 = " to Welcome is Welcome";
        System.out.println(m2.indexOf("Welcome")); // return the index of the first Welcome written
        System.out.println(m2.indexOf("Welcome" , 5)); // return the index of the first Welcome written
        // from given index start match
        
        System.out.println(message.lastIndexOf('e'));
        System.out.println(m2.lastIndexOf("Welcome"));
        
        // application of substring, finding a character in substring
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = input.nextLine();
        
        int k = name.indexOf(' ');
        String firstName = name.substring(0,k);
        String lastName = name.substring(k+1);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        
                
    }
  
}
