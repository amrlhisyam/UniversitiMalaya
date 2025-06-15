/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

import java.io.*;
public class L7Q6 {
    public static void main(String[] args) {
        String productPath ="product.txt";
        String orderPath = "order.txt";
        String line = "";
        String productIDArray[] = new String[100];
        String productNameArray[] = new String[100];
        double priceArray[] = new double [100];
        int quantityArray[] = new int[100];
        double totalArray[] = new double[100];
        int index=0;
        int counter=0;
        
        try{
        BufferedReader reader = 
                new BufferedReader (new FileReader(productPath));
            while((line = reader.readLine())!=null){
                counter++;
                String product[] = line.split(",");
                if(product.length == 3){
                    String productID = product[0];
                    String productName = product[1];
                    double price = Double.parseDouble(product[2]);
                    productIDArray[index] = productID;
                    productNameArray[index] = productName;
                    priceArray[index] = price;
                }
                index++;
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error with File input");
        }
        index = 0;
        try{
        BufferedReader reader = 
                new BufferedReader (new FileReader(orderPath));
            while((line = reader.readLine())!=null){
                String [] order = line.split(",");
                if(order.length == 3){
                    String productID = order[1];
                    int quantity = Integer.parseInt(order[2]);
                    for(int i=0;i<counter;i++){
                        if(productID.equals(productIDArray[i])){
                            quantityArray[i] = quantity;
                        }
                    }
                }
                index++;
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error with File input");
        }
        
        for(int i=0;i<totalArray.length;i++){
            totalArray[i] = (priceArray[i]*quantityArray[i]);
        }
        

        
        String[] title = {"ProductID","ProductName","Quantity","PricePerUnit","Total"};
        String[][] output = new String[counter][5];
        for(int i=0;i<output.length;i++){
            output[i][0] = productIDArray[i];
            output[i][1] = productNameArray[i];
            output[i][2] = String.valueOf(quantityArray[i]);
            output[i][3] = String.format("%.2f", priceArray[i]);
            output[i][4] = String.format("%.2f", totalArray[i]);
        }
        
        for(int i=0;i<title.length;i++){
            System.out.printf("%-25s",title[i]);
        }
        System.out.println("");
        
        for(int i=0;i<output.length;i++){
            for(int j=0;j<output[i].length;j++){
                System.out.printf("%-25s",output[i][j]);
            }
            System.out.println("");
        }
    }
    

}
