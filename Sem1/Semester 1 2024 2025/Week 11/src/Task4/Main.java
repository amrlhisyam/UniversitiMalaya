package Task4;

class firstClass {
    void displayMessage() {
        System.out.println("Hello from First Class");
    }
}

class secondClass {
    void accessFirstClass() {
        firstClass obj = new firstClass(); // Create an instance of firstClass
        obj.displayMessage(); // Call the displayMessage method
    }
}

public class Main {
    public static void main(String[] args) {
        secondClass secondObj = new secondClass(); // Create an instance of secondClass
        secondObj.accessFirstClass(); // Call the method to access firstClass
    }
}