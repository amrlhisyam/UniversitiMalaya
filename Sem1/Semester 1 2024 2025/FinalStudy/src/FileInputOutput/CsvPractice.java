/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;


public class CsvPractice {
    public static void main(String[] args) throws IOException {
        
        String file = "C:\\Users\\Hisyam\\Downloads\\practice.csv";
        BufferedReader reader = null; 
        String line = "";
        
        try{
        reader = new BufferedReader(new FileReader(file));
        while ((line = reader.readLine()) != null){
            String[] row = line.split(",");
            
            for(int i=0;i<row.length;i++){
                System.out.printf("%-10s",row[i]);
            }
            System.out.println("");
        }
    }
        catch(FileNotFoundException e){
        e.printStackTrace();
        }
        catch(IOException ioe){
            
        }
        
        finally {
            reader.close();
        }
    }
}
