/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial2;
import java.util.Random;

/**
 *
 * @author Hisyam
 */
public class L2Q3 {
    public static void main(String[] args) {
        Random r = new Random();
        int num1,num2,num3,min,max;
        min = 10;
        max = 51;
        
        num1 = r.nextInt(min,max);
        num2 = r.nextInt(min,max);
        num3 = r.nextInt(min,max);
        
        int Sum = num1 + num2 + num3;
        double average = (num1+num2+num3)/(double)3;
        
        System.out.println("num1:"+num1);
        System.out.println("num2:"+num2);
        System.out.println("num3:"+num3);
        System.out.println("Sum of the numbers is: "+Sum);
        System.out.printf("Average of the numbers is: %.2f\n",average);
    }
}
