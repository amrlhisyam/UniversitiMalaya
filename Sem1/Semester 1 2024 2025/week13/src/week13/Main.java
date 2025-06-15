/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13;
class MyCustomException extends Exception{
    public MyCustomException (String Message){
        super(Message);
    }
}
public class Main  {
    public static void main(String[] args) {
        try{
            throwCustomException();
            
        }catch(MyCustomException e){
            System.out.println("Cuaght MyCustomException " + e.getMessage());
        }
    }
    
    public static void throwCustomException() throws MyCustomException{
        throw new MyCustomException("custom error occured");
    }
}
