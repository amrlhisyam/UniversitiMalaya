package tutorial6;

import java.util.Scanner ;
import java.util.Random ;

public class L6Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter negative number to quit.");
        
        Random r = new Random();
        final int MAX = 12 ;
        
        int num1, num2, num3;
        
        int counter = 0;
        do{
            num1 = r.nextInt(MAX+1);
            num2 = r.nextInt(MAX+1);
            
            System.out.print(num1 + " x " + num2 + " = ");
            num3 = input.nextInt() ;
            
            if(compare(num1,num2,num3)){
                counter++ ;
            }
        }while(num3 >= 0);
        
        System.out.println("Your score is: " + counter);
    }

    public static boolean compare(int a, int b, int c){
        return c == a*b;
    }
}
