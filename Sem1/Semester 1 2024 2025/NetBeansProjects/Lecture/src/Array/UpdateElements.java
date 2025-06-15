
package Array;

import java.util.* ; 
public class UpdateElements {
    public static void main(String[] args) {
        Random r = new Random() ; 
        final int MAX = 100 ; 
        int size = 20 ; 
        int num[] = new int[size] ; 
        
        for (int i = 0 ; i < num.length ; i++) {
            num[i] = r.nextInt(MAX + 1) ; 
        }
        
        for (int i = 0 ; i < num.length ; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
