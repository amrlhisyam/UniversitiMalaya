/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingrevisions;

/**
 *
 * @author Hisyam
 */
interface Account{
    public abstract int deposit(int depo);
    public abstract boolean withdraw(int wtdro);
}

public class BankAccount implements Account{
    private int balance;
    
    public BankAccount(int balance){
        this.balance = balance;
    }
    
    @Override
    public int deposit(int depo){
        this.balance += depo;
        return balance;
    }
    
    @Override
    public boolean withdraw(int wtdro){
        if(wtdro <= this.balance){
            this.balance -= wtdro;
            return true;
        }
        else return false;
    }
}

//class test{
//    public static void main(String[] args) {
//        BankAccount myBank = new BankAccount(100);
//        System.out.println(myBank.deposit(20));   //120
//        System.out.println(myBank.withdraw(130)); //false
//        System.out.println(myBank.withdraw(50));  //true
//    }
//}
