/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Random;
public class L5Q4 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] array = new int[3][3];
        
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                array[i][j] = r.nextInt(1,10);
            }
        }
        
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
        int[][]newArray = new int[3][3];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                newArray[j][array.length-1-i] = array[i][j];
            }
        }
        System.out.println("");
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                System.out.print(newArray[i][j]+ "\t");
            }
            System.out.println("");
        }
    }
}
