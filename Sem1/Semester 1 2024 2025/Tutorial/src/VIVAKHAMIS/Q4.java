
package VIVAKHAMIS;

import java.util.* ; 
public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int optionPizza ;
        int optionDrinks ;
        int optionDesserts ; 
        double sumTotal = 0 ;
        int counter = 0 ;
        int pizza = 0 ; 
        int drinks = 0 ;
        int desserts = 0 ;
        boolean order = true ;
        boolean opizza = true ; 
        boolean odrinks = true; 
        boolean odessert = true;
        while (order) {
        System.out.println();
        System.out.println("Welcome to Maroni's Pizza!");
        System.out.println("1. Pizza\n2. Drinks\n3. Dessert\n4. CHECKOUT");
        System.out.print("Pick an option: ");
        int option = input.nextInt() ;
        switch(option) {
            case 1 : 
                while (opizza) {
                System.out.println("");
                System.out.println("PIZZA");
                System.out.println("1 Chicken Peperoni - RM15\n2 Chicken Supreme - RM18\n3 Vegan Indulgence - RM12\n4 Beef Delight - RM22\n5 Margherita - RM9\n6 BACK TO MAIN MENU");
                System.out.print("Pick an option: ");
                optionPizza = input.nextInt();
                switch (optionPizza){
                    case 1 :
                        sumTotal += 15 ;
                        System.out.println("Added Chicken Peperoni");
                        System.out.println("Current total: RM" + sumTotal);
                        opizza = true; 
                        counter++ ;
                        break ;
                    case 2 : 
                        sumTotal += 18 ;
                        System.out.println("Added Chicken Supreme");
                        System.out.println("Current total: RM" + sumTotal);
                        opizza = true;
                        counter++ ;

                        break ;
                    case 3 : 
                        sumTotal += 12 ;
                        System.out.println("Added Vegan Indulgence");
                        System.out.println("Current total: RM" + sumTotal);
                        opizza = true;
                        counter++ ; 
                        break ;
                    case 4 : 
                        sumTotal += 22 ;
                        System.out.println("Added Beef Delight");
                        System.out.println("Current total: RM" + sumTotal);
                        opizza = true;
                        counter++ ;
                        break ;
                    case 5 : 
                        sumTotal += 9 ;
                        System.out.println("Added Margherita");
                        System.out.println("Current total: RM" + sumTotal);
                        opizza = true;
                        counter++ ; 
                        break ;
                    case 6 : 
                        opizza = false ;
                        break ;
                }
                if (counter > 0) {
                    pizza++ ; 
                }
                }
                break ; 
            case 2 : 
                counter = 0 ;
                while (odrinks) {
                System.out.println("");
                System.out.println("DRINKS");
                System.out.println("1 Strawberry Smoothie - RM8\n2 Banana Smoothie - RM8\n3 Mocktail - RM12\n5 Mineral Water - RM3\n6 BACK TO MAIN MENU");
                System.out.print("Pick an option: ");
                optionDrinks = input.nextInt();
                switch (optionDrinks){
                    case 1 :
                        sumTotal += 8 ;
                        System.out.println("Added Strawberry Smootie");
                        System.out.println("Current total: RM" + sumTotal);
                        odrinks = true; 
                        counter++ ; 
                        break ;
                    case 2 : 
                        sumTotal += 8 ;
                        System.out.println("Added Banana Smoothie");
                        System.out.println("Current total: RM" + sumTotal);
                        odrinks = true;
                        counter++ ; 
                        break ;
                    case 3 : 
                        sumTotal += 12 ;
                        System.out.println("Added Mocktail");
                        System.out.println("Current total: RM" + sumTotal);
                        odrinks = true;
                        counter++ ;
                        break ;
                    case 4 : 
                        sumTotal += 5 ;
                        System.out.println("Added Soft Drink");
                        System.out.println("Current total: RM" + sumTotal);
                        odrinks = true;
                        counter++ ; 
                        break ;
                    case 5 : 
                        sumTotal += 3 ;
                        System.out.println("Added Mineral Water");
                        System.out.println("Current total: RM" + sumTotal);
                        odrinks = true;
                        counter++ ; 
                        break ;
                    case 6 : 
                        odrinks = false ;
                        break ;
                        
                }
                if (counter>0) {
                    drinks++ ; 
                }
                }
                break ; 
            case 3 :
                counter = 0 ;
                while (odessert) {
                System.out.println("");
                System.out.println("DESSERTS");
                System.out.println("1 Tiramisu - RM7\n2 Strawberry Shortcake - RM10\n3 Green Jello - RM4\n4 Creme Brulee - RM15\n5 Raspberry Pie - RM20\n6 BACK TO MAIN MENU");
                System.out.print("Pick an option: ");
                optionDesserts = input.nextInt();
                switch (optionDesserts){
                    case 1 :
                        sumTotal += 8 ;
                        System.out.println("Added Tiramisu");
                        System.out.println("Current total: RM" + sumTotal);
                        odessert = true; 
                        counter++; 
                        break ;
                    case 2 : 
                        sumTotal += 8 ;
                        System.out.println("Added Strawberry Shortcake");
                        System.out.println("Current total: RM" + sumTotal);
                        odessert = true;
                        counter++;
                        break ;
                    case 3 : 
                        sumTotal += 12 ;
                        System.out.println("Added Green Jello");
                        System.out.println("Current total: RM" + sumTotal);
                        odessert = true;
                        counter ++ ; 
                        break ;
                    case 4 : 
                        sumTotal += 5 ;
                        System.out.println("Added Creme Brulee");
                        System.out.println("Current total: RM" + sumTotal);
                        odessert = true;
                        counter ++ ; 
                        break ;
                    case 5 : 
                        sumTotal += 3 ;
                        System.out.println("Added Raspberry Pie");
                        System.out.println("Current total: RM" + sumTotal);
                        odessert = true;
                        counter ++ ;
                        break ;
                    case 6 : 
                        odessert = false ;
                        break ;
                        
                }
                if ( counter > 0) {
                    desserts ++ ; 
                }
                }
                break ;
            case 4 :
                System.out.println("\n");
                if (pizza > 0 && drinks > 0 && desserts > 0) {
                    System.out.printf("Your total is RM%.2f\n" , sumTotal);
                    sumTotal = sumTotal * 0.8 ; 
                    System.out.println("You've availes the One-of-each offer. You get a 20% discount\n");
                    System.out.printf("Your new total is RM%.2f !\n" , sumTotal);
                    System.out.println("Have a nice day!");
                    order = false ; 
                }
                else {
                    System.out.printf("Your total is RM%.2f!\n",sumTotal);
                    System.out.println("Have a nice day!");
                    order = false ; 
                }
        }
        }
    }
}
