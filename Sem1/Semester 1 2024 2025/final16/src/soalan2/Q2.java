/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan2;

import java.util.Scanner;
import java.util.Random;
public class Q2 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int computerWins=0;
        int playerWins=0;
        while(true){
            if(computerWins == 3 || playerWins == 3){
                break;
            }
            System.out.print("Enter 1.Paper 2.Scissor 3.Rock: ");
            int user = sc.nextInt();
            int comp = r.nextInt(1,4);
            
            
        if(user == 1 && comp == 1){
            System.out.println("Player : Paper ----- Computer : Paper");
            System.out.println("Tie!");
        }
        else if(user == 1 && comp == 2){
            System.out.println("Player : Paper ----- Computer : Scissor");
            computerWins++;
            System.out.println("Computer win " + computerWins + " 1 times(s)");
        }
        else if(user == 1 && comp == 3){
            System.out.println("Player : Paper ----- Computer : Rock");
            playerWins++;
            System.out.println("Player  win " + playerWins + " times(s)");
        }
        else if(user == 2 && comp == 1){
            System.out.println("Player : Scissor ----- Computer : Paper");
            playerWins++;
            System.out.println("Player win " + playerWins + " times(s)");
        }
        else if(user == 2 && comp == 2){
            System.out.println("Player : Scissor ----- Computer : Scissor");
            System.out.println("Tie!");
        }
        else if(user == 2 && comp == 3){
            System.out.println("Player : Scissor ----- Computer : Rock");
            computerWins++;
            System.out.println("Computer win " + computerWins + " times(s)");
        }
        else if(user == 3 && comp == 1){
            System.out.println("Player : Rock ----- Computer : Paper");
            computerWins++;
            System.out.println("Computer win " + computerWins + " times(s)");
        }
        else if(user == 3 && comp == 2){
            System.out.println("Player : Rock ----- Computer : Scissor");
            playerWins++;
            System.out.println("Player win " + playerWins + " times(s)");
        }
        else if(user == 3 && comp == 3){
            System.out.println("Player : Rock ----- Computer : Rock");
            System.out.println("Tie!");
        }
        else{
            System.out.println("Invalid Input.");
            }
        }
        
        if(computerWins == 3){
            System.out.println("Computer wins the game.");
        }
        else{
            System.out.println("Player wins the game");
        }
    }
    
}
