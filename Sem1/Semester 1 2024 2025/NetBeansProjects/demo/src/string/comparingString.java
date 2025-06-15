/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;

/**
 *
 * @author Hisyam
 */
public class comparingString {
    public static void main(String[] args) {
        String string1 = "akb" , string2 = "akc" ;
        if(string1.equals(string2))
            System.out.println("String1 and Strin2 have the same content");
        else
            System.out.println("not equal");
        
        System.out.println(string1.equals(string2));
        
        //return 0 if it is true
        // return value greater than 0 if false
        // s1 is lexicographically greater than s2
        // return value less than 0 if false
        // s1 is lexicographically less than s2
        System.out.println(string1.compareTo(string2));
        
        System.out.println(string1.equalsIgnoreCase(string2));
        System.out.println(string1.compareToIgnoreCase(string2));
    }
}
