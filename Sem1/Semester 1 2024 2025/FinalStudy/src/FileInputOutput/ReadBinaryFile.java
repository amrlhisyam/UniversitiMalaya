/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
public class ReadBinaryFile {
    public static void main(String[] args) {
        String FileName = "data.dat";
        try{
            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream(FileName));
            while (true) {                
                try {
                    
                    String courseCode = inputStream.readUTF();
                    String courseName = inputStream.readUTF();
                    System.out.println(courseCode + ": " + courseName);
                    
                } catch (EOFException e) {
                    break;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Erro File Not Found");
        }
        catch(IOException e){
            System.out.println("Error with File Input");
        }
    }
}
