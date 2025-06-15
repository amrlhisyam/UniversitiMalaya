
package VIVAKHAMIS;

import java.util.Scanner ;
public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in) ;
        System.out.print("Enter three integers: ");
        int n = input.nextInt() ;
        int a = input.nextInt() ;
        int b= input.nextInt() ;
        int counter = 0 ; 
        
        
        while ( n != 1) {
            if ( n % b == 0) {
                n = n / b ; 
                counter++ ;
            }
            else {
                n = n - a ; 
                counter++ ;
            }
            if ( n < 1 ) {
                System.out.println("-1");
                break ;
            }
        }
        
        if ( n == 1) {
            System.out.println(counter);
        }
    }
}
