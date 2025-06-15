
package tutorial4;

import java.util.Scanner;

public class L4Q7 {
    
    public static void main(String[] args){
        
        //ASKING FOR INPUT
        Scanner scan = new Scanner(System.in);
        double principal, interestRate, noMonths;
        
        System.out.print("Enter principal amount: ");
        principal = scan.nextDouble();
        System.out.print("Enter interest in %: ");
        interestRate = scan.nextDouble();
        System.out.print("Enter total number of month(s): ");
        noMonths = scan.nextDouble();
        
        //CALCULATIONS AND TABLE OUTPUT
        double mInterestRate, mPayment, principalDue, interestDue, totalInterest = 0, uBalance = principal ;
        mInterestRate = interestRate / 1200;
        System.out.printf("Month\t"+"\t%-15s\t%-9s\t%-8s\t%-14s\t\t%-14s\n", "Monthly Payment", "Principal", "Interest", "Unpaid Balance", "Total Interest");
        
        for (int bulan = 1 ; bulan <= noMonths ; bulan++){
            
            mPayment = (principal * mInterestRate)/(1 - Math.pow(1 + mInterestRate , -noMonths));
            principalDue = mPayment * Math.pow(1 + mInterestRate , -(1 + noMonths - bulan));
            interestDue = mPayment - principalDue;
            totalInterest += interestDue;
            uBalance -= principalDue;
            
            System.out.printf("%-5d\t\t%15.2f\t%9.2f\t%8.2f\t%14.2f\t\t%14.2f\n", bulan, mPayment, principalDue, interestDue, uBalance, totalInterest);

        }
        
    }
    
}