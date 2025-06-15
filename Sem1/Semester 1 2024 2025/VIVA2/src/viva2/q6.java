/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva2;

import java.util.*;
public class q6 {
    public static void main(String[] args) {
        parseArray();
        
    }
    public static void parseArray(){
        int n = 0 ; 
        boolean done = false; 
        Scanner input = new Scanner(System.in);

        while(!done){
        try{
            System.out.print("Enter dimensions of Matrix nxn: ");
            n = input.nextInt();
            if(n<=0){
                throw new IllegalArgumentException("Dimensions must be greater than 0")  ;
            }
            else
                done = true;
        }catch(InputMismatchException ime){
            System.out.println("Invalid input");
            input.next();
            }
        catch(IllegalArgumentException ile){
            System.out.println(ile.getMessage());
        }
        }
        
        done = false ; 
        int counter = 0 ;
        while(!done && counter<n){
            try{
                
                
            }catch(InputMismatchException ime){
                System.out.println("Invalid input");
                
            }
        }
    }
    
    
    
    
    
}
