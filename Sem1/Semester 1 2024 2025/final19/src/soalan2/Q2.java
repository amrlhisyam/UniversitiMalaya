package soalan2;

import java.util.Random;
import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int[][] matrixA = generateMatrix(n);
        display(matrixA);
        
        int[][] matrixB = generateMatrix(n);
        display(matrixB);

        System.out.println("Method to add two matrices: ");
        addMatrix(matrixA, matrixB);
        
        System.out.println("Method to multiply two matrices: ");
        multiplyMatrix(matrixA, matrixB);
    }
    
    public static int[][] generateMatrix(int n) {
        Random r = new Random();
        int[][] matrixA = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = r.nextInt(0, 10);
            }
        }
        return matrixA;
    }
    
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { // Corrected here
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void addMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] matrixSum = new int[matrixA.length][matrixA.length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) { // Corrected here
                matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                System.out.printf("%-3d", matrixSum[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length; 
        int[][] matrixProduct = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) { 
                    matrixProduct[i][j] += matrixA[i][k] * matrixB[k][j];
                }
                System.out.printf("%-3d", matrixProduct[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}