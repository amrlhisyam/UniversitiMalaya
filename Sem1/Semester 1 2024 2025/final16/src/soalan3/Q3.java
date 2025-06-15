/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan3;

import java.util.Scanner;
import java.util.Random;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int [] num;
        
        System.out.print("Enter n: ");
        n = sc.nextInt();
        
         num = assignRandom(n);
         int [] rev = num.clone();
         display(num);
         System.out.println("Max: " + maximum(num));
         System.out.println("Rounded to nearest tenth: ");
         round(rev);
         System.out.println("Reverse: ");
         reverse(rev);
    }
    
    public static int[] assignRandom(int n){
        Random r = new Random();
        int [] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = r.nextInt(0,1001);
        }
        return arr;
    }
    
    public static void display(int[]arr){
        for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println("");
    }
    
    public static int maximum(int []arr){
        int max = -1;
        for (int pass = 1; pass <= arr.length-1; pass++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int hold = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = hold;
                }
            }
        }
        return arr[arr.length-1]; 
    }
    
    public static void round(int[] arr){
        String[] str = new String[arr.length];
        int [] num = new int [str.length];
        for(int i=0;i<str.length;i++){
            str[i] = String.valueOf(arr[i]);
        }
        
        for(int i=0;i<str.length;i++){
            int c = Character.getNumericValue(str[i].charAt(str[i].length()-1));
            if(c >= 0 && c <5){
                if(str[i].length()<2){
                    num[i] = 10;
                }
                else
                num[i] = Integer.parseInt(str[i])-c;
            }
            else if( c>=5 && c <= 9){
                num[i] = Integer.parseInt(str[i])-c+10;
            }
        }
        
        for(int x: num){
            System.out.print(x + " ");
        }
        System.out.println("");
    }
    
    public static void reverse(int [] arr){
        String [] str = new String[arr.length];
        
        for(int i=0;i<arr.length;i++){
            str[i] = String.valueOf(arr[i]);
        }
        
        for(int i=0;i<str.length;i++){
        StringBuilder sb = new StringBuilder(str[i]);
            str[i] = sb.reverse().toString();
        }
        
        for(String x : str){
            System.out.print(x + " ");
        }
        System.out.println("");
    }
}
