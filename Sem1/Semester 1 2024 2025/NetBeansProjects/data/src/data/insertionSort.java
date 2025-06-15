package data;
//shifting
public class insertionSort {
    public static void main(String[] args) {
        int nums[] = {3,6,2,1,5,10,0,-12} ;
        for (int i=1 ; i<nums.length ; i++){
            int key = nums[i];
            int j = i-1 ;
            while(j >=0 && nums[j] > key){
                nums[j+1] = nums[j] ; 
                j-- ; 
            }
            nums[j+1] = key ; 
        }
        
        for (int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
 
}
