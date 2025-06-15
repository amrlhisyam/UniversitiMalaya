/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class SimpleIfDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = input.nextInt();
        
        if (integer % 5 == 0)
            System.out.println("HiFive");
        
        if (integer % 2 == 0)
            System.out.println("HiEven");
        
        boolean even = integer % 2 == 0; // boolean used
        System.out.println(even);
        
        // ouput both HiFive and HiEven
        // if "else if" is used it will only output the first condition met
    }
    
}
