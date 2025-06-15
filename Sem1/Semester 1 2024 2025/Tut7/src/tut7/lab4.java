package tut7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("lab4.txt"))){
            writer.write("Selamat Pulang dan Selamat Malam Semua");
            writer.write("\nMalam Ini Kita Punya");
            writer.write("\nSaya Hisyam");
        }catch(IOException e){
            System.out.println("Error In File Output");
        }
        
        try(BufferedReader reader = new BufferedReader(new FileReader("lab4.txt"))){
            String input;
            int lines=0;
            int character=0;
            int word=0;
            while((input=reader.readLine())!=null){
               lines++;
               character += input.length();
               String[]wordsArray = input.trim().split("\\s+");
               word += wordsArray.length;
            }
            System.out.println("Number of Lines in lab4.txt is: "+lines);
            System.out.println("Number of words in lab4.txt is: "+word);
            System.out.println("Number of character in lab4.txt is: "+character);
        }catch(FileNotFoundException fe){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Error Reading File");
        }
    }
    
}
