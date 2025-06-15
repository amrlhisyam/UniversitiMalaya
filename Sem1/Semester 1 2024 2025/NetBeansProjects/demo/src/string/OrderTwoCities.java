/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;
import java.util.Scanner;
public class OrderTwoCities {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter city 1");
        String c1 = input.nextLine();
        System.out.println("Enter city 2");
        String c2 = input.nextLine();
        
        if(c1.compareToIgnoreCase(c2)<0)
            System.out.println("The cities in alphabetical order " + c1 + " " + c2);
        else if(c1.compareToIgnoreCase(c2)>0)
            System.out.println( "The cities in alphabetical order " + c2 + " " + c1);
        else
            System.out.println(c1 + " = " + c2);
            
    }
}
