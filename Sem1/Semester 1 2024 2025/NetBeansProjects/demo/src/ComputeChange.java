/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;
     
public class ComputeChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter amount in decimal number: ");
        double amount = input.nextDouble();
        
        int remainingAmount = (int)(amount * 100); // numeric type conversion
        
        int numDollars = remainingAmount / 100;
        remainingAmount %= 100;
        
        int numQuarter = remainingAmount / 25;
        remainingAmount %= 25;
        
        int numDimes = remainingAmount / 10; 
        remainingAmount %= 10;
        
        int numNickels = remainingAmount / 5;
        remainingAmount %= 5;
        
        int numPennies = remainingAmount;
        
        System.out.println("Your amount " + amount + " consist of :");
        System.out.println("\t" + numDollars + " dollars");
        System.out.println("\t" + numQuarter + " quarter");
        System.out.println("\t" + numDimes + " dimes");
        System.out.println("\t" + numNickels + " nickels");
        System.out.println("\t" + numPennies + " pennies");
        
        input.close();
    }
}
