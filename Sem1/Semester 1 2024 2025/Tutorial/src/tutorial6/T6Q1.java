
package tutorial6;
import java.util.* ;
/**
1. Write statements for each of the following 
a. Define a static method that returns the maximum number from 3 integer 
parameters. 
b. Define a static method that that determine whether the given integer is a 
square number. 
c. Define a static method that use to compute combination function C(n,k). 
C(n,k) gives the number of different k-element subsets that can be found in a 
given set of n elements. C(n,k) = n! / (k! (n-k)!  
d. Define a static method that used to determine whether the parameter is a 
pentagonal number. A pentagonal number is a figurate number that extends 
the concept of triangular and square numbers to the pentagon. Pn = ½ n(3n -1) 
e. Define a static method that displays the number of letters and the number of 
digits of a String parameter. 
f. 
Define a static void method that generates 10 random numbers within 0 to 100 
to the method’s parameter. The random numbers can be accessed by the main 
method.    
g. Define a static void method that returns the area and the circumference of a 
circle given the argument is radius. Area = πr2 and Circumference = 2 πr. 
h. Define a static method that generate random number within 0 – 10. The 
method will return the first random number that generate twice. 
 */
public class T6Q1 {
    public static void main(String[] args) {
        
        int num[] = new int [10] ;
        random(num) ;
        
         
    }
    
        
    
    public static int compare(int a, int b, int c){
        if( a>=b && a>=c)
            return a;
        else if ( b>=a && b>=c)
            return b ;
        else
            return c;
    }
    
    public static boolean square(int num){
        if (num < 0)
            return false ; 
        else {
        double sqrtnum = Math.sqrt(num);
        return sqrtnum % 1 == 0;
        }
    }
    
    public static int function (int n, int k){
        System.out.println();
        return 0;
    }
    
    public static boolean pentagonal(int num){
        
        double formula = 0 ;
        for (int i = 1 ; i <= num ; i++){
            formula = (3*Math.pow(i,2) - i) / 2 ;
            if (num == formula)
                break ;
        }
        return num == formula ;
    }
    
    public static void display (String str){
        int digitcount = 0 ;
        int lettercount = 0 ;
        for (int i = 0 ; i < str.length() ; i++){
            char n = str.charAt(i);
            
            if (Character.isDigit(n)){
                digitcount++ ;
            }
            else if (Character.isLetter(n)){
                lettercount++ ;
            }
        }
        System.out.println(lettercount);
        System.out.println(digitcount);
    }
    
    public static void random (int arr[]){
        Random r = new Random() ;
        final int MAX = 100 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = r.nextInt(MAX+1) ;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void circle(double radius){
        double cfc , area ;
        cfc = 2*Math.PI*radius;
        area = Math.PI*Math.pow(radius, 2) ;
        System.out.printf("Circumference: %.2f  " , cfc);
        System.out.println();
        System.out.printf("Area: %.2f  " , area);
        System.out.println();
    }
    
    public static void randomTwice(){
        Random r = new Random() ;
        final int MAX = 10 ;
        
    }
}
