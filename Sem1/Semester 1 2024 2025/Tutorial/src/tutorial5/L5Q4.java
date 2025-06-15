
package tutorial5;

public class L5Q4 {
    public static void main(String[] args) {
        int row = 3 , col = 3 ; 
        int arr[][] =  {{1,5,7,} , {3,6,9} , {5,3,8}} ;
        //display before rotate
        System.out.println("3 by 3 Matrix"); 
        for (int i = 0 ; i < row ; i++) {
            for (int k = 0 ; k < col ; k++) {
                System.out.print(arr[i][k] + " ");
            }
        System.out.println();
        }
        //display after rotate
        System.out.println("Afte rotate 90 degreed clockwose");
        //transpose the matrix --> col become row
        for (int i = 0 ; i < row ; i++) {
            for (int k = i + 1 ; k < col ; k++) {
                int temp = arr[i][k] ; // introduce a temporary holder
                arr[i][k] = arr[k][i] ; 
                arr[k][i] = temp ;
            }
        }
        //reverse each row
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col / 2 ; j++) { // swap until the middle of the array only to avoid double swapping
                int temp = arr[i][j] ;
                arr[i][j] = arr[i][col-1-j] ; // 
                arr[i][col-1-j] = temp ;
            }
        }
        
        //print matrix
        for (int i = 0 ; i < row ; i++) {
            for (int k = 0 ; k < col ; k++) {
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }
}
