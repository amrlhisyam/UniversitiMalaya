/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formatting;

/**
 *
 * @author Hisyam
 */
public class FormatExample {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 30;
        double height = 5.7;

        // Basic usage
        System.out.printf("Name: %s, Age: %d, Height: %.2f\n", name, age, height);

        // Using flags and width
        System.out.printf("Name: %-10s | Age: %03d | Height: %6.2f\n", name, age, height);

        // Hexadecimal and octal
        int number = 255;
        System.out.printf("Decimal: %d, Hex: %x, Octal: %o\n", number, number, number);
    }
}
