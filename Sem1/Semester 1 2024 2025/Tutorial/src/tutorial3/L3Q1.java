package tutorial3;

import java.util.Scanner;

public class L3Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter two integer number: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        
        //  This extra call consumes the leftover newline character,
        //  clearing the input buffer and allowing your next input.nextLine() to read the actual operand input correctly
        input.nextLine(); 
        
        System.out.print("Enter the operand: ");
        String operandFake = input.nextLine(); // read input
        char operand = operandFake.charAt(0); // determine operand
        
        switch (operand) {
            case '+':
                System.out.println(num1 + " " + operandFake.charAt(0) + " " + num2 + " = " + (num1 + num2));
                break;
            case '-' :
                System.out.println("The difference between " + num1 + " and " + num2 + " is " + Math.abs(num1 - num2));
                break;
            case '*' :
                System.out.println(num1 + " " + operandFake.charAt(0) + " " + num2 + " = " + (num1 * num2));
                break;
            case '/' :
                System.out.println(num1 + " " + operandFake.charAt(0) + " " + num2 + " = " + (num1 / num2));
                break;
            case '%' :
                System.out.println(num1 + " " + operandFake.charAt(0) + " " + num2 + " = " + (num1 % num2));
                break;

        }
    }
}
