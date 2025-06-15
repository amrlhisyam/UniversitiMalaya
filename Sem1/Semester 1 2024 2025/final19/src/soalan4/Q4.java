package soalan4;

import java.io.*;

public class Q4 {
    public static void main(String[] args) {
        String fileName = "myAmbition.txt";
        char[][] letters = new char[26][2]; // To store letters and their counts
        int sentence = 0;
        int word = 1;
        // Initialize the letters array with letters A-Z
        for (char c = 'A'; c <= 'Z'; c++) {
            letters[c - 'A'][0] = c; // Store the letter
            letters[c - 'A'][1] = 0; // Initialize count to 0
        }

        StringBuilder essayBuilder = new StringBuilder(); // Use StringBuilder for the essay

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                essayBuilder.append(line).append("\n"); // Append each line to the StringBuilder
                line = line.toUpperCase().trim(); // Convert line to uppercase
                for (char c : line.toCharArray()) {
                    if (c >= 'A' && c <= 'Z') { // Check if the character is a letter
                        letters[c - 'A'][1]++; // Increment the count for the letter
                    }
                    if( c == '.'){
                        sentence++;
                    }
                    if(c == ' '){
                        word++;
                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            return; // Exit if the file is not found
        } catch (IOException e) {
            System.out.println("Error with file input.");
            return; // Exit if there is an I/O error
        }
        // Print the essay
        System.out.println("The essay is: ");
        System.out.println(essayBuilder.toString()); // Convert StringBuilder to String for output
        
        System.out.print("Number of sentences: " + sentence);
        System.out.println("");
        System.out.print("Number of words: " + word);
        System.out.println("");
        
        // Print the results
        System.out.println("Letter counts:");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i][1] > 0) { // Only print letters that were found
                System.out.println(letters[i][0] + ": " + (int) letters[i][1]);
            }
        }
    }
}