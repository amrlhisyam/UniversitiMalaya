/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */
public class abstractAndInterface {
        public static void main(String[] args) {
        Bird bird = new Bird("Sparrow");
        bird.makeSound(); // Output: Sparrow chirps.
        bird.eat();       // Output: Sparrow is eating.
        bird.fly();      // Output: Sparrow is flying.
    }
}
// Abstract Class Example
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound(); // Abstract method

    void eat() { // Concrete method
        System.out.println(name + " is eating.");
    }
}

// Interface Example
interface Flyable {
    void fly(); // Abstract method
}

// Concrete Class that extends Abstract Class and implements Interface
class Bird extends Animal implements Flyable {
    Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " chirps.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}


