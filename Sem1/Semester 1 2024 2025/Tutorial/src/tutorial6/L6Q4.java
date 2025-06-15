package tutorial6;

import java.util.Scanner ;

public class L6Q4 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.print("Enter two numbers [a>b]: ");
        int num1 = input.nextInt() ;
        int num2 = input.nextInt() ;
        System.out.println("The greatest common divisor from "+ num1 +
                " and " + num2 + " is: " + gcd(num1,num2));
    }
    
    /*
    Euclidean Algorithm : continue doing division until we get a remainder of 0.
    This will tell us that the last value of b divides perfectly, and we are done!.
    */
    
    public static int gcd (int a, int b){
        
        if(b>a){
        int temp = a ;
        a = b ;
        b = temp ;
        }
        
        int remainder, answer;
        do{
            remainder = a%b ;
            a = b ; 
            answer = b ;
            b = remainder ;
        }while(remainder != 0 );
        return answer; 
    }
}
