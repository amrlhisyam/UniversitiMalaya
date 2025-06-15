package data;
/*1. divide and conquer
  2. recursion
  3. pivot
  4. tree
*/
import java.util.Random ;
public class quickSort {
    
    public static void quickSort(int [] arr, int low, int high){
        if (low<high){
            
            int pi = partition (arr,low,high) ;
            quickSort(arr, low, pi-1) ; 
            quickSort(arr,pi+1, high) ;
        }
    }
    
    private static int partition(int [] arr, int low, int high){
        int pivot = arr[high] ; 
        int i = low-1 ;
        
        for (int j=low ; j<high ; j++){
            if (arr[j] < pivot){
                i++; 
                swap(arr,i,j) ;
            }
        }
       swap(arr, i+1, high) ;
        
        return i+1 ; 
        
    }
    
    private static void swap(int arr[] ,int i, int j ){
        int temp = arr[i] ; 
        arr[i] = arr[j] ; 
        arr[j] = temp ; 
        
    }
    
    public static void random (int[]arr){
        Random r = new Random() ; 
        for (int i=0 ; i<arr.length ; i++){
            int genRan = r.nextInt(100) ;  
            arr[i] = genRan; 
        }
        System.out.println("before sort: ");
        for (int i:arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[10] ;
        
        random(arr) ; 
        quickSort(arr, 0 , arr.length-1) ;
        
        System.out.println("after sort: ");
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
