/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;

public class WriteBinaryFile {
    public static void main(String[] args) {
        String FileName = "data.dat";
        String[][] course =
        {{"WXES 1116","Programming 1"},
        {"WXES 1115","Data Structure"},
        {"WXES 1110","Operating System"},
        {"WXES 1112", "Computing Mathematics 1"}};

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
    }
}
