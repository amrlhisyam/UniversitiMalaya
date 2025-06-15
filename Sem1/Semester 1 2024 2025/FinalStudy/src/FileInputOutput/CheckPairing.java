/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
import java.util.Random;
public class CheckPairing {
    public static void main(String[] args) {
        String fileName = "participants.txt";
        String [] nameArray = new String[4];
        char [] genderArray = new char [4];
        int [] ageArray = new int [4];
        String [] addressArray = new String[4];
        int index = 0 ;
        try{
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String line="";
            while((line = reader.readLine())!=null){
                String part[] = line.split(",");
                if(part.length==4){
                    nameArray[index] = part[0];
                    genderArray[index] = part[1].trim().charAt(0);
                    ageArray[index] = Integer.parseInt(part[2]);
                    addressArray[index] = part[3];
                }
                index++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error reading file");
        }
        
        String[][] participants = new String[4][4];
        for(int i=0;i<participants.length;i++){
            participants[i][0] = nameArray[i];
            participants[i][1] = String.valueOf(genderArray[i]);
            participants[i][2] = String.valueOf(ageArray[i]);
            participants[i][3] = addressArray[i];
        }
        
        for(int i=0;i<participants.length;i++){
            for(int j=0;j<participants[i].length;j++){
                System.out.printf("%-15s",participants[i][j]);
            }
            System.out.println("");
        }
        
        
        int pairCount=0;
          for (int i = 0; i < addressArray.length; i++) {
            for (int j=i+1; j<addressArray.length;j++) {
                if (addressArray[i].replaceAll("\\s+", "").equalsIgnoreCase(addressArray[j].replaceAll("\\s+", ""))) {
                    pairCount++;
                    break ;
                }
            }
        }
          System.out.println(pairCount);
        
        if(pairCount == 2){
            System.out.println("can participate");
        }
        else
            System.out.println("cannot participate");
        
        Random r = new Random();
        

            
    }
}
