/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labq4;

import java.util.Scanner;
public class Fraction {
    private int numerator;
    private int denominator;
    
    public void setNumerator(int n){
        numerator = n;
    }
    
    public int getNumerator(){
        return numerator;
    }
    
    public void setDenominator(int d){
        denominator = d;
    }
    
    public int getDenominator(){
        return denominator;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        String temp;
        System.out.print("Enter Numerator: ");
        numerator = sc.nextInt();
        temp = sc.nextLine();
        System.out.print("Enter Denominator: ");
        denominator = sc.nextInt();
        temp = sc.nextLine();
    }
    
    public void displayFraction(){
        int gcd = 0 ; 
        for (int i=1 ; i<=numerator && i<= denominator ; i++){
            if(numerator%i ==0 && denominator%i == 0){
                gcd = i ; 
            }
        }
        int simNumerator = numerator / gcd ; 
        int simDenominator = denominator / gcd ;
        System.out.println("Simple Fraction is: "+simNumerator +"/"+simDenominator);
    }
    
    public void output(){
    
    }
}
