/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Random;
import java.util.Scanner;
public class L5Q5 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] array = new int[20];
        
        for(int i=0;i<array.length;i++){
            array[i] = r.nextInt(0,100+1);
        }
        
        System.out.println("A list of 20 random integer within 0 to 100");
        for(int i=0; i<array.length; i++){
            System.out.printf("%-5d",array[i]);
        }
        System.out.println();
        
        for(int pass=1; pass<array.length ; pass++){
            for (int i=0; i<array.length-1; i++){
                if(array[i] < array[i+1]){
                    int hold = array[i];
                    array[i] = array[i+1];
                    array[i+1] = hold;
                }
            }
        }
        System.out.println("Array in descending order");
        for(int i=0; i<array.length; i++){
            System.out.printf("%-5d",array[i]);
        }
        System.out.println();
        
        System.out.print("Enter a number to search: ");
        int search = sc.nextInt();
        
        int loops=0;
        boolean found = false;
        for(int i=0; i<array.length; i++){
            loops++;
            if(array[i] == search){
                found = true;
                System.out.println(search +" found");
                System.out.println("Linear Search - "+ loops + " loop(s)");
                break;
            }
        }
        if (found == false){
            System.out.println(search +" not found");
        }
        
        for(int pass=1; pass<array.length ; pass++){
            for (int i=0; i<array.length-1; i++){
                if(array[i] > array[i+1]){
                    int hold = array[i];
                    array[i] = array[i+1];
                    array[i+1] = hold;
                }
            }
        }
        int middle, low, high;
        low = 0;
        high = array.length-1;
        int loops2 = 0;
        boolean found2 = false;
        while(low <= high){
            loops2++;
            middle = (low+high)/2;
            if(search == array[middle]){
                found2 = true;
                System.out.println(search +" found");
                System.out.println("Binary Search - "+ loops2 + " loop(s)");
                break;
            }
            else if(search < array[middle])
                high = middle-1;
            else
                low = middle + 1;
        }
        if (found2 == false){
            System.out.println(search +" not found");
        }
    }
}
