package data;

import java.util.Random;

public class selectionSort {
     public static void random (int[]arr){
        Random r = new Random() ; 
        for (int i=0 ; i<arr.length ; i++){
            int genRan = r.nextInt(100) ;  
            arr[i] = genRan; 
        }
    }
     
    public static void main(String[] args) {
        int nums[] = new int[10] ;
        int size = nums.length ; 
        int minIndex;
        int temp ;
        random(nums) ; 
        
        System.out.println("before sorting");
        for (int num : nums){
            System.out.print(num + " ");
        }
        for (int i=0 ; i<size-1 ; i++){
            minIndex = i ;
            for (int j=i+1 ; j<size ;j++){
                if (nums[minIndex] > nums[j]){
                    minIndex = j ;
                }
            }
            
            temp = nums[minIndex] ; 
            nums[minIndex] = nums[i] ; 
            nums[i] = temp ;
        }
        System.out.println();
        System.out.println("after sort: ");
        for (int i=0 ; i < size ; i++){
            System.out.print(nums[i] + " ");
        }
        
        System.out.println();
    }
 
}
