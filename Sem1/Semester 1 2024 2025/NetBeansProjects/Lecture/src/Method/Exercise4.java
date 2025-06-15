
package Method;

import java.util.Scanner; 
public class Exercise4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in) ; 
        double height , width ,radius; 
        
        System.out.print("ENter height and width: ");
        height = input.nextDouble() ; 
        width  = input.nextDouble() ;
        
        
        System.out.print("Enter radius: ");
        radius = input.nextDouble() ;
        
        System.out.println("Perimeter of rectangle: " + getPerimeter(height,width)) ;
        System.out.println("Circumference of circle: " + getCircumference(radius)) ;
        
    }
    
    public static double getPerimeter(double n , double m) {
        return (n+m)*2 ; 
    }
    
    public static double getCircumference (double a) {
        return 2*Math.PI*a ; 
    }
    
}
