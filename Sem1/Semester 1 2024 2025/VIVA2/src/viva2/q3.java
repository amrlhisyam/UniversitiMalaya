/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva2;

import java.util.* ;

public class q3 {
    public static void generateMatrix(int row, int col){
        Random r = new Random();
        final int max = 101 ; 
        int [][]matrix = new int[row][col] ; 
        
        for (int i=0; i<row ; i++){
            for(int j=0 ; j<col ; j++){
                matrix[i][j] = r.nextInt(1,max);
            }
        }
        
        
        System.out.println("Original Matrix: ");
        for(int i=0 ; i<row ; i++){
            for(int j=0 ; j<col ; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
       filterPrime(matrix);
    }
    
    public static boolean isPrime(int num){
        int counter = 0 ; 
        
        for (int i=1 ; i<=num ; i++){
            if(num%i==0){
                counter++ ; 
            }

        }
        
        return counter == 2 ; 
    }
    
    public static void filterPrime(int[][]arr){
        List<Integer> filter = new ArrayList<>() ; 
        int counter= 0 ; 
        for (int i=0 ; i<arr.length ; i++){
            for (int j=0 ; j<arr[0].length ; j++){
                if(isPrime(arr[i][j])== true){
                   filter.add(arr[i][j]);
                   counter++ ; 
                }
            }
        }
        
        System.out.println("");
        if(counter>0){
        System.out.print("Prime Filtered: ");
            System.out.println(filter);
        findMaxPrime(filter);
        }
        else{
            System.out.println("No prime number found");
        }
    }
    
    public static void findMaxPrime(List<Integer>num){
        int max = 0 ;
        
        for(int i=0 ;i <num.size() ; i++){
            if(num.get(i) > max){
                max = num.get(i) ; 
            }
        }
        
        System.out.println("Max number is : " + max);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int row = input.nextInt();
        
        System.out.print("Enter column: ");
        int col = input.nextInt() ; 
        
        System.out.println();
        generateMatrix(row,col);
        
    }
}
