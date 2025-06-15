
package Method;

import java.util.Scanner ;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.print("Enter A: ");
        int A = input.nextInt() ; 
        System.out.print("ENter B: ");
        int B = input.nextInt() ; 
        boolean isValid = valid (A,B) ;
        if(isValid) {
            square(A,B) ; 
        }
        else {
            System.exit(0);
        }
        System.out.println();
    }
    public static void square(int A , int B) {
        for (int i = A ; i <= B ; i++) {
            System.out.print(i*i + " ");
        }
    }
    public static boolean valid (int A , int B) {
        return A<= B ;
    }
    public static void input() {
        
    }
}
