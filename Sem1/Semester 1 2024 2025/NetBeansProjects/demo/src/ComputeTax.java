/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class ComputeTax {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter filing status :");
        System.out.println("\t0 for single filers");
        System.out.println("\t1 for married filing jointly or qualified window");
        System.out.println("\t2 for married filing seperately");
        System.out.println("\t3 for head of household");
        
        System.out.print("Status: ");
        int status = input.nextInt();;
        
        System.out.print("Enter your taxable income: ");
        double income = input.nextDouble();
        
        double tax = 0;
        
        if(status == 0){
            if(income <= 8350)
                tax = income * (double)(10/100);
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 82250)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            else if (income <= 171550)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            else if (income <= 372950)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            else if (income >= 372951)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            else
                System.out.println("Input error");
        }
              
        System.out.println("Tax :$" + tax);
        
        // can do more for other status 
    }
    
}
