/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial2;

import java.util.Scanner;

public class L2Q4 {
    public static void main(String[] args) {
        Scanner time = new Scanner(System.in);
        int secondInput,second,hour,minute;
        
        System.out.print("Enter the number of second: ");
        secondInput = time.nextInt();
        
        hour = secondInput/3600;
        minute = (secondInput%3600)/60;
        second = secondInput%60;
        System.out.println(secondInput + " seconds is "+hour + 
                " hours,"+minute+" minutes and "+second+" seconds");
    }
}
