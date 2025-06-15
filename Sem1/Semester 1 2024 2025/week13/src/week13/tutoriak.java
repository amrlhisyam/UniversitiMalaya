/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13;


public class tutoriak  {
    public static void main(String[] args) {
        try{
            int num = 10/0 ; 
        }catch (ArithmeticException e){
            System.out.println("error " + e.getMessage());
        }
    }
}
