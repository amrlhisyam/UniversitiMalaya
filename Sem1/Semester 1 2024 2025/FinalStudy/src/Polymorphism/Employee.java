/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphism;

/**
 *
 * @author Hisyam
 */
public abstract class Employee{
    String name;
    
    public Employee(String name){
        this.name= name;
    }
    
    public abstract double totalSalary();
    
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Employee Type: " + this.getClass().getSimpleName());
        System.out.printf("Total Salary: RM%.2f\n\n",totalSalary());
    }
}

class permanentEmployee extends Employee{
    char type;
    
    public permanentEmployee(String name, String type) {
        super(name);
        this.type = type.charAt(0); 
    }

    @Override
    public double totalSalary() {
        switch(type){
        
            case 'A' -> { return 4000;
            }
            case 'B' -> {return 3000;}
            case 'C' -> {return 2000;}
            default -> {
                System.out.println("Enter valid Permanent Employee Type");
                return -1;
            }
        }
    }

}

class contractEmployee extends Employee{
    double totalSales;

    public contractEmployee(String name, double totalSales) {
        super(name);
        this.totalSales = totalSales;
    }

    @Override
    public double totalSalary() {
        double a = totalSales * (0.5);
        double totalSalary = a + 500 ; 
        return totalSalary;
    }

}

class temporaryEmployee extends Employee{
    int hourWork;

    public temporaryEmployee(String name, int hourWork) {
        super(name);
        this.hourWork = hourWork;
    }

    @Override
    public double totalSalary() {
        double totalSalary = 15 * hourWork;
        return totalSalary;
    }

}

class tester {
    public static void main(String[] args) {
        permanentEmployee employee1 = new permanentEmployee("Hisyam","A");
        contractEmployee employee2 = new contractEmployee("Amirul",15000);
        temporaryEmployee employee3 = new temporaryEmployee("Ameera", 17);
        
        employee1.display();
        employee2.display();
        employee3.display();
    }

}