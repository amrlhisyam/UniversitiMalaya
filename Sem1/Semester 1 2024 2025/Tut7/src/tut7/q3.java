/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tut7;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class q3 {

    public static void main(String[] args) {
        try(PrintWriter outputStream = new PrintWriter(new FileOutputStream("data.txt"))){
            int intValue;
            String sentence = "Hi My Name Is Hisyam";
            for(int i=0; i<sentence.length(); i++){
                intValue = sentence.charAt(i);
                String binaryString = String.format("%8s", Integer.toBinaryString(intValue)).replace(' ', '0');
                outputStream.print(binaryString+"\n");
            }
            outputStream.close();
        }catch(IOException e){
            System.out.println("Problem With File Output");
        }
        
        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String input;
            StringBuilder str = new StringBuilder();
            while((input=reader.readLine())!=null){
                int cha = Integer.parseInt(input, 2);
                str.append(Character.toChars(cha));
            }
            System.out.println(str);
        }catch(FileNotFoundException fe){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Problem With File Input");
        }
    }
    
}
