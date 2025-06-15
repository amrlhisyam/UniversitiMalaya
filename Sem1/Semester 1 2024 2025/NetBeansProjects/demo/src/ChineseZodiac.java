/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your year: ");
        int year = input.nextInt();
        
        year %= 12;
        
        //rule switch -> eliminating the need for break statement a
        //               it also enable multiple case labels to share the same code block
        switch(year){
            case 0 -> System.out.println("Monkey is your Zodiac sign");
            case 1 -> System.out.println("Rooster is your Zodiac sign");
            case 2 -> System.out.println("Dog is your Zodiac sign");
            case 3 -> System.out.println("Pig is your Zodiac sign");
            case 4 -> System.out.println("Rat is your Zodiac sign");
            case 5 -> System.out.println("Ox is your Zodiac sign");
            case 6 -> System.out.println("Tiger is your Zodiac sign");
            case 7 -> System.out.println("Rabbit is your Zodiac sign");
            case 8 -> System.out.println("Dragon is your Zodiac sign");
            case 9 -> System.out.println("Snake is your Zodiac sign");
            case 10 -> System.out.println("Horse is your Zodiac sign");
            case 11 -> System.out.println("Sheep is your Zodiac sign");
            default -> System.out.println("Error");
        }
    }
    
}
