
package Practice;

import java.util.Scanner ; 
public class FloydsTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.print("Enter row: ");
        int row = input.nextInt() ; 
        int spaces = row ; 
        int counter = 1 ; 
        for ( int i = 0 ; i < row ; i ++) {
            for (int s = 1 ; s <= spaces ; s++) {
                System.out.print(" ");
            }
            for ( int j = 0 ; j <= i ; j++ , counter++) {
                System.out.printf(counter + " ");
            }
            spaces-- ;
            System.out.println();
        }
    }
}
