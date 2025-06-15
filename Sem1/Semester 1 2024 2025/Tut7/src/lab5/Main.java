package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Product {
    String productId, productName;
    double productPrice;

    public Product(String productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

}

class Order{
    String orderId, productId;
    int orderQuantity;
    
    public Order(String orderId, String productId, int orderQuantity){
        this.orderId = orderId;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }
}

public class Main {

    public static void main(String[] args) {
        String productPath = "C:\\Users\\Hisyam\\Downloads\\Lab07 (1)\\Lab07\\product.txt";
        String orderPath = "C:\\Users\\Hisyam\\Downloads\\Lab07 (1)\\Lab07\\order.txt";
        
        Map<String, Product> productMap = new HashMap<>();
        List<Order> orderList = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(orderPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String orderId = parts[0].trim();
                    String productId = parts[1].trim();
                    int orderQuantity = Integer.parseInt(parts[2].trim());

                    orderList.add(new Order(orderId, productId, orderQuantity));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            

            
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading the file");
        } catch (NumberFormatException nfe) {
            System.out.println("Error parsing order quantity");
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(productPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String productId = parts[0].trim();
                    String productName = parts[1].trim();
                    double productPrice = Double.parseDouble(parts[2].trim());

                    productMap.put(productId, new Product(productId, productName, productPrice));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            

            
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading the file");
        } catch (NumberFormatException nfe) {
            System.out.println("Error parsing product price");
        }
        System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "ProductID", "ProductName", "OrderQuantity", "PricePerUnit", "TotalPrice");
        for (Order order: orderList){
            Product product = productMap.get(order.productId);
            if(product != null){
                double totalPrice = product.productPrice * order.orderQuantity;
                System.out.printf("%-10s %-20s %-15d %-15.2f %-15.2f%n",
                        product.productId, product.productName, order.orderQuantity, product.productPrice, totalPrice);
            }
            else
                System.out.println("Product not found");
        }
    }
}