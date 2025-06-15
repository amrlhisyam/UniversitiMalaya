package tut7;

import java.util.Scanner; 
import java.net.URL; 
import java.io.InputStream; 
import java.net.URLConnection; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class lab2 {

    public static void main(String[] args) {
        try { 
            URL u = new URL("https://fsktm.um.edu.my/"); 
            URLConnection cnn = u.openConnection(); 
            InputStream stream = cnn.getInputStream(); 
            Scanner in = new Scanner(stream); 
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("index.htm"));
                while(in.hasNextLine()){
                String input = in.nextLine();
                writer.write(input);
                writer.write("\n");
                }
            }catch(FileNotFoundException fe){
                System.out.println("File Not Found");
            }catch(IOException e){
                System.out.println("Problem With File Output");
            }
            }catch (IOException e) { 
            System.out.println("IO Error:" + e.getMessage()); 
            } 
        }
}