/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_23002578;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Hisyam
 */
public class Account1 {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();
    private String name;
    ArrayList<Transactions> transactions = new ArrayList<>();
    

    public Account1() {
        this.dateCreated = new Date();
    }
    
    public Account1(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        this.dateCreated = new Date();

    }
    
    public Account1(String name, int id, double initialBalance){
        this.name = name;
        this.id = id;
        this.balance = initialBalance;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public double getMonthlyInterestRate(){
        double monthlyInterestRate = (this.annualInterestRate)/12;
        return monthlyInterestRate;
    }
    
    public double getMonthlyInterest(){
       
        return this.balance * getMonthlyInterestRate()/100;
    }
    
    public void deposit(double amount, String description){
        if(amount>0){
            balance += amount;
            transactions.add(new Transactions(new Date(),'D',this.balance,description));
        }
    }
    
    public void withdraw(double amount, String description){
        if(amount>0){
            balance -= amount;
            transactions.add(new Transactions(new Date(),'W',this.balance,description));
        }
    }
}

class Transactions{
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    public Transactions(Date dateOfTransactions, char type, double balance, String description){
        this.date = dateOfTransactions;
        this.type = type;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        String transactionType;
        if(this.type == 'W'){
            transactionType = "Withdraw";
        }
        else{
            transactionType = "Deposit";
        }
        return String.format("""
                             Date :%s
                             Type :%s
                             Balance :RM%.2f
                             Description :%s
                             """, date.toString(),transactionType,balance,description);
    }
}

class Tester{
    public static void main(String[] args) {
        Account1 myAccount = new Account1("George",1122,1000);
        myAccount.setAnnualInterestRate(1.5);
        myAccount.deposit(30, "none");
        myAccount.deposit(40, null);
        myAccount.deposit(50, null);
        myAccount.withdraw(5, "money");
        myAccount.withdraw(4, null);
        myAccount.withdraw(2, "b ye");
        
        //Account Summary
        System.out.println("Name:" + myAccount.getName());
        System.out.println("Annual Interest:" + myAccount.getAnnualInterestRate()+"%");
        System.out.printf("Account Balance:RM %.2f",myAccount.getBalance());
        System.out.println("");System.out.println("");
        for(int i=0;i<myAccount.transactions.size();i++){
            System.out.println(myAccount.transactions.get(i));
        }
    }
}
