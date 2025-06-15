/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Random;
public class F4a {
    public static void main(String[] args) {
        int [][] arr = initializeSeatingPlan();
        analyzeSeat(arr);
        printArray(arr);
    }
    
    public static int[][] initializeSeatingPlan(){
        Random r = new Random();
        int a = r.nextInt(4,8);
        int b = r.nextInt(4,8);
        int [][] classSeating = new int [a][b] ; 
        
        for(int i=0;i<classSeating.length;i++){
            for(int j=0;j<classSeating[i].length ; j++){
                classSeating[i][j] = r.nextInt(0,2);
            }
        }
        
        return classSeating;
    }
    
    public static void printArray(int[][]arr){
        System.out.println("Seating plan: ");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void analyzeSeat(int [][] arr){
        int occ = 0 ;
        int highest = 0; 
        int sum = 0 ; 
        int highestRow = 0; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == 1){
                    occ++ ;  // if the current index of array holds the value one , the occ is incremented, indicating that the seat is occupied
                }
            }
                sum += occ ; // the occ total for first row is addded to totalvalue sum to get the total occupied seat
                if (occ >highest){ // if the current occuppied seat for current row is higher than variable highest, update highest and set highestRow
                        highest = occ; 
                        highestRow = i + 1 ; 
                    }
                occ = 0 ; 
            }
        
        System.out.println("Total number of occupied seat is: " + sum);
        System.out.println("Row with highest occupied seat is: " + highestRow);
    }
}
 