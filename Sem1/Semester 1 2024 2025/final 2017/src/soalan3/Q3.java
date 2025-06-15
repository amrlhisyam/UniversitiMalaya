/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan3;

import java.io.*;
import java.util.Random;
public class Q3 {
    public static void main(String[] args) {
        
        Random r = new Random();
        char [] randomChar = new char[6];
        for (int i = 0; i < randomChar.length; i++) {
            int a = r.nextInt(0,2);
            if(a == 0){
                int b = r.nextInt(65,91);
                Character.toChars(b, randomChar, i);
            }
            else {
                int c = r.nextInt(97,123);
                Character.toChars(c, randomChar, i);
        }
        }
        
        try{
            PrintWriter writer = 
                    new PrintWriter ( new FileWriter("data.txt"));
                for(int i=0;i<6;i++){
                    writer.print(randomChar[i]);
                }
                writer.close();
        }
        catch (IOException e) {
            System.out.println("Error with file output");
        }
        
        
        String original = "";
        try{
            BufferedReader reader = 
                    new BufferedReader(new FileReader("data.txt"));
            original = reader.readLine();
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        catch (IOException e) {
            System.out.println("Error with file input");
        }
        
        System.out.print("The string generated is: ");
        for(char a : randomChar){
            System.out.print(a);
        }
        System.out.println("");
        
        System.out.print("String sorted in ascending order: ");
        sort(randomChar, '>');
        System.out.println("");
        System.out.print("String sorted in decsending order: ");
        sort(randomChar, '<');
        System.out.println("");
        System.out.print("Original string from file: ");
        System.out.print(original);
        System.out.println("");
    }
    
    public static void  sort(char[]arr, char a){
        switch (a) {
            case '>':
                for (int pass = 0; pass <= arr.length-1; pass++) {
                    for (int i = 0; i < arr.length - 1; i++) {
                        if (arr[i] > arr[i + 1]) {
                            char hold;
                            hold = arr[i];
                            arr[i] = arr[i + 1];                        
                            arr[i + 1] = hold;
                        }
                    }
                }   break;
            case '<':
                for (int pass = 0; pass <= arr.length-1; pass++) {
                    for (int i = 0; i < arr.length - 1; i++) {
                        if (arr[i] < arr[i + 1]) {
                            char hold;
                            hold = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = hold;
                        }                        
                    }
                }   break;
            default:
                System.out.println("Invalid sign");
                break;
        }
        
        for(char x : arr){
            System.out.print(x);
        }
    }
 
}
