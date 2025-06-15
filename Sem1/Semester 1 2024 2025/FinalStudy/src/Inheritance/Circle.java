/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

import java.util.Scanner;

/**
 *
 * @author Hisyam
 */
public class Circle extends Shape {
    double diameter;
    
    public Circle(String name, double diameter){
        super(name);
        this.diameter = diameter;
    }
    
    public void computePerimeter(){
        perimeter = (diameter/2)*2*Math.PI;
    }
    
    public void computeArea(){
        double r = (diameter/2);
        area = Math.PI*r*r;
    }
}
