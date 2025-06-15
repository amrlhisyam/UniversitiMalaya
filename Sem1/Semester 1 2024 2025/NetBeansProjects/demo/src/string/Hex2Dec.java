/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;

import java.util.Scanner;
public class Hex2Dec {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter a hex digit:");
        String hexString = input.nextLine();
        
        //convert hexadecimal to decimal
        //can only accept one digit
        
        if(hexString.length() != 1){
            System.out.println("You can only enter one digit");
            System.exit(1);
        }
                   
        char ch = Character.toUpperCase(hexString.charAt(0));
        if(ch >= 'A' && ch <= 'F'){
            int value = ch - 'A' + 10;
            System.out.println(ch + " is " + value);
        }
        else if (Character.isDigit(ch)) {
            System.out.println(ch + " is " + ch);
        }
        else
            System.out.println("Invalid");
        
    
    }
}
