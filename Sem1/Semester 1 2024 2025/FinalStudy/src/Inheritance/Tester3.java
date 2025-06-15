package Inheritance;

import java.util.Scanner;

public class Tester3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for lecturer information
        System.out.print("Enter lecturer's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter lecturer's gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter lecturer's date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.next();

        // Create a Lecturer object
        Lecturer lecturer = new Lecturer(name, gender, dateOfBirth);

        // Display the lecturer's profile and course information
        lecturer.display();

        // Close the scanner
        scanner.close();
    }
}
