/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan2;
import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double  initialFee = -1;
        double  rate = -1;
        int year = -1;
        System.out.print("Enter initial tuition fee (i.e year 1): ");
        initialFee = sc.nextDouble();
        System.out.print("Enter the yearly rate of increment (e.g enter 5.2 for 5.2%): ");
        rate = sc.nextDouble();
        System.out.print("Enter the year fow which you wish to compute the tuition fee for: ");
        year = sc.nextInt();
        System.out.printf("""
                      Computed tuition fee for year %d is: %.2f
                      """, year,computeFee(initialFee, rate, year));
    }
    
    public static double computeFee(double initialFee, double rateOfIncrement, int year){
        double fee = -1;
        double per = rateOfIncrement/100 ;
        for(int i=1 ; i< year; i++){
            fee = initialFee * Math.pow(1+per,i);
        }
        return fee;
    }
}
