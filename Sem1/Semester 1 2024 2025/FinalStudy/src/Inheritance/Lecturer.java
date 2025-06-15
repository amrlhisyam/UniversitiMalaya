/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hisyam
 */
public class Lecturer extends PersonProfile{
    List<String>courseNames;
    List<String>courseCodes;
    List<String>semesters;
    List<String>sessions;
    List<Integer>creditHour;
    List<Integer>numberOfStudents;
    
    public Lecturer(String name, char gender, String dateOfBirth){
        super(name, gender, dateOfBirth);
        courseNames = new ArrayList<>();
        courseCodes = new ArrayList<>();
        semesters = new ArrayList<>();
        sessions = new ArrayList<>();
        creditHour = new ArrayList<>();
        numberOfStudents = new ArrayList<>();
        readFile();
    }
    
        private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("lecturer.txt"))) {
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
                    creditHour.add(Integer.parseInt(line.trim()));
                }
                if ((line = reader.readLine()) != null) {
                    numberOfStudents.add(Integer.parseInt(line.trim()));
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
        
        public double computeCreditHour(int num, int creditHour){
            if(num >= 150)
                return creditHour * 3;
            else if(num >= 100)
                return creditHour *2;
            else if(num>=50)
                return creditHour*1.5 ;
            else
                return creditHour;
    }
        
        public void display(){
            super.display();
            for(int i=0; i<courseCodes.size();i++){
                System.out.printf("Course Code: %s, Course Name: %s, Semester: %s, Session: %s, Credit Hour: %.2f, Number of Students: %d\n",
                        courseCodes.get(i),courseNames.get(i),semesters.get(i),sessions.get(i),computeCreditHour(numberOfStudents.get(i),creditHour.get(i)),numberOfStudents.get(i));
            }
        }
}