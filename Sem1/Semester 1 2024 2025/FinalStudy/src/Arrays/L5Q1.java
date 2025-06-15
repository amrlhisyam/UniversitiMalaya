/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Random;
import java.util.Scanner;
public class L5Q1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        double highest=0, lowest=100;
        double sum=0;
        
        System.out.print("Enter N Students: ");
        int numStudents = sc.nextInt();
        
        int[] score = new int[numStudents];
        
        for(int i=0;i<score.length;i++){
            score[i] = r.nextInt(0,101);
        }
        
        for(int i=0;i<score.length;i++){
            if(score[i]>highest){
                highest = score[i];
            }
            if(score[i]<lowest){
                lowest = score[i];
            }
            
            sum += score[i];
        }
        
        double average;
        average = (double) sum/(int) numStudents;
        
        for(int i=0;i<score.length;i++){
            System.out.println(score[i]);
        }
        
        System.out.println();
        
        System.out.printf("Highest Score: %5.2f\n",highest);
        System.out.printf("Lowest Score: %5.2f\n",lowest);
        System.out.printf("Average Score: %5.2f\n",average);
    }
}
