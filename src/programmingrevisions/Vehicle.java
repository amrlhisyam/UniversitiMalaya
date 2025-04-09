/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingrevisions;

/**
 *
 * @author Hisyam
 */
abstract class Vehicle {
    double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    abstract void accelerate();
    
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }
    
    public double getMaxSpeed(){
        return this.maxSpeed;
    }
    
    public void pedalToTheMetal(){
        while(currentSpeed <maxSpeed){
            accelerate();
        }
    }
}



