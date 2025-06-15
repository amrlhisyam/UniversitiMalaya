
package Array;

import java.util.Scanner ; 
import java.util.Random ; 
public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in) ; 
        Random r = new Random() ; 
        
        final int MAX = 20 ; 
        int size = 20 ; 
        int [] arr  = new int [size] ; 
        
        for ( int i = 0 ; i < arr.length ; i++) {
            arr[i] = r.nextInt(MAX) ; 
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.print("Enter number to search: ");
        int search = input.nextInt() ; 
        
        boolean valid = false ; 
        for (int cnt = 0 ; cnt < arr.length ; cnt++) {
            if (arr[cnt] == search) {
                System.out.println("Found in position " + cnt);
                valid = true ; 
            }
        }
        
        if (valid == false) {
            System.out.println("not found");
        }
        
        
    }
}
