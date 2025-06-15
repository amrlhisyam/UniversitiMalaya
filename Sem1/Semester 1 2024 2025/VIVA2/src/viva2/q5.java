package viva2;
import java.util.*;

public class q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  
        String[] fruits = {"Apple", "Grape", "Banana", "Mango", "Orange", "Strawberry", "Blueberry"};  
        int[] storage = {45, 57, 75, 34, 75, 65, 78};  
        double[] price = {5.00, 10.00, 2.50, 6.00, 3.00, 15.00, 12.00};  
  
        printFruit(fruits);  
        
        System.out.print("Please enter the fruit you want to buy: ");  
        String fruitSelect = in.nextLine();  
  
        System.out.print("Unit or Box: ");  
        int quantity = in.nextInt();  
  
        int fruitIdx = getIdxFruit(fruits, fruitSelect);  
  
        if (!haveProduct(fruits, fruitIdx)) {  
            System.out.println("Sorry, we currently do not offer this product.");  
        } else if (!haveStock(fruitIdx, storage, quantity)) {  
            System.out.println("Sorry, we do not have enough stock for " + fruits[fruitIdx] + ". Please come again later!");  
        } else {  
            System.out.println("\nKindly Checkout here: ");  
            generateBill(fruits, fruitIdx, price, quantity);  
        }  
        
        
    }  
    
    public static void printFruit(String[] fruits) {
        int counter = 1; 
        for (String fruit : fruits) {
            System.out.println(counter + ". " + fruit);
            counter++; 
        }
        System.out.println();
    }
    
    public static int getIdxFruit(String[] fruit, String fruitSelect) {
        for (int i = 0; i < fruit.length; i++) {
            if (fruitSelect.equalsIgnoreCase(fruit[i])) {
                return i; 
            }
        }
        return -1; 
    }
    
    public static boolean haveProduct(String[] fruits, int fruitIdx) {
        return fruitIdx >= 0 && fruitIdx < fruits.length; 
    }
    
    public static boolean haveStock(int fruitIdx, int[] storage, int quantity) {
        return quantity <= storage[fruitIdx] && quantity > 0; 
    }
    
    public static void generateBill(String[] fruits, int fruitIdx, double[] price, int quantity) {
        double totalPrice = price[fruitIdx] * quantity; 
        System.out.println("----------------------------------------------------");
        System.out.println("----------------- Fresh Mart Receipt -----------------");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-15s %-10s %-15s%n", "Product", "Quantity", "Price per Unit (RM)");
        System.out.printf("%-15s %-10d RM %-14.2f%n", fruits[fruitIdx], quantity, price[fruitIdx]);
        System.out.println("----------------------------------------------------");
        System.out.printf("Total price: RM %.2f%n", totalPrice);
        System.out.println("----------------------------------------------------");
    }
}