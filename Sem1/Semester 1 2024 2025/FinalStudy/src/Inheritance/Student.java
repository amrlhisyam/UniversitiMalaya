package Inheritance;

import java.io.*;
import java.util.ArrayList;

public class Student extends PersonProfile {
    String fileInputName;
    ArrayList<String> courseNames;
    ArrayList<String> courseCodes;
    ArrayList<String> semesters;
    ArrayList<String> sessions;
    ArrayList<Integer> marks;

    public Student(String name, char gender, String dateOfBirth, String fileInputName) {
        super(name, gender, dateOfBirth);
        this.fileInputName = fileInputName;
        this.courseNames = new ArrayList<>();
        this.courseCodes = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.marks = new ArrayList<>();
        readFile();
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInputName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Read course name
                courseNames.add(line.trim());
                // Read course code
                if ((line = reader.readLine()) != null) {
                    courseCodes.add(line.trim());
                }
                // Read semester
                if ((line = reader.readLine()) != null) {
                    semesters.add(line.trim());
                }
                // Read session
                if ((line = reader.readLine()) != null) {
                    sessions.add(line.trim());
                }
                // Read mark
                if ((line = reader.readLine()) != null) {
                    marks.add(Integer.parseInt(line.trim()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing mark: " + e.getMessage());
        }
    }

    private String getGrade(int mark) {
        if (mark >= 85) {
            return "A";
        } else if (mark >= 70) {
            return "B";
        } else if (mark >= 50) {
            return "C";
        } else if (mark >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public void display() {
        super.display(); // Call the display method of PersonProfile
        System.out.println("Courses:");
        for (int i = 0; i < courseNames.size(); i++) {
            System.out.printf("Course Code: %s, Course Name: %s, Semester: %s, Session: %s, Mark: %d, Grade: %s\n",
                    courseNames.get(i), courseCodes.get(i), semesters.get(i), sessions.get(i), marks.get(i), getGrade(marks.get(i)));
        }
    }
}