/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tut7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class lab3 {

    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"))){
            writer.write("Hi My Name Is Hisyam");
            writer.write("\nHi Im 19 Years Old");
        }catch(IOException e){
            System.out.println("Problem With File Output");   
        }
        
        try(BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
            String input;
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("reverse.txt"))){
            while((input=reader.readLine())!= null){
                String reverse = new StringBuilder(input).reverse().toString();
                writer.write(reverse);
                writer.write("\n");
            }
            }catch(IOException e){
                System.out.println("Problem With FIle Output");
            }
        }catch(FileNotFoundException fe){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Problem with File Read");
        }
    }
}
