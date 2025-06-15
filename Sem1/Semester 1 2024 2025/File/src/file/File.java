
package file;

import java.io.*;
public class File {


    public static void main(String[] args) {
        String filePath = "output.txt";
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("Hello World!");
            writer.newLine();
            writer.write("This is the second line");
            writer.newLine();
            writer.write("this is the third line");
            System.out.println("File wwritten successfully");
        }catch(IOException e){
            e.printStackTrace();
        }
    
    
}
}
