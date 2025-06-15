/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Hisyam
 */
// testing scanner 
// we can  have multiple scanner 
public class Mavenproject1 {
    public static void main(String[] args) {
    Random n = new Random();
    int min = 1 , max = 11, randomNum,guess;
    randomNum = n.nextInt(min,max);
    Scanner g = new Scanner(System.in);
    System.out.println("Enter your guess from 1 to 10");
    guess = g.nextInt();
    if (guess==randomNum){
        System.out.println("Right");
    }
    else {
        System.out.println("Wrong");
    }
        System.out.println("Guess = " + guess);
        System.out.println("Random Number = " + randomNum);
    
    }
}


