/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReadTextFile_23002578;

/**
 *
 * @author Hisyam
 */

// also do number of character for each word

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String textFileName = "text1.txt";
        String specialCharacter = ","; // to set number as special character use "\\d+" 
        try{
            BufferedReader reader = new BufferedReader(new FileReader(textFileName));
            String line = "";
            int counter = 0;
            while((line=reader.readLine())!=null){
                String noDelimiter = line.replaceAll(specialCharacter, "");
                counter += noDelimiter.length() ;
                System.out.println(noDelimiter);
            }
            System.out.println("Number of Characters without delimiters = " + counter);

        } catch(FileNotFoundException e){
            
        } catch (IOException e){
        
        }
    }
}
