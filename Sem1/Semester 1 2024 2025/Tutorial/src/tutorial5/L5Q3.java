package tutorial5;

import java.util.Random ; 
import java.util.Scanner ;
/*
Write a program that randomly generate the seven day work hours (1-8 hours) for N 
employee. Then, display the work hours in seven days and the total hours for each 
employee. 
*/
public class L5Q3 {
    public static void main(String[] args) {
        Random r = new Random() ;
        Scanner input = new Scanner(System.in) ;
        // minimum and maximum working hours
        final int MIN = 1 ; 
        final int MAX = 8 ; 
        // prompt for number of employees
        int N ;
        System.out.print("Enter number of employee: ");
        N = input.nextInt() ; 
        System.out.println();
        //create array for number of employees --> use to store total hours
        int employee[] = new int [N] ;
        // create array for hours
        int []workingHours ; 
        workingHours  = new int[7] ; 
        
        // asign random working hours to employee
        for (int k = 0 ; k < N ; k++)
            for (int i = 0 ; i < 7 ; i++) {
                workingHours[i] = r.nextInt(MIN,MAX+1) ;
                employee[k] += workingHours[i] ; 
            }
        //create array days
        String days[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"} ;
        //display working hours for 7 days
        for (int k = 0 ; k < N ; k++) {
            int a = k+1 ;
            System.out.println("Employee: " + a);
            for (int i = 0 ; i < 7 ; i++) {
                System.out.println(days[i] + ": " + workingHours[i]);
            }
            System.out.println("Total working hours is: " + employee[k] + " hours.");
            System.out.println();
        }
    }
}
