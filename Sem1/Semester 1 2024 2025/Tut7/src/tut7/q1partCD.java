/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tut7;

import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class q1partCD {

    public static void main(String[] args) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("integer.dat"))){
            final int MAX=1000, SIZE=10;
            Random r = new Random();
            for(int i=0; i<SIZE; i++){
                int num = r.nextInt(MAX);
                outputStream.writeInt(num);
            }
            outputStream.close();
            System.out.println("File Output Stream Successfull");
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
        
        List<Integer> numbers = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("integer.dat"))){
            try{
                while(true){
                    int num = inputStream.readInt();
                    numbers.add(num);
                }
            }catch(EOFException eof){
                System.out.println("End Of File");
            }
        }catch(FileNotFoundException fe){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Problem with file input");
        }
        if(!numbers.isEmpty()){
            int average=0;
            for(int i=0; i<numbers.size(); i++){
                average += numbers.get(i);
                System.out.println(numbers.get(i));
            }
            average /= numbers.size();
            System.out.println("Average of numbers is: "+average);
        }
        
    }
    
}
