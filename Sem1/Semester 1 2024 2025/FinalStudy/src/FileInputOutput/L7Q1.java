/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
import java.util.Scanner;

public class L7Q1 {
    public static void main(String[] args) {
        String FileName = "data.dat";
        String[][] course =
        {{"WXES1116","Programming 1"},
        {"WXES1115","Data Structure"},
        {"WXES1110","Operating System"},
        {"WXES1112", "Computing Mathematics 1"}};

        try{
            ObjectOutputStream streamObject = 
                    new ObjectOutputStream (new FileOutputStream(FileName));
            
            for(int i=0;i<course.length;i++){
                for(int j=0;j<course[i].length;j++){
                    streamObject.writeUTF(course[i][j]);
                }
            }
            streamObject.close();
        }
        catch(IOException e){
            System.out.println("Error with File Output");
        }
        System.out.print("Enter course code: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
                try{
            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream(FileName));
            while (true) {                
                try {
                    
                    String courseCode = inputStream.readUTF();
                    String courseName = inputStream.readUTF();
                    if (input.equalsIgnoreCase(courseCode)) {
                        System.out.println(courseCode + ": " + courseName);
                    }
                    
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
