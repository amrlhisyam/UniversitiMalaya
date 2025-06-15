
package VIVA;

import java.util.Scanner ; 
public class Q2Aliff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Enter the starting value : ");
        int start_val = sc.nextInt();
        System.out.printf("Enter the ending value : ");
        int ending_val = sc.nextInt();
        
        System.out.println("");
        
        System.out.println("The output is : ");
        
        
        for (int i = start_val; i <= ending_val; i++){
            if ((i%3 == 0) && (i%5 == 0)){
                System.out.println("LuluLala");
            }
            else if (i%5 == 0){
                System.out.println("Lala");
            }
            else if (i%3 == 0){
                System.out.println("Lulu");
            }
            else {
                System.out.println(i);
            }
        }
        
    }
    
}
 
