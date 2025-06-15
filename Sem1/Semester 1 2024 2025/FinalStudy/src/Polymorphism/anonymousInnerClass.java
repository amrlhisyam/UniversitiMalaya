/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */
public class anonymousInnerClass {
    public static void main(String[] args) {
        Greeting greeting = new Greeting(){
            
            @Override
            public void Welcome(){
                System.out.println("Yo Bro!");
            }
        };
        Greeting greeting2 = new Greeting();
        
        greeting.Welcome();
        greeting2.Welcome();
    }
}

class Greeting{
    public void Welcome(){
        System.out.println("Hello World!");
    }
}
