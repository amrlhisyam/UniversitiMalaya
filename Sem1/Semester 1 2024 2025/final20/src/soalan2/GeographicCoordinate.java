package soalan2;

import java.util.Scanner;

public class GeographicCoordinate {
    private static char direction ;
    private static double degree, minute, second;
    
    public static void main(String[] args) {
        enterDirection();
        convert(direction, degree, minute, second);
    }
    
    public static void convert(char direction, double degree, double minute, double second){
        double decimalDegree; 
        
        if (direction == 'N' || direction == 'E'){
            decimalDegree = degree + (minute*60 + second) / 3600;
            System.out.printf("Decimal degree: %.6f latitude \n" , decimalDegree);

        }
        else {
            decimalDegree = degree + (minute*60 + second) / 3600;
            System.out.printf("Decimal degree: -%.6f longitude \n" , decimalDegree);

        }
        
    }
    
    public static void enterDirection() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        
        while (!valid) {            
            try {
                System.out.print("Enter direction (N, S, E, W): ");
                 direction = sc.nextLine().toUpperCase().charAt(0); // Convert to uppercase
                checkDirection(direction);
                valid = true; // Set valid to true if no exception is thrown
            } catch (InvalidDirectionException e) {
                System.out.println(e.getMessage());
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("No input provided. Please enter a direction.");
            }
        }
        
        System.out.print("Enter degree: ");
         degree = sc.nextDouble();
        System.out.print("Enter minute: ");
         minute = sc.nextDouble();
        System.out.print("Enter second: ");
         second = sc.nextDouble();
        
        sc.close(); // Close the scanner
    }

    static class InvalidDirectionException extends Exception {
        public InvalidDirectionException(String message) {
            super(message);
        }
    }
    
    public static void checkDirection(char direction) throws InvalidDirectionException {
        switch (direction) {
            case 'N':
                System.out.println("You have chosen North successfully!");
                break;
            case 'S':
                System.out.println("You have chosen South successfully!");
                break;
            case 'E':
                System.out.println("You have chosen East successfully!");
                break;
            case 'W':
                System.out.println("You have chosen West successfully!");
                break;
            default:
                throw new InvalidDirectionException("Invalid direction chosen. Enter again!");
        }
    }
    
    public static void distance(){
        
    }
}