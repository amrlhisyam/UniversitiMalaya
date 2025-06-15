/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial3;

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class L3Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        // coordinate and radius
        System.out.print("Enter x coordinate: ");
        double x = input.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = input.nextDouble();
        System.out.print("Enter the radius of circle: ");
        double radius = input.nextDouble();
        
        // use distance between two point < radius
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        
        System.out.println("Your coordinate is: (" + x + " , " + y + ")");
        System.out.println("The circle has a radius of: " + radius);
        
        if (distance < radius)
            System.out.println("Point is inside the circle");
        else if (distance > radius)
            System.out.println("Point is outside the circle");
        else 
            System.out.println("Point is on the circle");
    }
}
