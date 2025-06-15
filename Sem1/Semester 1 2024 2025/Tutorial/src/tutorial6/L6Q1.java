// num[0] = 1 ; 1
// num[1] = 3 ; 1+2
// num[2] = 6 ; 1+2+3
// num[3] = 10 ; 1+2+3+4
// num[4] = 15 ; 1+2+3+4+5
package tutorial6;

import java.util.* ;

public class L6Q1 {
    public static void main(String[] args) {
        
        int [] num = new int [20] ; 
        int n = 20 ;
        triangle(num,20) ;
        
    }
    
    public static void triangle (int arr[],int n) {
        
        int sum = 0 ;
            for ( int i = 1, c = 0; i <= n ; i++,c++ ) {
                sum = sum + i ; 
                arr[c] = sum ; 
            }
            for ( int i = 0 ; i < n ; i++ ) {
                System.out.print(arr[i] +" ");
        }
    }
}
