
package Array;

import java.util.Random ; 
public class Exercise5 {
    public static void main(String[] args) {
        Random r = new Random() ; 
        int size = 20 ; 
        final int MAX = 100 ; 
        int [] arr = new int [size] ; 
        
        for ( int i = 0 ; i < arr.length ; i++) {
            arr[i] = r.nextInt(MAX) ; 
        }
        
        System.out.println("Before sort: ");
        for ( int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        
        for ( int pass = 1 ; pass < arr.length ; pass++) {
            for ( int i = 0 ; i < arr.length - 1 ; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i] ; 
                    arr[i] = arr[i+1] ; 
                    arr[i+1] = temp ; 
                }
            }
        }
        System.out.println();
        System.out.println("Bubble sort: ");
        for ( int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        
    }
}
