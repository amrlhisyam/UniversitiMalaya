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

public class L3Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a , b , c , d , e , f  , x , y;
        
        System.out.println("Given equation: ");
        System.out.println("ax + by = e\tcx + dy = f");
        
        System.out.print("Enter a: ");
        a = input.nextDouble();
        System.out.print("Enter b: ");
        b = input.nextDouble();
        System.out.print("Enter e: ");
        e = input.nextDouble();
        
        System.out.print("Enter c: ");
        c = input.nextDouble();
        System.out.print("Enter d: ");
        d = input.nextDouble();
        System.out.print("Enter f: ");
        f = input.nextDouble();
        
        if (((a * d) - (b * c)) == 0)
            System.out.println("The equation has no solution");
        else{
            x = (((e * d) - (b * f))/((a * d) - (b * c)));
            y = (((a * f) - (e * c))/((a * d) - (b * c)));
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }
}
