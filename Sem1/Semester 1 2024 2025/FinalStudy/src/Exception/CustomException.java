/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.Scanner;
public class CustomException {
    public static void checkAge(int age) throws AgeException{
        if(age<0){
            throw new AgeException("Invalid age");
        }
        else if(age<18){
            throw new AgeException("You need to be 18 or older to sign up");
        }
        else{
            System.out.println("Sign up successfully");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          
            try {
                System.out.print("Age: ");
                int age = sc.nextInt();
                checkAge(age);
            } catch (AgeException e) {
                System.out.println(e.getLocalizedMessage());
            }
        
    }
}

class AgeException extends Exception{
    public AgeException(String message){
        super(message);
    }
}