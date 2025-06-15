/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

    // polymorphism = The ability of an object to identify as more than one type

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Boat boat = new Boat();
        
        Vehicle[] racers = {car,bicycle,boat};
        
        for(Vehicle x: racers){
            x.go();
        }
    }
  
}

class Vehicle{
    
    public void go(){
        
    }
}

class Car extends Vehicle{

    @Override
    public void go(){
        System.out.println("The car begins moving");
    }
}

class Bicycle extends Vehicle{

        @Override
        public void go(){
        System.out.println("The bicycle begins moving");
    }
}

class Boat extends Vehicle{
    
        @Override
        public void go(){
        System.out.println("The boat begins moving");
    }
}