
package Method;


public class passingArray {
    public static void main(String[] args) {
        // change the value of array
        int original[] = {1,2,3,4,5};
        special_arr(original) ;
        for ( int i = 0 ; i < 5; i++) {
        System.out.println(original[i]);
        }
        
        //does not change the original value
        int num = 1 ; 
        special(num) ;
        System.out.println((num));
        
        
    }
    public static void special_arr(int [] number) {
    number[1] = 77 ; 
    }
    
    public static int special(int num) {
        num = 99 ;
        return num ;
    }
}
