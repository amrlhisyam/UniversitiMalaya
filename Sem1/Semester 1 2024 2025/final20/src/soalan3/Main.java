package soalan3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "raw.txt";
        int numbers[] = new int[100];
        int numCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    if (numCount < numbers.length) {
                        numbers[numCount++] = Integer.parseInt(part);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        } catch (IOException e) {
            System.out.println("Error with file input.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }

        int table[][] = new int[numCount][2];
        int uniqueCount = 0;

        for (int i = 0; i < numCount; i++) {
            int index = -1;
            for (int j = 0; j < uniqueCount; j++) {
                if (table[j][0] == numbers[i]) {
                    index = j; 
                    break;
                }
            }
            if (index == -1) {
                table[uniqueCount][0] = numbers[i]; 
                table[uniqueCount][1] = 1;
                uniqueCount++; 
            } else {
                table[index][1]++;
            }
        }

        int highest = 0;
        int highestRow = 0;
        for (int i = 0; i < uniqueCount; i++) {
            if (table[i][1] > highest) {
                highest = table[i][1];
                highestRow = table[i][0];
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(table[i][0] + ": " + table[i][1]);
        }
        System.out.println("Mode of the number is: " + highestRow);
    }
}