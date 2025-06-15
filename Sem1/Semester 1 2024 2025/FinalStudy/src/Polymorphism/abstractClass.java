/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */
public class abstractClass {
    public static void main(String[] args) {
        
        // Vehicle vehicle = new Vehicle();
        Cars car = new Cars();
        
        car.go();
    }
}

abstract class Vehicle{

    abstract void go();
}

class Cars extends Vehicle{

    @Override
    void go() {
        System.out.println("The driver is driving the car");
    }

}
