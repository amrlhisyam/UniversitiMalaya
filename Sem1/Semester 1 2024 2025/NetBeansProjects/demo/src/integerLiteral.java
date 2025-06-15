/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hisyam
 */
public class integerLiteral {
    public static void main(String[] args) {
        
        // an integer literal is decimal ny default
        // to use binary integer literal use a leading 0b or 0B
        // to denote octal integer literal use 0
        // to denote hexadecimal integer liiteral use 0x or 0X
        
        System.out.println(0B1111); // 15
        System.out.println(07777); // 4095
        System.out.println(0XFFFF); // 65535
        
        // to improve readibility it is allow to use underscore between two digits
        // denote a long type variable , by adding L at the end of integer
        long ssn = 232_45_4519L;
        long creditCardNumber = 2324_4545_4519_3415L;
        
        System.out.println(ssn); // 232454519
        System.out.println(creditCardNumber); // 2324454545193415
        
        //precision output
        System.out.printf("%.15f",1.0/3.0);
        System.out.println("");
        
        // floating point literal 
        // by default floating point literal is treated as double 
        // double has more precision
        // can make a float by adding f
        
        System.out.println(1.0F / 3.0F); // float
        System.out.println(1.0D / 3.0D); // double
        
        System.out.println(1.23456e2); // scientific notation
        
    }
}
