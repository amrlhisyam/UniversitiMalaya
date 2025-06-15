/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Labq2;

/**
 *
 * @author Hisyam
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount bankacc1 = new BankAccount("Amirul Hisyam Bin Amir Ruddin","050118101401", 35.67);
        bankacc1.displayCurrentAmount();
        bankacc1.deposit(100);
        bankacc1.displayCurrentAmount();
        bankacc1.withdraw(1250);
    }
    
}
