package tutorial4;

import java.util.Scanner;

public class L4Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        
        System.out.print("Enter an Integer: ");
        int number = input.nextInt();
        input.nextLine();
        
        int i,k ;
        for(k = 0 ; k < 1 ; k++) {
            System.out.print("The factors are: ");
            for(i = 1 ; i <= number ; i++)
                if(number % i == 0){
                    System.out.print(i+", ");
            }
        }
        
    }
}
