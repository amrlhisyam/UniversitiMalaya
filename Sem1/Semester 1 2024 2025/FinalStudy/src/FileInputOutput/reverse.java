/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;
import java.util.*;
import java.io.*;
public class reverse {
    public static void main(String[] args) {
        String fileName = "original.txt";
        String text = "Hi, my name is Amirul Hisyam Bin Amir Ruddin";
        try{
            PrintWriter writer = 
                    new PrintWriter(new FileOutputStream(fileName));
            writer.write(text);
            writer.write("Hi, saya Ameera, gf Hisyam");
            writer.close();
        }
        catch(IOException e){
            System.out.println("Error with File Output");
        }
        
        String line = "";
        StringBuilder reverse = new StringBuilder();
        try{
            BufferedReader reader = 
                    new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine())!=null){
                reverse.append(line);
            }
            
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error with file input");
        }
        try{
            PrintWriter writer = 
                    new PrintWriter(new FileOutputStream("reverse.txt"));
            String reverseString = reverse.reverse().toString();
            writer.write(reverseString);
            writer.close();
        }
        catch(IOException e){
            System.out.println("Error with File Output");
        }
        
    }
}
