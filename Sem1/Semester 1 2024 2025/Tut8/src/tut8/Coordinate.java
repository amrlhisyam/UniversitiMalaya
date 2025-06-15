package tut8;
public class Coordinate {
    // Instance variables for x and y coordinates
    private double x;
    private double y;

    // Constructor that initializes the coordinates to (0, 0)
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor that initializes the coordinates to the given values
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Accessor method for x-coordinate
    public double getX() {
        return x;
    }

    // Mutator method for x-coordinate
    public void setX(double x) {
        this.x = x;
    }

    // Accessor method for y-coordinate
    public double getY() {
        return y;
    }

    // Mutator method for y-coordinate
    public void setY(double y) {
        this.y = y;
    }

    // Method to display the coordinates
    public void displayCoordinates() {
        System.out.println("Coordinates: (" + x + ", " + y + ")");
    }

    // Main method to test the Coordinate class
    public static void main(String[] args) {
        // Create a Coordinate object using the default constructor
        Coordinate point1 = new Coordinate();
        point1.displayCoordinates(); // Output: Coordinates: (0.0, 0.0)

        // Create a Coordinate object using the parameterized constructor
        Coordinate point2 = new Coordinate(3.5, 4.5);
        point2.displayCoordinates(); // Output: Coordinates: (3.5, 4.5)

        // Change the coordinates using mutator methods
        point1.setX(1.0);
        point1.setY(2.0);
        point1.displayCoordinates(); // Output: Coordinates: (1.0, 2.0)
    }
}