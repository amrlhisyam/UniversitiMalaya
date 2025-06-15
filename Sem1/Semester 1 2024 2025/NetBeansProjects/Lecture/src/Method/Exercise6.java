//create a getOddEven 
package Method;

import java.util.* ;
public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        
        System.out.print("Enter size of array : ");
        int a = input.nextInt();
        System.out.print("Enter min  : ");
        int b = input.nextInt();
        System.out.print("Enter max  : ");
        int c = input.nextInt();
        
        int num[] = new int [a] ;
        
        Random r = new Random() ;
        System.out.println("Random number is : ");
        for (int i = 0 ; i < num.length ; i++) {
            num[i] = r.nextInt(b,c) ;
            System.out.print(num[i] + " ");
        }
        
        getOddEven(num,b,c) ;
    }
    
    public static void getOddEven(int arr[] , int b ,int c) {
        int countEven = 0 ;
        int countOdd = 0 ;
        
        for ( int i = 0 ; i < arr.length ; i++) {
            if (arr[i] % 2 == 0) {
                countEven++ ;
            }
            else {
                countOdd++ ; 
            }
        }
        System.out.println("\nNumber of odd is : " + countOdd);
        System.out.println("Number of even is : " + countEven);
    }
}
