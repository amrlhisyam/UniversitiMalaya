
package method;

// pass by value 
public class TestPassByValue {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        
        System.out.println("Before involing swap method , num1 is " + num1 + " n2 is " + num2);
        swap (num1 , num2) ; 
        System.out.println("After invoking swap method num1 is " + num1 + " num2 is " + num2);
    }
 
    // swap two variables;
public static void swap (int n1 , int n2){
    System.out.println("\tInside swap method ");
    System.out.println("Before swapping n1 is " + n1 + " n2 is " + n2);
    
    // swap n1 with n2
    int temp = n1;
    n1 = n2 ; 
    n2 = temp;
    
    System.out.println("\tAfter swappin , n1 is " + n1 + " n2 is " + n2);
    }
}
