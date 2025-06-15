package Array;

import java.util.Random ; 
public class RaggedArrays {
    public static void main(String[] args) {
        Random r = new Random() ;  
        
        int arr [][] = new int [2][] ;
        
        arr[0] = new int [3] ; // 1st row has 3 column
        arr[1] = new int [5] ;  // 2nd row has 3 column
        
        final int MAX = 100 ; 
        
        // assign value
        for ( int i = 0 ; i < arr.length ; i++) {
            for ( int j = 0 ; j < arr[i].length ; j++) {
                arr[i][j] = r.nextInt(MAX) ; 
            }
        }
        
        //print jagged array
        for ( int i = 0 ; i < arr.length ; i++) {
            for ( int j = 0 ; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + " "); 
            }
            System.out.println();
        }
        
    }
}
