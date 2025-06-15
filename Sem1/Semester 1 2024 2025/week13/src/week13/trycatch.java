
package week13;

public class trycatch {
    public static void main(String[] args) {
        
        try{
            int result = 10/0;   
        }catch(ArithmeticException e){
            System.out.println("Error occur" + e.getMessage());
        }
        
    }
}
