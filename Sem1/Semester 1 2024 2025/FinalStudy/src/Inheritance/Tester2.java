package Inheritance;

import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for student information
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student's gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter student's date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.next();

        System.out.print("Enter the name of the course file (e.g., course.txt): ");
        String fileInputName = scanner.next();

        // Create a Student object
        Student student = new Student(name, gender, dateOfBirth, fileInputName);

        // Display the student's profile and course information
        student.display();

        // Close the scanner
        scanner.close();
    }
}