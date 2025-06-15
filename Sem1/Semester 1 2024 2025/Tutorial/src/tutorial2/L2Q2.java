/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial2;

import java.util.Scanner;

public class L2Q2 {
    public static void main(String[] args) {
        Scanner car = new Scanner(System.in);
        double P,D,R,M;
        int Y;
        
        System.out.print("Enter the price of the car: ");
        P = car.nextDouble();
        
        System.out.print("Enter the down payment: ");
        D = car.nextDouble();
        
        System.out.print("Enter the Interest Rate in %: ");
        R = car.nextDouble();
        
        System.out.print("Enter the loan duration in year: ");
        Y = car.nextInt();
        
        M = (P-D)*(1+R*Y/100)/(Y*12);
        System.out.printf("Monthly payment for car loan: %.2f\n",M);
    }
    
}
