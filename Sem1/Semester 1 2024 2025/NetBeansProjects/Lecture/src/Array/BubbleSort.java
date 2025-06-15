
package Array;


public class BubbleSort {
    public static void main(String[] args) {
        int [] b = {29, 10, 14, 37, 13} ; 
        
        for (int pass = 1 ; pass < b.length ; pass++) {
            for (int i = 0 ; i < b.length - 1 ; i++) {
                if (b[i] > b[i+1]) {
                int hold = b[i] ; 
                b[i] = b[i+1] ; 
                b[i+1] = hold ; 
                }
            }
        }
        
        for (int i = 0 ; i < b.length ; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
