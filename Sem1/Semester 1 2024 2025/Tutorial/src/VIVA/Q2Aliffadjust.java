package VIVA;

import java.util.Scanner ; 
public class Q2Aliffadjust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Enter the starting value : ");
        int start_val = sc.nextInt();
        System.out.printf("Enter the ending value : ");
        int ending_val = sc.nextInt();
        
        System.out.println("");
        
        System.out.println("The output is : ");
        boolean Prime ; 
        
        for (int i = start_val; i <= ending_val; i++){
            Prime = isPrime(i) ; 
            if (Prime){
                System.out.println("LuluLala");
            }
            else if (i%5 == 0){
                System.out.println("Lala");
            }
            else if (i%3 == 0){
                System.out.println("Lulu");
            }
            else {
                System.out.println(i);
            }
        }
        
    }
    
    public static boolean isPrime (int num) {
        int counter = 0 ; 
        for ( int i = 1 ; i <= num ; i++) {
            if (num % i == 0 ) {
                counter++ ; 
            }
        }
        return counter == 2; 
    } 
}