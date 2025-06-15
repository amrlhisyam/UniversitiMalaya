/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial2;

import java.util.Scanner;

public class L2Q6 {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        double M,Q,initialTemp,finalTemp;
        
        System.out.print("Enter the amount of water in gram: ");
        M = w.nextInt();
        
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        initialTemp = w.nextDouble();
        
        System.out.print("Enter the final temperature in Fahrenheit: ");
        finalTemp = w.nextDouble();
        
        initialTemp = (initialTemp - 32)/1.8;
        finalTemp = (finalTemp - 32)/1.8;
        M /=1000;
        
        Q = M * ( finalTemp- initialTemp)*4184;
        System.out.printf("The energy needed is %e\n",Q);
        
        w.close();
    }
}
