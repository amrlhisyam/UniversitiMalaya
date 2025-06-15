/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week.pkg3;
import java.util.Random;

/**
 *
 * @author Hisyam
 */
public class Week3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random play = new  Random();
        int player1,player2;
        int max,min;
        min = 1;
        max = 7;
        player1 = play.nextInt (min , max);
        player2 = play.nextInt (min , max);
        System.out.println("Player 1 roll a " + player1);
        System.out.println("Player 2 roll a " + player2);
        
        if(player1>player2){
            System.out.println("Player 1 win!!!!");
        }
        else if(player1<player2){
            System.out.println("Player 2 win!!!!");
        }
        else {
            System.out.println("Tie ^^");
        }
    }   
}
