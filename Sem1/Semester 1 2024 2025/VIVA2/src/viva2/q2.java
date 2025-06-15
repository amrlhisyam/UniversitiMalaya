package viva2;

import java.util.Scanner;

public class q2{
    
    private static int[]num = new int[100];
    private static int count = 0;
    private static int l = 0 ; 
    private static int tr=0;
    
    public static void parseArray(String input){
        String[] str = input.split(",|\\s+");
        int[] res = new int[str.length];
        
        for(int i=0 ; i<str.length; i++){
            if(!str[i].isEmpty()){
                res[i]=Integer.parseInt(str[i]);
                count++ ;
            }
            else
                System.out.println("Error");
        }
        l++ ; 
        if(l>=2){
            mergeArray(res);
        }
    }
    
    public static void mergeArray(int[] arr){
            for(int i=0 ; i<count ; i++){
                num[tr] = arr[i] ; 
                tr++;
            }
        printArray(num);
    }
    
    public static void printArray(int[]arr){
        for(int n:arr){
            System.out.print(n+ " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Array1: ");
        String input1 = input.nextLine();
        
        System.out.print("Array2: ");
        String input2 = input.nextLine();
        
        parseArray(input1);
        parseArray(input2);
    }




}