/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import java.util.Arrays;

/**
 *
 * @author Hisyam
 */
public class Main {
    public static void main(String[] args) {
        OOP p = new OOP();
        System.out.println(p.color);
        System.out.println(p.point);
        System.out.println(p.type);
        
        System.out.println(OOP.clicked);
        OOP.click();
        System.out.println(OOP.clicked);
        
headphone r = new headphone();
        System.out.println(Arrays.toString(r.controls));
    }
}
