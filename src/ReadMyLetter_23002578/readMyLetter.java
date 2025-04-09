
package ReadMyLetter_23002578;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

public class readMyLetter {
    public static void main(String[] args) {
        read("AmirulHisyam_23002578.txt");
        //append("AmirulHisyam_23002578.txt");
    }
    
    public static void read(String textFileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(textFileName));
            String line = "";
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error");
        }
        
    }
    
    public static void append(String textFileName){
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(textFileName,true));
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 'stop' to finish.");
            while(true){
                String str2 = sc.nextLine();
                if(str2.equalsIgnoreCase("stop")){
                    break;
                }
                else {
                    writer.println(str2);
                }
            }
            writer.close();
            
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
