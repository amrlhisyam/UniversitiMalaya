/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan4;
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d;
        int j = 10;
        System.out.print("First complex number. Enter a number for the real part: ");
        a = sc.nextDouble();
        System.out.print("First complex number. Enter a number for the imaginary part: ");
        b = sc.nextDouble();
        System.out.print("Second complex number. Enter a number for the real part: ");
        c = sc.nextDouble();
        System.out.print("Second complex number. Enter a number for the imaginary part: ");
        d = sc.nextDouble();
        Complex complex1 = new Complex(a,b);
        Complex complex2= new Complex(c,d);
        System.out.println("");
        System.out.println("First complex number: "+ complex1.toString());
        System.out.println("Second complex number: "+complex2.toString());
        complex1.addComplexNum(complex2);
        complex1.subtractComplexNum(complex2);
    }
}

class Complex{
    double real;
    double imaginary;

    public Complex() {
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public void addComplexNum(Complex b){
        double realPart, imaginaryPart;
        realPart = this.real + b.real;
        imaginaryPart = this.imaginary + b.imaginary;
        System.out.printf("""
                          Addition of two complex numbers: (%.0f + %.0fi)
                          """
        ,realPart, imaginaryPart);
    }
    
    public void subtractComplexNum(Complex b){
        double realPart, imaginaryPart;
        realPart = this.real - b.real;
        imaginaryPart = this.imaginary - b.imaginary;
        System.out.printf("""
                          Subtraction of two complex numbers: (%.0f + %.0fi)
                          """
        ,realPart, imaginaryPart);
    }
    
    @Override
    public String toString(){
     return String.format("(%.0f + %.0fi)", this.real,this.imaginary);
    }
}