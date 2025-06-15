
package VIVA;

import java.util.Scanner ; 
public class Q3Amir {
    public static void main(String[] args) {
        
    
          Scanner key = new Scanner(System.in);
      System.out.print("Enter 1st angle: ");
      double a = key.nextDouble();
      System.out.print("Enter 2nd angle: ");
      double b = key.nextDouble();
      System.out.print("Enter 3rd angle: ");
      double c = key.nextDouble();
      double sumAngle = a + b + c;
      if (sumAngle != 180.0D) {
         System.out.println("\nThe triangle is not valid.");
      } else {
         System.out.println("\nThe triangle is valid.");
         if (a == b && a == c) {
            System.out.println("It is an equilateral triangle.");
         }

         if (a == 90.0D || b == 90.0D || c == 90.0D) {
            System.out.println("It is a right-angled triangle.");
         }

         if (a == b || a == c || b == c) {
            System.out.println("It is an isosceles triangle.");
         }

         if (a != b && a != c && b != c) {
            System.out.println("It is scalene triangle.");
         }
      }
    }
}

   


