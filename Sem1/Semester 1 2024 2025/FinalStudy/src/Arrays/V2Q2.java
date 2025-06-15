/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.Scanner;
public class V2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array 1 [seperate by ',': ");
        String array1 = sc.nextLine();
        int [] num1 = parseArray(array1);
        System.out.print("Array 2 [seperate by ',': ");
        String array2 = sc.nextLine();
        int [] num2 = parseArray(array2);
        int [] mergearray = mergeArray(num1, num2);
        printArray(num1);
        printArray(num2);
        printArray(mergearray);
        
    }
    
    public static int[] parseArray(String array){
        String str = array.replaceAll("\\s+", "");
        String[] arr = str.split(","); 
        int[] num = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            if(!arr[i].isEmpty()){
                num[i] = Integer.parseInt(arr[i]);
            }
        }
        
        return num;
    }
    
    public static int[] mergeArray(int[]num1, int[]num2){

        int length = num1.length + num2.length;
        int[] merge = new int[length];
        for(int i=0; i<num1.length;i++){
            merge[i] = num1[i];
        }
        for(int i=0;i<num2.length;i++){
            merge[num1.length + i] = num2[i];
        }
        
        int hold;
        int uniqueCount=0;
        for(int pass=1;pass<= merge.length;pass++){
            for (int i=0;i<merge.length-1;i++){
            if(merge[i]>merge[i+1]){
                hold = merge[i];
                merge[i] = merge[i+1];
                merge[i+1] = hold;
            }
        }
        }
        
        for(int i=0; i<merge.length;i++){
            if(i==0 || merge[i] != merge[i-1]){
                uniqueCount++;
            }
        }
        
        int[] finalmerge = new int[uniqueCount];
        int index = 0;
        for(int i=0;i<merge.length;i++){
            if(i == 0 ||merge[i]!= merge[i-1]){
                finalmerge[index] = merge[i] ; 
                index++;
            }
        }
        
        return finalmerge;
        
    }
    
    public static void printArray(int[]arr){
        for (int i=0;i<arr.length;i++){
            System.out.printf("%-3d\t",arr[i]);
    }
        System.out.println("");
    }
}
