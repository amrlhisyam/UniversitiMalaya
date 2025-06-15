package string;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;
public class ReadingCharacterFromConsole {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character:");
        String s = input.nextLine();
        char ch = s.charAt(0);
        System.out.println("The character enters is " + ch);
    
    }
}
