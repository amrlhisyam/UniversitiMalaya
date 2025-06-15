
package tutorial7;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Tutorial7 {

    
    public static void main(String[] args) {    
        Random r = new Random();
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("partA.txt"));
        for (int i=0; i<10; i++){
            int number = r.nextInt();
            writer.write(number);
            writer.write("\n");
        }
        writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
