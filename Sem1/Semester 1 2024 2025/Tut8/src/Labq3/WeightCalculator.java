/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labq3;

import java.util.Scanner;
public class WeightCalculator {
    private int age;
    private double height, weight;
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        String temp;
        System.out.print("Enter age: ");
        age = sc.nextInt();
        temp = sc.nextLine();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
        temp = sc.nextLine();
    }
    
    public double calculateRecWeight(int age, double height){
        return weight = (height-100+(age/10))*0.9;
    }
    
    public void display(){
        int a = age ;
        double h = height ; 
        double w = calculateRecWeight(a,h) ; 
        System.out.println("Age: "+a);
        System.out.println("Height: "+h);
        System.out.printf("Recommended Weight: %.2f",w);
        System.out.println();
    }
}
