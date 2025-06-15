
package soalan5;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        Fruit fruits[] = new Fruit[4];
        Apple fruit1 = new Apple("Red Apple","Red Apple", 8);
        Apple fruit2 = new Apple("Green Apple","Green Apple", 11);
        Watermelon fruit3 = new Watermelon("Local Watermelon","Local", 7.6);
        Watermelon fruit4 = new Watermelon("Imported Watermelon","imported", 4);
        fruits[0] = fruit1;
        fruits[1] = fruit2;
        fruits[2] = fruit3;
        fruits[3] = fruit4;
        for(int i=0;i<fruits.length;i++){
            System.out.println(fruits[i].toString());
        }
        Arrays.sort(fruits);
        System.out.println("The cheapest item is");
        System.out.println(fruits[0].toString());
    }
}

abstract class Fruit implements Comparable<Fruit>{
    String name;
    String type;

    public Fruit(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    abstract double totalPrice();
    
    @Override
    public String toString(){
        return String.format("""
                             Fruit Type: %s
                             Name: %s
                             """,
                this.type, this.name );
    }
    
    
}

class Apple extends Fruit{
    
    int quantity;

    public Apple(String name, String type, int quantity) {
        super(name, type);
        this.quantity = quantity;
    }

    @Override
    double totalPrice() {
        if(this.type.equalsIgnoreCase("green apple")){
            return 1.2*quantity;
        }
        else{
            return 1.8*quantity;
        }
    }
    
    @Override
    public String toString(){
        return String.format("""
                             %s: - %d = RM %.2f
                             """, 
                this.name,this.quantity,this.totalPrice());
    }

    @Override
    public int compareTo(Fruit o) {
        return Double.compare(this.totalPrice(), o.totalPrice());
    }

}

class Watermelon extends Fruit{
    double weigth;

    public Watermelon(String name, String type, double weight) {
        super(name, type);
        this.weigth = weight;
    }

    @Override
    double totalPrice() {
        double price = -1; 
        if(this.type.equalsIgnoreCase("local")){
            if(this.weigth<2.00 && this.weigth>0){
                price =  this.weigth*2.25;
            }
            else if(this.weigth>=2 && this.weigth<=5){
                price = this.weigth*1.95;
            }
            else{
                price =  this.weigth*1.65;
            }
        }
        else if(this.type.equalsIgnoreCase("imported")){
            if(this.weigth<2.00 && this.weigth>0){
                price =  this.weigth*3.75;
            }
            else if(this.weigth>=2 && this.weigth<=5){
                price =  this.weigth*3.45;
            }
            else{
                price =  this.weigth*3.15;
            }
        }
        return price;
    }
    
    @Override
    public String toString(){
        return String.format("""
                             %s: - %.2fkg = RM %.2f
                             """, 
                this.name,this.weigth,this.totalPrice());
    }

    @Override
    public int compareTo(Fruit o) {
        return Double.compare(this.totalPrice(), o.totalPrice());
    }
    
}
