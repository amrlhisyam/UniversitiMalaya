package string;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
public class Stringlength {
    public static void main(String[] args) {
        String message = "Welcome to java";
        System.out.println(message.length());
        
        //getting character from a string 
        // use s.charAt(index)
        System.out.println(message.charAt(14));
        
        //changing from uppercase to lowercase
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
    }
}
