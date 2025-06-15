/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;
import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        int lottery = r.nextInt(0,100);
        
        System.out.print("Enter your lottery pick (Two digits number) : ");
        int lotteryPick = input.nextInt();
        // use divide and modulus to get each number
        // 69 / 10 = 6 >> determine first number
        // 69 % 10 = 9 >> determine second number
        
        // exact order 
        if ((lottery / 10 == lotteryPick / 10) && (lottery % 10 == lotteryPick % 10)){
            System.out.println("Exact match !!");
            System.out.println("The award is $10,000!");
        }
        
        // all digits enter is correct
        else if (((lottery / 10 == lotteryPick / 10) && (lottery % 10 == lotteryPick % 10)) || 
                ((lottery / 10 == lotteryPick % 10) && (lottery % 10 == lotteryPick / 10))) {
            System.out.println("Match all digits !!");
            System.out.println("The award is $3000");
        }
        
        // one digit correct
        
        else if (((lottery / 10 == lotteryPick / 10) || (lottery % 10 == lotteryPick % 10)) || 
                ((lottery / 10 == lotteryPick % 10) || (lottery % 10 == lotteryPick / 10))){
            System.out.println("Match one digit !!");
                System.out.println("The award is $1,000");
        }
        
        else {
           System.out.println("Sorry, no match");
        }
        
        System.out.println("lottery is " + lottery);
    }
}
