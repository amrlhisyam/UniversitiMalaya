package soalan4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[][] Record = new String[100][];

        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sampleLog.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] value = line.split("\\s+");
                Record[index] = new String[value.length]; 
                System.arraycopy(value, 0, Record[index], 0, value.length);
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        } catch (IOException e) {
            System.out.println("Error with file input.");
        }

        int[] jobSubmitted = new int[index];

        for (int i = 0; i < index; i++) {
            if (Record[i].length == 15) {
                if (Record[i][14] != null)
                jobSubmitted[i] = Integer.parseInt(Record[i][14]);
            }
        }
        System.out.println("");

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < Record[i].length; j++) {
                System.out.println(Record[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Number of Records: " + index);
        System.out.println("");
        for (int i = 0; i < index; i++){
                System.out.println(Record[i][3] + ": " + jobSubmitted[i]);
        }
    }
}