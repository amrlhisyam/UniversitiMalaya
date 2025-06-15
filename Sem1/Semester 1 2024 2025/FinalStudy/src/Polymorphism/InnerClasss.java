/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */

// inner class = A class inside of another class.


public class InnerClasss {
    public static void main(String[] args) {
        Outside out = new Outside();
        Outside.Inside in = out.new Inside();
        in.Greeting();
    }
}

class Outside{
    
    String x = "Hello ";
    class Inside{
        String y = "World!";
        
        public void Greeting(){
        System.out.println(x+y);

        }
    }

}
