
package soalan2;

import java.util.Scanner;


public class b {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter age: ");
       int age = sc.nextInt();
       
       try{
       checkAge(age);
        }
       catch(Exception e){
           System.out.println("Problem occured: " + e);
       }
    }
    
    public static void checkAge(int age)throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age is less than 18");
        }
        else{
            System.out.println("Age is 18 and above");
        }
    }
}

class InvalidAgeException extends Exception{
    InvalidAgeException (String message){
        super(message);
    }
}
