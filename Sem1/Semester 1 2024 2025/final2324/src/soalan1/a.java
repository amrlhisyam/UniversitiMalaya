/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan1;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countPos = 0;
        int countNeg = 0;
        int countZero = 0;
        String input;
        boolean quit = false;
        
        while(!quit){
            System.out.print("Enter a number (X to QUIT): ");
            input = sc.nextLine();
            
            if(input.equalsIgnoreCase("X")){
                quit = true;
            }
            else if(Integer.parseInt(input)<0){
                countNeg++;
            }
            else if(Integer.parseInt(input) == 0){
                countZero++;
            }
            else if(Integer.parseInt(input)>0){
                countPos++;
            }
        }
        
        // output
        System.out.print("Positive Count: " + countPos + "\n");
        System.out.print("Negative Count: " + countNeg+ "\n");
        System.out.print("Zero Count: " + countZero + "\n");
    }
}
