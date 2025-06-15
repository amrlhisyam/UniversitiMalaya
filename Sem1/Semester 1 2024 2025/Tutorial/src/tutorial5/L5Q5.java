
package tutorial5;

import java.util.Random ;
import java.util.Scanner ; 
public class L5Q5 {
    public static void main(String[] args) {
        Random r = new Random() ; 
        Scanner input = new Scanner(System.in) ;
        final int MIN = 0 ;
        final int MAX = 100 ;
        //asign size to array
        int arr[] = new int [20] ;
        //asign value to array
        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = r.nextInt(MIN,MAX) ;
        }
        //display array
        System.out.println("A list of 20 random integer within 0 to 100");
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //bubble sort array
        for (int pass = 1 ; pass < arr.length ; pass++){
            for (int i = 0 ; i < arr.length - 1 ; i++){
                if ( arr[i] < arr[i+1]) {
                int hold = arr[i] ; 
                arr[i] = arr[i+1] ; 
                arr[i+1] = hold ;
                }
            }
        }
        //display sorted array
        System.out.println("Array in descending order ");
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //prompt for search
        System.out.print("Enter a number to search: ");
        int search = input.nextInt() ; 
        
        // set boolean & counter
        int counter = 0 ;
        boolean found = false ;
        //Linear search
        for (int i = 0 ; i < arr.length ; i++) {
            counter++ ;
            if (arr[i] == search){
                System.out.println(search + " found");
                System.out.println("Linear Search - " + counter + " loop(s)");
                found = true; 
            }
        }
        if (!found) {
            System.out.println(search + " not found[Linear Search]");
        }
        //bubble sort to ascending order
        for (int pass = 1 ; pass < arr.length ; pass++) {
            for ( int i = 0 ; i < arr.length - 1 ; i++) {
                if (arr[i] > arr[i + 1]){
                int hold = arr[i] ; 
                arr[i] = arr[i + 1] ;
                arr[i+1] = hold ;
                }
            }
        }
        // asign high , low 
        int high = arr.length - 1 ; 
        int low = 0 ;
        int middle ;
        //set found , counter
        found = false ; 
        counter = 0 ;
        //binary search
        while ( low <= high) {
            counter++ ;
            middle = (low + high) / 2 ;
            
            if (search == arr[middle]) {
                System.out.println(search + " found");
                System.out.println("Binary Search - " + counter + " loop(s)");
                found = true ; 
                break ; 
            }
            else if (search < arr[middle]) {
                high = middle - 1 ; 
            }
            else {
                low = middle + 1 ;
            }
        }
        if (found == false) {
            System.out.println(search + " not found[Binary search]");
        }
    }
}
