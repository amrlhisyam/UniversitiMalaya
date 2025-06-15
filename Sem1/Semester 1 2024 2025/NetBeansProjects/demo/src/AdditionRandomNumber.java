/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Random;
import java.util.Scanner;

public class AdditionRandomNumber {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        int min=0 , max=10;
        
        int number1 = r.nextInt(min,max); // set range for random number generated
        int number2 = r.nextInt(min,max);
        int number3 = r.nextInt(min,max);
        
        System.out.println("What is " + number1 + " x " + number2 + " x " + number3 + " ? ");
        int answer = input.nextInt();
        
        System.out.println(number1 + " x " + number2 + " x " + number3 + " = " + answer + " is " + 
                (number1 * number2 * number3 == answer)); // using boolean to display wether 
                                                // the answer is true or false
    }
}
