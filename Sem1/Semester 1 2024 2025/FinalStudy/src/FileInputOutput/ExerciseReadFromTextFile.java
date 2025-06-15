/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
import java.util.Scanner;

public class ExerciseReadFromTextFile {
    public static void main(String[] args) {
        
        String line = "";
        
        System.out.print("RM: ");
        Scanner sc = new Scanner(System.in);
        double rm = sc.nextDouble();
        sc.nextLine();
        System.out.println("");
        System.out.println("USD, EUR, GBP, AUD, THB");
        System.out.print("Enter Currency: ");
        String in = sc.nextLine();
        try{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hisyam\\Downloads\\currency.txt"));
        
        while((line = reader.readLine()) != null){
            String[] parts = line.split("\\s+");
            if (parts.length == 2){
                String type = parts[0];
                double Value = Double.parseDouble(parts[1]);
                
                if(type.equalsIgnoreCase(in)){
                    double answer = rm* Value ; 
                    System.out.printf("RM %.2f = %-3s %.2f",rm, type, answer);
                    System.out.println("");
                }
                
            }
           
        }
        
        }
        
        catch(FileNotFoundException e){
            System.out.println("Filw was not found");
        }
        
        catch(IOException e){
            System.out.println("Error reading file");
        }
        

    }
}


