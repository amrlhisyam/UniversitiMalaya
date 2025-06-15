
package tutorial6;

import java.util.* ;
public class T6Q3 {
    public static void main(String[] args) {
        double answer ;
        int n = 5, k = 3 ;
        answer = factorial(n) / factorial(k) - factorial(n-k) ;
        System.out.println(answer);
    }
    
    public static int factorial (int num){
        int result = 1; 
        for (int i = num ; i > 0 ; i--){
            result *= i ;
        }
        return result ;
    }
}
