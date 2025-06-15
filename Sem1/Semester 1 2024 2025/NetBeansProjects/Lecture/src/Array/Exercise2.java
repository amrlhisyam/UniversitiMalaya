
package Array;

public class Exercise2 {
    public static void main(String[] args) {
        char symbol [] = {'$' , '%' , '+' , '-'} ; 
        
        symbol[2] = '*' ; 
        
        for ( int i = 0 ; i < symbol.length ; i++) {
            System.out.print(symbol[i] + " ");
        }
        System.out.println();
     }
}
