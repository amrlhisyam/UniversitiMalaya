/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial3;

import java.util.Random;

public class L3Q2 {
       public static void main(String[] args) {
           Random r = new Random();
           final int min = 0 , max = 6;
           int number = r.nextInt(min , max);
           
           switch (number){
               case 0 -> System.out.println(number + " is zero ");
               case 1 -> System.out.println(number + " is one ");
               case 2 -> System.out.println(number + " is two ");
               case 3 -> System.out.println(number + " is three ");
               case 4 -> System.out.println(number + " is four ");
               case 5 -> System.out.println(number + " is five ");
           }
    }
    
}
