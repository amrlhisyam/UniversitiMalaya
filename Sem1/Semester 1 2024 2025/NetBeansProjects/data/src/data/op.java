package data;

import java.util.Random;

public class op {
    public static void random (int[]arr){
        Random r = new Random() ; 
        for (int i=0 ; i<arr.length ; i++){
            int genRan = r.nextInt(100) ;  
            arr[i] = genRan; 
        }
    }
    
    
    
    
    public static void print(int[]arr){
        for(int n:arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    
    
}
