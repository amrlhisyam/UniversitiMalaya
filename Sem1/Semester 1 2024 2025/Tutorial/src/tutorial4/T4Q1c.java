package tutorial4;

import java.util.Random;

public class T4Q1c {
    public static void main(String[] args) {
    Random r = new Random();
    final int min = 0 , max = 100 ;
    int ranNum ;
    int row , col ;
    
    
    for ( row = 0 ; row < 4 ; row ++ ){
        for ( col = 0 ; col < 5 ; col ++){
               ranNum= r.nextInt(min , max);
               System.out.print(ranNum + "\t") ;
        }
        System.out.println("\t");
    }
    }
}



