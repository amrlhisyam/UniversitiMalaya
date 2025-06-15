
package Array;


public class Exercise1 {
    public static void main(String[] args) {
        int size = 100 ; 
        int num[] = new int[size] ; 
        
        num[0] = 12 ; 
        num[size - 1] = 89 ; 
        
        for (int i = 0 ; i < num.length ; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        
    }
}
