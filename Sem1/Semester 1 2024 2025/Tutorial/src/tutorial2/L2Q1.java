/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial2;

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class L2Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fah = input.nextDouble();
        
        double cel = (fah - 32) / 1.8;
        
        System.out.printf("Temperature in Celcius is : %.2f Celcius\n" , cel);
    }
}
