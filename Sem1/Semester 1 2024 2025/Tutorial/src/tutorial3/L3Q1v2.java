package tutorial3;

import java.util.Scanner;

public class L3Q1v2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter two integer number: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        
        System.out.print("Enter the operand: ");
        char operand = input.next().charAt(0);
        
        switch (operand) {
            case '+' :
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-' :
                System.out.println("The difference between " + num1 + " and " + num2 + " is " + Math.abs(num1 - num2));
                break;
            case '*' :
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/' :
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                break;
            case '%' :
                System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
                break;

        }
    }   
}
