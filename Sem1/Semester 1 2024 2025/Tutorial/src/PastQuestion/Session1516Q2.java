package PastQuestion;

/*Ahmad is a popular durian seller in KL. Write a Java program that calculates the 
total sales for Ahmad based on the table below. The program will display the total 
sales in two decimal places. The program will terminate if the user enter Quit. (Copy 
the Main.java answers file to your exam account directory and rename it as 
[matricNumberQ2.java], example: WEK150001Q2.java)*/

import java.util.Scanner;

public class Session1516Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String typeDurian;
        double kgDurian ; 
        double priceDurian = 0.0 ;
        
        
        while(true){
        System.out.print("Enter the type of durian [Quit] to terminate: ");
        typeDurian = input.nextLine();
        
        if(typeDurian.equalsIgnoreCase("Quit"))
            break;
        
        switch (typeDurian) {
            case "MK" : 
               System.out.print("Enter the sales in kg: ");
                kgDurian = input.nextDouble(); 
                priceDurian += kgDurian*25 ; 
                break ; 
            case "HL" : 
               System.out.print("Enter the sales in kg: ");
                kgDurian = input.nextDouble(); 
                priceDurian += kgDurian*22 ; 
                break ; 
            case "D24" : 
               System.out.print("Enter the sales in kg: ");
                kgDurian = input.nextDouble(); 
                priceDurian += kgDurian*20 ; 
                break ; 
            case "UM" : 
               System.out.print("Enter the sales in kg: ");
                kgDurian = input.nextDouble(); 
                priceDurian += kgDurian*18 ; 
                break ; 
            default: 
                System.out.println("Error");
        }
        input.nextLine(); // important always remember to clear buffer
        }
            System.out.printf("Total sales :  %.2f ", priceDurian);
}
}
        
 

