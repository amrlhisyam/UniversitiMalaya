/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PastQuestion;

import java.util.Scanner;

/**
 *
 * @author Hisyam
 */
public class Session1516Q1v2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ; 
        System.out.print("Enter the coordinate for X and Y: ");
        int xCor = input.nextInt();
        int yCor = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter the move: ");
        String move = input.nextLine();
        int moveL = move.length();
        int i ; 
        int finalX = xCor , finalY = yCor ; 
        
        for (i = 0; i < moveL ; i ++  ){
        char moveReal = move.charAt(i);
            
            switch (moveReal) {
                case 'R':
                    finalX += 1 ;
                    break;
                case 'L':
                    finalX -=  1 ;
                    break;
                case 'U':
                    finalY +=  1 ;
                    break;
                case 'D':
                    finalY -= 1 ;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
        System.out.println("Initial Coordinate: (" + xCor + "," + yCor + ")");
        System.out.println("Final Coordinate: (" + finalX + "," + finalY + ")");
        
    }
   
}
