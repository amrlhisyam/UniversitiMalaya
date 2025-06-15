/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial3;

/**
 *
 * @author Hisyam
 */
import java.util.*;

public class L3Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        int min = 1, max = 7;
        
        
        int player1 = r.nextInt(min , max);
        int player1v2 = r.nextInt(min , max);
        int player2 = r.nextInt(min , max);
        int player2v2 = r.nextInt(min , max);
        
        System.out.println("Player1 rolls dice : " + player1 + " and " + player1v2 );
        System.out.println("Player2 rolls dice : " + player2 + " and " + player2v2 );
        
        if ((player1 + player1v2) > (player2 + player2v2))
            System.out.println("Player 1 win");
        else if ((player1 + player1v2) < (player2 + player2v2))
            System.out.println("Player 2 win");
        else 
            System.out.println("Draw");
    }
}
