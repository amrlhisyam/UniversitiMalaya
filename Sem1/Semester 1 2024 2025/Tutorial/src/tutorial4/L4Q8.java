package tutorial4 ; 

import java.util.Random ; 

public class L4Q8 {
public static boolean prime (int num) {
    int counter = 0 ; 
    for ( int i = 1 ; i <= num ; i++) {
        if (num % i == 0) {
            counter++ ;
        }
    }   return counter == 2 ;
}   
    

    public static void main(String[] args) {
        
        Random r = new Random() ; 
        final int MAX = 100 ; 
        int n = r.nextInt(MAX+1) ; 
        System.out.println("n: " + n);
        
        boolean isPrime ; 
        
        for (int i = 0 ; i <= n ; i++) {
            isPrime = prime(i) ; 
            if (isPrime) {
                System.out.print( i + " "); 
            }
        }
    }
}

