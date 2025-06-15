
package tutorial6;
import java.util.Scanner ;
import java.util.Random ;
public class L6Q3 {
    
    public static void main(String[] args) {
        int num[] ;
        num = new int [10] ;
        getArray(num) ;
        
        for (int i = 0 ; i < num.length ; i++){
            int hold = num[i] ;
            num[i] = reverse(hold) ;
        }
        
        System.out.println("Array after reverse : ");
        for (int i = 0 ; i < num.length ; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
    
    public static void getArray(int arr[]) {
        Random r = new Random();
        for(int i = 0 ; i< arr.length ; i++) {
            arr[i] = r.nextInt(10000) ;
        }
        
        System.out.println("Array before reverse");
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int reverse(int number){
        int rev = 0 ;
        while (number != 0) {
            rev = rev*10 + number%10 ;
            number = number/10 ;
        }
        return rev ;
    }
}
