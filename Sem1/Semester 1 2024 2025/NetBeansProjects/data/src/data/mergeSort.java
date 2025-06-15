package data;


public class mergeSort {
    
    public static void mergeSort(int[]arr, int left, int right){
        if (left<right){
            //find the mid point
            int mid = (left + right) / 2 ;
            
            // recursive to divide the first and second halves
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            
            //merge the sorted halve
            merge(arr,left,mid,right);
        }
    }
    
    
    public static void merge(int[]arr, int left, int mid, int right){
        
        //determine size of the temporary array
        int n1 = mid-left+ 1 ; 
        int n2 = right - mid ;
        
        //create a temporary array
        int [] Leftarr = new int[n1];
        int [] Rightarr = new int[n2];
        
        //copy data to the temporary array
        for (int x=0 ;x<n1; x++){
            Leftarr[x] = arr[left+x] ;
        }
        
        for (int x=0 ;x<n2; x++){
            Rightarr[x] = arr[mid+1+x] ;
        }
        
        int i=0; //left array
        int j=0; // right array
        int k=left; // main array
        
        
        while(i<n1 && j<n2) {
            if (Leftarr[i] <= Rightarr[j]){
                arr[k] = Leftarr[i] ;
                i++ ;
            }
            else {
                arr[k] = Rightarr[j] ;
                j++;
            }
            k++; 
        
        
        }
        
        while (i<n1){
            arr[k] = Leftarr[i] ;
            i++;
            k++;
        }
        
        while (j<n2){
            arr[k] = Rightarr[j] ;
            j++;
            k++;
        }
    }
    
    
    
    public static void main(String[] args) {
        int arr[] = new int [15] ;
        op.random(arr);
        System.out.println("before sorting");
        op.print(arr);
        
        mergeSort(arr,0,arr.length-1) ;
        
        
        
        System.out.println("After sorting: ");
        for(int n :arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
