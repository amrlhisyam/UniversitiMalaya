/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial3;

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class L3Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double comm = 0;
        
        System.out.print("Enter sales volume: ");
        int salesVolume = input.nextInt();
        
       if (salesVolume > 1000)
           comm = (salesVolume - 1000)*0.125 + (1000-500)*0.10 + (500-100)*0.075 + 100*0.5 ;
       else if (salesVolume > 500 && salesVolume <= 1000)
           comm = (salesVolume-500)*0.10 + (500-100)*0.075 + 100*0.5 ;
       else if (salesVolume > 100 && salesVolume <= 500)
           comm = (salesVolume-100)*0.075 + 100*0.5 ;
       else if (salesVolume > 0 && salesVolume <= 100)
           comm = salesVolume*0.5 ;
       else 
            System.out.println("Error");
       
       System.out.printf("Your commision is RM %.2f\n" , comm);
        
        
    }
 
}
