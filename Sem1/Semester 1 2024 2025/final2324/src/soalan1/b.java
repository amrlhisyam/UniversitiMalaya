/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan1;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum=0;
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        for(int i=1 ; i<=n ; i++){
            sum += 1/(double) i ; 
        }
        
        System.out.printf("The sum of series is: %.2f", sum);
        System.out.println("");
    }
}
