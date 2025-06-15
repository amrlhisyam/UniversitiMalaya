/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Testing Rectangle
        Rectangle rectangle = new Rectangle("rectangle",7.0,5.0);
        rectangle.computePerimeter();
        rectangle.computeArea();
        rectangle.display();

        // Testing Square
        Square square = new Square("square",4.5);
        square.computePerimeter();
        square.computeArea();
        square.display();

        // Testing Circle
        Circle circle = new Circle("circle",12.99);
        circle.computePerimeter();
        circle.computeArea();
        circle.display();

        sc.close();
    }
}

