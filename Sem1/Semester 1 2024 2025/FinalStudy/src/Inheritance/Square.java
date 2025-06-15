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
public class Square extends Shape{
    double side;
    
    public Square(String name,double side){
        super(name);
        this.side = side;
    }
    

    
    public void computePerimeter(){
        perimeter = (side)*4;
    }
    
    public void computeArea(){
        area = side*side;
    }
}
