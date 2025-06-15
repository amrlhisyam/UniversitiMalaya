package tutorial4;

import java.util.Scanner;

public class L4Q2 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n, i, sum = 0, k, seriesSum = 0;
        
        System.out.print("Enter an integer: ");
        n = input.nextInt();
        
        
        for (i = 1 ; i < n ; i++){
                sum += i ;
            for (k = 0 ; k <i ; k++){
                sum += k;
            }
            seriesSum += sum ;
        }
        
        System.out.println("Sum of series is: " + seriesSum);
        
        
        
    }
}
