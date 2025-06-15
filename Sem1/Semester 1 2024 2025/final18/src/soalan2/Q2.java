/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan2;

import java.util.Scanner;
import java.util.Random;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int N;
        int AAA=0;
        int AA =0;
        int A =0;
        System.out.print("Enter N number: ");
        N = sc.nextInt();
        String [] numbers = new String [N];
        for(int i=0; i<N; i++){
            numbers[i] = String.valueOf(r.nextInt(50,151));
        }
        for(int i=0; i<N; i++){
            if(numbers[i].charAt(numbers[i].length()-1) >= '0' &&numbers[i].charAt(numbers[i].length()-1) <= '3' ){
               AAA++; 
            }
            else if(numbers[i].charAt(numbers[i].length()-1) >= '4' &&numbers[i].charAt(numbers[i].length()-1) <= '6' ){
               AA++; 
            }
            else{
                A++;
            }
        }
        System.out.print("The random numbers are: ");
        for(String num: numbers){
            System.out.print(num + " ");
        }
        System.out.println("");
        System.out.println("Group AAA: " + AAA);
        System.out.println("Group AA: " + AA);
        System.out.println("Group A: " + A);
    }
}
