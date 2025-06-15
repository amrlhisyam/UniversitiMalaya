/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
import java.util.Scanner;
public class ReadUsingScanner {
    public static void main(String[] args) {
        try{
        Scanner inputStream = new Scanner(new FileInputStream("C:\\Users\\Hisyam\\Downloads\\currency.txt"));
        while(inputStream.hasNextLine()){
            String input = inputStream.nextLine();
            System.out.println(input);
        }
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error reading from file.");
        }
        
    }
}
