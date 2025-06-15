
package data;


public class bubbleSort {

    public static void main(String[] args) {
        int nums[] = {6,5,2,8,9,4} ;
        int size = nums.length ; 
        int temp = 0 ;
        boolean swapped ;
        
        System.out.println("before sorting");
        for (int num : nums){
            System.out.print(num + " ");
        }
        
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size-1 ; j++){
                if (nums[j] > nums[j+1]){
                    temp = nums[j] ; 
                    nums[j] = nums[j+1] ; 
                    nums[j+1] = temp ; 
                    swapped = true ; 
                }
            }
        }
        
        // better bubble sort [as the largest element already bubble to 
        // the last index of the arrat] 
        for (int i = 0 ; i < size-1 ; i++){
            swapped = false ;
            for (int j = 0 ; j < size-1-i ; j++){
                if (nums[j] > nums[j+1]){
                    temp = nums[j] ; 
                    nums[j] = nums[j+1] ; 
                    nums[j+1] = temp ; 
                    swapped = true ; 
                }
            }
            if (!swapped){
                break ;
            }
        }
        
        System.out.println();
        System.out.println("after sort");
        for (int num : nums){
            System.out.print(num + " ");
        }
        
        System.out.println();
    }
    
}
