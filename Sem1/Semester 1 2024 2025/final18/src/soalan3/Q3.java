/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan3;

import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fontSize;
        char fontType;
        int format;
        System.out.print("Enter font size: ");
        fontSize = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter font type: ");
        fontType = sc.nextLine().charAt(0);
        System.out.print("Enter format[1 - Vertical, 2 - Horizontal]: ");
        format = sc.nextInt();
        sc.nextLine();
        display8(fontSize, fontType, format);
    }
    
    public static void display8 (int fontSize, char fontType, int format){
        
        if (format == 1){
            for(int i=0; i<(5+(fontSize-1)*2); i++){
                for(int j=0; j<fontSize+2; j++){
                    if(i == 0 || j == 0 || i == (5+(fontSize-1)*2)/2  || j == fontSize+1 || i == (5+(fontSize-1)*2)-1){
                        System.out.print(fontType);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
        else if (format ==2) {
            for(int i=0; i<fontSize+2; i++){
                for(int j=0; j<(5+(fontSize-1)*2); j++){
                    if(i == 0 || j == 0 || j == (5+(fontSize-1)*2)/2  || i == fontSize+1 || j == (5+(fontSize-1)*2)-1){
                        System.out.print(fontType);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
