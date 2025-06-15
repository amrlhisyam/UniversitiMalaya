
package tutorial4;
/* Write a simple two players dice game. Each player will take turns to roll a dice. The 
first players that reach more than 100 points win the game. If the player rolls a 6, the 
player will score 6 points and has the chance to roll again. */

import java.util.Random ;
import java.util.Scanner ; 
public class L4Q5 {
    
    public static void main(String[] args) {
        // player 1 roll 
        // add roll to totalpoints
        // if roll 6 
        // roll 1 more time
        // roll end
        // player 2 roll
        // add roll to totalpoints2
        //if roll 6
        // roll 1 more time
        // if totalpoints || totalpoints2 >= 100 ; 
        // break winner 
        Scanner input = new Scanner (System.in) ; 
        Random r = new Random () ; 
        
        System.out.println("Welcome to the dice game");
        System.out.println("the first player to reach 100 wins");
        
        
        int player1 = 0 ; 
        int player2 = 0 ;
        int currentplayer ; 
        int diceroll;
        final int min = 1 ; 
        final int max = 7 ;
        
            System.out.print("Enter current player: ");
            currentplayer = input.nextInt() ; 
            
        while (player1 <= 100 && player2 <= 100) {
                diceroll = r.nextInt(min,max) ; 
            
            if(currentplayer == 1) {
                if (diceroll == 6) {
                    player1 += diceroll;
                }
                else {
                player1 += diceroll ;
                System.out.print("Player 1 roll a " + diceroll + "\t");
                System.out.println("Total: " + player1 );
                currentplayer = 2 ; 
                }   
                
            }
                
            else  {
                diceroll = r.nextInt(min,max);
                if (diceroll == 6) {
                    player1 += diceroll;
                }
                else{
                player2 += diceroll ;
                System.out.print("Player 2 roll a " + diceroll + "\t");
                System.out.println("Total: " + player2 );
                currentplayer = 1 ;
                }
                
            }
            
            }
        
            
            System.out.println("Player1 score is: " + player1 + "\nplayer2 score is: " + player2);
            if (player1 >= 100) {
                System.out.println("Player 1 win , total : " + player1);
            }
            else {
                System.out.println("Player 2 win, total: " + player2);
        }
       
       
    }
}
