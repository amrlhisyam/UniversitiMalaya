package tutorial4;

import java.util.Scanner;

public class L4Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ; 
    
        int score ; 
        int counter = 0 ;
        int sumScore = 0 ;
        int score2 = 0 ; 
        int minScore = 100 ; 
        int maxScore = 0 ; 
        double var ; 
        double avg ;
        
        while (true) {
            
        System.out.print("Enter score [negative to quit]: ");
        score = input.nextInt() ;
            
            if ( score < 0 ) {
                break ;
            }
            
            sumScore += score; 
            score2 += Math.pow(score,2) ;
        
            if ( score < minScore ) {
                minScore = score ; 
            }
            
            if ( score > maxScore ) {
                maxScore = score ;
            }
            
            counter++ ; 
        }
            
         avg = sumScore / counter ;
         var =( score2 - (Math.pow(sumScore , 2) / counter) ) / (counter - 1) ;
         double stdDev = Math.sqrt(var) ;
         
         System.out.println(var);
         System.out.println("Minimum score: " + minScore);
         System.out.println("Maximum score: " + maxScore);
         System.out.println("Average Score: " + avg);
         System.out.printf("Standard Deviation: %.2f \n" , stdDev);
         
    }
    
}
