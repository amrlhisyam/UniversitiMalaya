
package tutorial5;

import java.util.Random ; 
import java.util.Scanner ; 
public class L5Q1 {
    public static void main(String[] args) {
        Random r = new Random() ; 
        Scanner input = new Scanner(System.in) ; 
        
        
        // prompt n
        System.out.print("Enter N students: ");
        int n = input.nextInt() ; 
        
        // assign n to array
        int students[] = new int [n] ; 
        
        //set max value random
        final int MAX = 100 ; 
        
        //assign random score to students[]
        double sum = 0 ;
        for ( int i = 0 ; i < students.length ; i++) {
            students[i] = r.nextInt(MAX+1) ; 
            sum += students[i] ;
        }
        
        //display score 
        for ( int i = 0 ; i < students.length ; i++){
            System.out.print(students[i] + " ");
        }
        
        System.out.println();
        
        //find highest & lowest
        for ( int pass=1 ; pass < students.length ; pass++) {
            for ( int i = 0 ; i < students.length - 1 ; i++) {
            if (students[i] > students[i+1]) {
            int hold = students[i] ; 
            students[i] = students [i+1] ; 
            students[i+1] = hold ; 
                }
            }
        }
        
        
        System.out.println("Highest score: " + students[students.length-1]);
        System.out.println("Lowest score: " + students[0]);
        System.out.printf("Average score: %.2f", sum/(n));
        System.out.println();
        
        
    }
   
}
