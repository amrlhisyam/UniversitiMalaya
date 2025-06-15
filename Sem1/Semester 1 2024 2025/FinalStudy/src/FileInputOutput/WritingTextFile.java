
package FileInputOutput;

import java.io.*;
public class WritingTextFile {
    public static void main(String[] args) {
        String [][] currency = { {"USD","0.245"}, {"EUR","0.205"},{"GBP","0.184"},{"AUD","0.332"},{"THB","7.41"}};
        try{
        PrintWriter outputStream = new PrintWriter (new FileOutputStream("C:\\Users\\Hisyam\\Downloads\\currency.txt"));
        for(int i=0; i<currency.length; i++){
            for (int j=0 ; j<currency[i].length; j++){
                outputStream.print(currency[i][j] + "\t");
            }
            outputStream.println("");
        }
        outputStream.close() ;
        }
        catch(IOException e){
            System.out.println("Problem with file input");
        }
    }
}
