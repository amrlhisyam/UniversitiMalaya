/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labq2;

/**
 *
 * @author Hisyam
 */
public class BankAccount {
    private String fullname, ic;
    private double amount;
    
    public BankAccount (String fn, String i, double a){
        fullname = fn;
        ic = i;
        amount = a;
    }
    
    public void deposit (double a){
        amount += a;
        System.out.println("Deposit "+a+" successfully");
    }
    
    public void withdraw(double a){
        if(a>amount){
            System.out.println("You  Withdraw More Than Your Amount");
        }
        else {
            amount -= a;
            System.out.println("Withdraw "+a+" successfully");
        }
    }
    
    public void displayCurrentAmount(){
        System.out.printf("Current Amount: %.2f",amount);
        System.out.println();
    }
}
