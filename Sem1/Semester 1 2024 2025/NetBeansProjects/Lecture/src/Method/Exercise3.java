
package Method;

import java.util.* ;
public class Exercise3 {
    public static void main(String[] args) {
        int x = 10 , y = 50 , n = 10 ;
        randomnumber(n,x,y) ;
        System.out.println();
    }
    
    public static void randomnumber(int N , int A , int B) {
        Random r = new Random() ; 
        for (int i = 0; i < N ; i++) {
            System.out.print(r.nextInt(A,B) + " ");
        }
    }
}
