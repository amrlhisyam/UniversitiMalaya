package tut7;

import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class lab1 {

    public static void main(String[] args) {
        // Step 1: Create and populate the HashMap
        Map<String, String> table = new HashMap<>();
        table.put("WXES1116", "Programming 1");
        table.put("WXES1115", "Data Structure");
        table.put("WXES1110", "Operating System");
        table.put("WXES1112", "Computing Mathematics");

        // Step 2: Write the HashMap to a binary file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("coursename.dat"))) {
            outputStream.writeObject(table);
            System.out.println("Course data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error with file output: " + e.getMessage());
        }

        // Step 3: Read the HashMap from the binary file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("coursename.dat"))) {
            // Read the HashMap from the file
            Map<String, String> readTable = (Map<String, String>) inputStream.readObject();

            // Step 4: Get user input for course code
            System.out.print("Enter course code: ");
            try (Scanner input = new Scanner(System.in)) {
                String courseCode = input.nextLine();
                
                // Step 5: Retrieve the course name using the course code
                String courseName = readTable.get(courseCode);

                if (courseName != null ) {
                    System.out.println(courseName);
                } else {
                    System.out.println("Course Code: " + courseCode + " not found.");
                }
            }
        } catch (FileNotFoundException fe) {
            System.out.println("File not found: " + fe.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file: " + e.getMessage());
        } catch (ClassNotFoundException cfe) {
            System.out.println("Class not found: " + cfe.getMessage());
        }
    }
}