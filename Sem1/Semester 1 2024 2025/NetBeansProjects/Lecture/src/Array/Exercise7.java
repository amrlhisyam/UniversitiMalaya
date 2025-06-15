
package Array;

import java.util.Scanner ; 
import java.util.Random ; 
public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in) ; 
        Random r = new Random () ; 
        
        final int MAX = 100 ; 
        
        int size = 20 ; 
        int arr[] = new int [size] ; 
        
        // assign value to arr 
        for ( int i = 0 ; i < arr.length ; i++) {
        arr[i] = r.nextInt(MAX) ; 
        }
        // print original arr
        for ( int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        //bubble sort
        for (int pass =  1  ; pass < arr.length ; pass++) {
            for(int i = 0 ; i < arr.length-1 ; i ++) {
                if ( arr[i] > arr[i+1]) {
                int hold = arr[i] ; 
                arr[i] = arr[i+1] ; 
                arr[i+1] = hold ;
                }
            }
        }
        
        // print sorted
        System.out.println("Bubble Sort");
        for ( int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        
        //user prompt
        System.out.print("Enter number to search: ");
        int number = input.nextInt() ; 
        
        // boolean search
        int low = 0 ; 
        int high = arr.length - 1 ; 
        int middle ; 
        
        boolean search = false ; 
        
        // binary search
        while (low <= high){
        middle = (low + high) / 2 ; 
        
        
        if (number == arr[middle]) {
            System.out.println("Found in position " + middle );
            search = true ; 
            break ; 
        }
        else if (number < arr[middle]) {
            high = middle - 1 ; 
        }
        
        else {
            low = middle + 1 ; 
        }
        
        }
        
        if ( search == false) 
            System.out.println("not found");
        
    }
    
}
