package tutorial6;

import java.util.* ;
public class T6Q2 {
    public static void main(String[] args) {
        int num1 = 'j';
        int num2 = 'i';
        int num3 = 'h';

        displayInDecreasingOrder(num1, num2, num3);
    }

    public static void displayInDecreasingOrder(int a, int b, int c) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a < c) {
            temp = a;
            a = c;
            c = temp;
        }
        if (b < c) {
            temp = b;
            b = c;
            c = temp;
        }
        System.out.println(a + " " + b + " " + c);
    }
}

