/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_23002578;

import java.util.Date;

/**
 *
 * @author Hisyam
 */
public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {}
    
    public Account(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public Date getDateCreated(){
        return this.dateCreated;
    }
    
    public double getMonthlyInterestRate(){
        double monthlyInterestRate = (this.annualInterestRate)/12;
        return monthlyInterestRate;
    }
    
    public double getMonthlyInterest(){
       
        return this.balance * getMonthlyInterestRate()/100;
    }
    
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
        }
    }
    
    public void withdraw(double amount){
        if(amount>0){
            balance -= amount;
        }
    }
}

class demoAccount{
    public static void main(String[] args) {
        Account myAccount = new Account(1112,20000);
        myAccount.setAnnualInterestRate(4.5);
        myAccount.withdraw(2500);
        myAccount.deposit(3000);
        System.out.println(myAccount.getBalance());
        System.out.println(myAccount.getMonthlyInterest());
        System.out.println(myAccount.getDateCreated());
    }
}


