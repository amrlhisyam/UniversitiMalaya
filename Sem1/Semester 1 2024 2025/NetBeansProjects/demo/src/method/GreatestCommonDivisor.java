
package method;

import java.util.Scanner ; 
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 2 integer : ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        System.out.println("The greatest common divisor between " 
                +num1 + " and " + num2 + " is " + gcd(num1,num2));
        
    }
public static int gcd(int n1 , int n2) {
    
    int gcd = 1; // initial gcd is 1
    int k = 2; // possible gcd
    
    while (k <= n1 && k <= n2){
        if (n1 % k == 0 && n2 % k == 0)
            gcd = k ;
        k++;
    }
    return gcd;

}
}
