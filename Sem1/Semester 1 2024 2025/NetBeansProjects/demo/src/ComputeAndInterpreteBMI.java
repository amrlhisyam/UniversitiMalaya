/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
import java.util.Scanner;

public class ComputeAndInterpreteBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your weight in pounds: ");
        double weightPounds = input.nextDouble();
        
        System.out.print("Enter your height in inches: ");
        double heightInches = input.nextDouble();
        
        // unit conversion
        double weightKilograms = weightPounds * 0.45359237;
        double heightMeters = heightInches * 0.0254;
        
        double BMI = weightKilograms / (Math.pow(heightMeters , 2));
        System.out.println("BMI is " + BMI);
        
        if (BMI < 18.5)
            System.out.println("Underweight");
        else if (BMI >= 18.5 && BMI < 25.0)
            System.out.println("Normal");
        else if (BMI >= 25.0 && BMI < 30.0)
            System.out.println("Overweight");
        else 
            System.out.println("Obese");
        
        input.close();
    }
}
