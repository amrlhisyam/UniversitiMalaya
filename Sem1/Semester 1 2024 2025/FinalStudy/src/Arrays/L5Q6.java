/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Scanner;
public class L5Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int row = sc.nextInt();
        int[][] array = new int[row][row];
        
        for(int i=0; i<array.length ;i++){
            for(int j=0; j<array[i].length; j++){
                if(j == 0){
                    array[i][j] = 1;
                }
                else if (j == i){
                    array[i][j] = 1;
                }
                else if ((i>0) && (j>0)){
                    int temp = array[i-1][j] + array[i-1][j-1];
                    array[i][j] = temp;
                }
            }
        }
        
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.printf("%-3d\t",array[i][j]);
            }
            System.out.println();
        }
    }
}
