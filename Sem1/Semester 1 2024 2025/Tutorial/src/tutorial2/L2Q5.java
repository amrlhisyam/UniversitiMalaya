/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial2;

import java.util.Random;

public class L2Q5 {
    public static void main(String[] args) {
        Random r = new Random();
        int min = 0 , max = 10000;
        
        int number = r.nextInt(min , max);
        System.out.print("The random number is: " + number);
        System.out.println("");
        
        int sum = 0;
        sum += number / 10000;    // 1234 / 10000 = 0
        number %= 10000;          // 1234 % 10000 = 0
        sum += number / 1000;     // 1234 / 1000 = 1
        number %= 1000;           //  1234 % 1000 = 234
        sum += number / 100;      // 234 / 100 = 2
        number %= 100;            // 234 % 100 = 34
        sum += number / 10;       // 34 / 10 = 3
        number %= 10;             // 34 % 10 = 4
        sum += number;            // 4
        
        System.out.println("Sum of all the digits in the number is: " + sum);
    }
}
