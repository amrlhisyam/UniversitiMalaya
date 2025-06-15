
package week.pkg11;


class Vehicle {
    String type;
    protected String brand = "Generic";
    void startEngine(){
        System.out.println("Engine Started");
        
    }
}

class car extends Vehicle{
    int wheels;
    void startEngine(){
        System.out.println("Car Engine Started");
    }
    void displayBrand(){
        System.out.println("Brand: " + brand);
    }
}
