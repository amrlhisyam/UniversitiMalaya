/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hisyam
 */
public class Lab10q2 {
    
}

interface MessageEncoder{
    
    String encode(String plainText);
    String decode(String cipherText);
}

class SubstitutionCipher implements MessageEncoder{
    
    String inputFileName;
    String outputFileName;
    int shift;

    public SubstitutionCipher(String inputFileName, String outputFileName, int shift) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.shift = shift;
    }

    @Override
    public String encode(String plainText) {
        StringBuilder cipherText = new StringBuilder();
        for(char ch: plainText.toCharArray()){
            if(Character.isLetter(ch)){
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char encodedChar = (char) ((ch-base + shift) % 26 + base);
                cipherText.append(encodedChar);
            }
            else
                cipherText.append(ch);
        }
        return cipherText.toString();
    }

    @Override
    public String decode(String cipherText) {
        StringBuilder plainText = new StringBuilder();
        for (char ch : cipherText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char decodedChar = (char) ((ch - base - shift + 26) % 26 + base);
                plainText.append(decodedChar);
            } else {
                plainText.append(ch); // Non-letter characters are not changed
            }
        }
        return plainText.toString();
    }

   public void processEncoding() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encodedLine = encode(line);
                writer.write(encodedLine);
                writer.newLine();
            }
        }
    }

    public void processDecoding() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decodedLine = decode(line);
                writer.write(decodedLine);
                writer.newLine();
            }
        }
    }
}
    class Tester {
    public static void main(String[] args) {
        String inputFileName = "output.txt"; // Input file containing plain text or cipher text
        String outputFileName = "output.txt"; // Output file for encoded or decoded text
        int shift = 3; // Example shift value

        SubstitutionCipher cipher = new SubstitutionCipher(inputFileName, outputFileName, shift);

        try {
            // Encoding process
            System.out.println("Encoding...");
            cipher.processEncoding();
            System.out.println("Encoding completed. Check output.txt for encoded text.");

            // Decoding process
            System.out.println("Decoding...");
            cipher.processDecoding();
            System.out.println("Decoding completed. Check output.txt for decoded text.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
