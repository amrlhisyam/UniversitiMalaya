 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */
public class Interfaces {
    public static void main(String[] args) {
//        Rabbit rabbit = new Rabbit();
//        rabbit.flee();
        
//        Hawk hawk = new Hawk();
//        hawk.hunt();
        
        Fish fish = new Fish();
        fish.hunt();
        fish.flee();
        
    }
}

class Rabbit implements Prey{

    @Override
    public void flee() {
        System.out.println("'The rabbit is fleeing'");
    }
    
    
    
}

class Hawk implements Predator{

    @Override
    public void hunt() {
        System.out.println("'The hawk is hunting'");
    }

}

class Fish implements Prey,Predator{

    @Override
    public void flee() {
        System.out.println("'This fish is fleeing from a lerger fish'");
    }

    @Override
    public void hunt() {
        System.out.println("'This fish is hunting smaller fish'");
    }
    
}

interface Prey{
    void flee();
}

interface Predator{
    void hunt();
}

