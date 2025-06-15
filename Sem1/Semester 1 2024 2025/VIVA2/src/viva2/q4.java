package viva2;

import java.util.*;
public class q4 {
    public static void format(int num, int length){
        String number = String.valueOf(num);
        int zeros = length - number.length();
        StringBuilder answer = new StringBuilder() ; 
        for (int i= 0 ; i < zeros ; i++){
            answer.append('0');
        }
        answer.append(num);
        System.out.println(answer);
       
        
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num,width;
        
        boolean done = false;
        while(!done){
        try{
            System.out.print("Enter number: ");
            num = input.nextInt();
            System.out.print("Enter width: ");
            width = input.nextInt() ; 
            format(num,width);
            done = true;
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            System.out.println("Invalid input\nPlease Enter A Number");
            input.next();
        }
        }
        
        
    }
}
