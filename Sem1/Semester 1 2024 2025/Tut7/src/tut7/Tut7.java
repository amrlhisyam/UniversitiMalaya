/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tut7;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tut7 {

    
    public static void main(String[] args) {    
        try{
            final int MAX=1000, SIZE = 10;
        Random r = new Random();
        BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("integer.txt"));
        for (int i=0; i<SIZE; i++){
            int number = r.nextInt(MAX);
            writer.write(String.valueOf(number));
            writer.write("\n");
        }
        writer.close();
            System.out.println("File Written Successfully");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        List<Integer> number = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader("integer.txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
                try{
                    int num = Integer.parseInt(line.trim());
                    number.add(num);
                }
                catch(NumberFormatException nfe){
                    nfe.printStackTrace();
                    System.out.println("Invalid number format"+line);
                }
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        if(!number.isEmpty()){
            int min = number.get(0);
            int max = number.get(0);
            
            for(int i=0; i<number.size(); i++){
                if(number.get(i) > max)
                    max = number.get(i);
                else
                    min = number.get(i);
            }
            System.out.println("Maximum number is: "+max);
            System.out.println("Minimum number is: "+min);
        }
        else
            System.out.println("File is Empty");
    }
    
}
