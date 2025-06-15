package tutorial5;
import java.util.Scanner ; 
public class L5Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        //prompt user no. of row
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int n = input.nextInt() ;
        // declare array 
        int arr[][] = new int[n][n] ; 
        // asign value pascal to array
        for (int i = 0 ; i < n ; i++) {
            int number = 1 ;
            for (int j = 0 ; j <= i ; j++) {
                arr[i][j] = number ;
                number = number * (i-j) / (j+1) ; // tak faham
            }
        }
        //print array
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ;j < n ; j++) {
                System.out.printf("%-5d " , arr[i][j]);
            }
            System.out.println();
        }
    }
}
