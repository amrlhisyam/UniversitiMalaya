/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.*; // wildcard import (this import all classes
//                     from java.util package)

public class ComputeArea {
    // 1. read in the circle radius
    // 2. compute area using formula : area = radius x radius x pi
    // 3. display the result
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number for radius: ");
        double radius = input.nextDouble();
        
        if (radius < 0){
            System.out.println("Incorrect input");
        }
        else{
            double area;
            area = radius * radius * 3.14159;
            System.out.println("The area for the circle of radius " +radius + " is " + area);
        }
    }
}
