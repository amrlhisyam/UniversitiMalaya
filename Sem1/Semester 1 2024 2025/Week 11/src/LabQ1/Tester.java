package LabQ1;
import  java.util.Scanner; 

class Shape{
    String name;
    double perimeter, area;
    
    public double getPerimeter(){
        return perimeter;
    }
    
    public double getArea(){
        return area;
    }
    
    public void setPerimeter(double perimeter){
        this.perimeter = perimeter;
    }
    
    public void setArea(double area){
        this.area = area;
    }
    
    public void displayPerimeter(){
        System.out.printf("Perimeter: %.2f",perimeter);
    }
    
    public void displayArea(){
        System.out.printf("Area: %.2f",area);
    }
}

class Rectangle extends Shape{
    private double width, length;
    
    public void inputsideLength(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        width = sc.nextDouble();
        System.out.print("Length: ");
        length = sc.nextDouble();
    }
    
    public void computePerimeter(){
        perimeter = (2*width) + (2*length);
    }
    
    public void computeArea(){
        area = width * length;
    }
}

class Square extends Shape{
    double length;
    
    public void inputLength(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Side length: ");
        length = sc.nextDouble();
    }
    
    public void computePerimeter(){
        perimeter = 4*length;
    }
    
    public void computeArea(){
        area = length * length;
    }
}

class Circle extends Shape{
    double diameter;
    
    public void inputDiameter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Diameter of circle: ");
        diameter = sc.nextDouble();
    }
    
    public void computePerimeter(){
        perimeter = 2 * Math.PI * (diameter/2);
    }
    
    public void computeArea(){
        area = Math.PI * Math.pow((diameter/2), 2);
    }
}

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test Rectangle
        System.out.println("Rectangle:");
        Rectangle rectangle = new Rectangle();
        rectangle.inputsideLength();
        rectangle.computePerimeter();
        rectangle.computeArea();
        rectangle.displayPerimeter();
        System.out.println(); // New line for better readability
        rectangle.displayArea();
        System.out.println(); // New line for better readability

        // Test Square
        System.out.println("Square:");
        Square square = new Square();
        square.inputLength();
        square.computePerimeter();
        square.computeArea();
        square.displayPerimeter();
        System.out.println(); // New line for better readability
        square.displayArea();
        System.out.println(); // New line for better readability

        // Test Circle
        System.out.println("Circle:");
        Circle circle = new Circle();
        circle.inputDiameter();
        circle.computePerimeter();
        circle.computeArea();
        circle.displayPerimeter();
        System.out.println(); // New line for better readability
        circle.displayArea();
        System.out.println(); // New line for better readability

        sc.close(); // Close the scanner
    }
}