package newpackage;

public class TestCircle {
    public static void main(String[] args) {
        
        //create a circle with a radius of 1
        Circle circle1 = new Circle() ;
        System.out.println("The area od the circle of radius " 
        + circle1.radius + " is " + circle1.getArea());
        
        //create a circle with radius 25
        Circle circle2 = new Circle(25) ;
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());
        
        //create a circle with radius 125
        Circle circle3= new Circle(125) ;
        System.out.println("The area of the circle of radius "
                + circle3.radius + " is " + circle3.getArea());
        
        //modify circle radius
        circle2.radius = 100;
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());
        
    }
 
}

//define the circle with two constructor
class Circle {
    double radius ;
    
    //construct a circle with radius 1
    Circle() {
        radius = 1 ;
    }
    
    // construct a circle with specified radius
    Circle(double newRadius){
        radius = newRadius; 
    }
    
    // return area of this circle
    double getArea(){
        return radius*radius*Math.PI;
    }
    
    //return perimeter of this cirle
    double getPerimeter(){
        return 2*radius*Math.PI;
    }
    
    //set new Radius for the circle
    void setRadius (double newRadius){
        radius = newRadius ;
    }
    
}

