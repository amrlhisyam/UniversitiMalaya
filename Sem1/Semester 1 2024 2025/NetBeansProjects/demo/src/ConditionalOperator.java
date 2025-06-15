/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.*;

public class ConditionalOperator {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();
        
        // if boolean expression is true(num1 > num2) --> the result is expression 1 (num1)
        // otherwise the result is expression 2 (num2)
        int max = (num1 > num2) ? num1 : num2 ;
        
        System.out.println("Max number is " + max);
    }
    
}
