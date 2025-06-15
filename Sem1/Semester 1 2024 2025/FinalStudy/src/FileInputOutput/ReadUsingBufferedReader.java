/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
public class ReadUsingBufferedReader {
    public static void main(String[] args) {
        
        String line= "";
        try{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hisyam\\Downloads\\currency.txt"));
        while((line = reader.readLine() )!= null){
            System.out.println(line);
        }
        reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error reading from file");
        }
        
    }
}
