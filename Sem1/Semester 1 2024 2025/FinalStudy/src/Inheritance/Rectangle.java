/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

import java.util.Scanner;
public class Rectangle extends Shape{
    double side1;
    double side2;
    
    public Rectangle(String name, double side1, double side2){
        super(name);
        this.side1 = side1;
        this.side2 = side2;
    }
    
    
    public void computePerimeter(){
        perimeter = (side1+side2)*2;
    }
    
    public void computeArea(){
        area = side1*side2;
    }
    
}
