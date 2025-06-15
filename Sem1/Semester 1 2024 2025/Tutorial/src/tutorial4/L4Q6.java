
package tutorial4;

import java.util.Random ; 
public class L4Q6 {
    public static void main(String[] args) {
       Random r = new Random () ; 
       int integer = r.nextInt();
       int positive = Math.abs(integer) ;
       
        System.out.println(positive);
        int counter = 0 ; 
        
        while (positive > 0) {
        int ans = positive / 10 ; 
        positive = ans ; 
        counter ++ ; 
        }
        System.out.println(counter);
    }
}
