package tutorial3;

import java.util.Scanner; 

public class T3Q5v2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        if( year % 4 == 0 && year %100 != 0 )
            System.out.println("leap year");
        else if (year % 400 == 0)
            System.out.println("leap year");
        else 
            System.out.println("not a leap year");
    }
}
