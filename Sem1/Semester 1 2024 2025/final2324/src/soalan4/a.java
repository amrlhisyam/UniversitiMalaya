/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan4;


import java.util.Random;
public class a {
    public static void main(String[] args) {
        int [][] seatingPlan;
        seatingPlan = initializeSeatingPlan(4,5);
        printSeating(seatingPlan);
        analyzeSeating(seatingPlan);
    }
    
    public static int[][] initializeSeatingPlan(int x, int y){
        int [][] seatingPlan = new int[x][y];
        Random r = new Random();
        
        for( int i=0;i<seatingPlan.length;i++){
            for(int j=0;j<seatingPlan[i].length;j++){
                seatingPlan[i][j] = r.nextInt(0,2);
            }
        }
        return seatingPlan;
    }
    
    public static void analyzeSeating(int[][]arr){
        int counter =0; 
        int highestRow = 0; 
        int row = 0;
        int maximumOccupied = 0; 
        for( int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == 1){
                    counter++ ; 
                    row++;
                }
            }
            if (row > highestRow){
                highestRow = row;
                maximumOccupied = i + 1 ;
            }
            row = 0;
        }
        System.out.println("Total number of occupied seats: " + counter);
        System.out.println("Row with maximum number of occupied seats: " + maximumOccupied);
    }
    
    public static void printSeating(int[][]arr){
        
     for (int i=0; i<arr.length; i++){
         for (int j=0;j<arr[i].length;j++){
             System.out.printf("%-3d",arr[i][j]);
         }
         System.out.println("");
     }
        
    }
}
