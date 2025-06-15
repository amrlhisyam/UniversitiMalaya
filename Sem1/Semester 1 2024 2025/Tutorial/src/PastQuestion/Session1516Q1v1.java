/* Write a Java program to track the coordinate of an object after a sequence of 
moves. Figure below shows the system coordinate used. The program will prompt 
the user to enter the X and Y coordinates as well as the moves. The move is 
represented by L (Left), R (Right), U (Up) and D (Down).*/

package PastQuestion;

import java.util.Scanner ; 

public class Session1516Q1v1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.print("Enter coordinate x and y: ") ;
        String coordinate;
        coordinate = input.nextLine();
        int k = coordinate.indexOf(' '); 
        String x = coordinate.substring (0,k);
        String y = coordinate.substring (k + 1);
        
        int xCor = Integer.parseInt(x);
        int yCor = Integer.parseInt(y);
        
        
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

