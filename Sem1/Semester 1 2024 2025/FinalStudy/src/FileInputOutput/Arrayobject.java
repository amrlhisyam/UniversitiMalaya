/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

/**
 *
 * @author Hisyam
 */

import java.io.*;
import java.util.Arrays;
public class Arrayobject {
    public static void main(String[] args) {
        String fileName = "person.dat";
        Person persons[] = new Person[100];
        try{
            ObjectInputStream inputStream = 
                    new ObjectInputStream(new FileInputStream(fileName));
            while (true) {                
                try {
                    int totalNumber = inputStream.readInt();
                    for (int i = 0; i < totalNumber; i++) {
                        for (int j = 0; j < 3; j++) {
                            String name = inputStream.readUTF();
                            int age = inputStream.readInt();
                            char gender = inputStream.readChar();
                            persons[i] = new Person(name, age, gender);
                        }
                        
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        catch(IOException e){
            System.out.println("Error input file");
        }
        
        Arrays.sort(persons, 0, persons.length);
        
        for (int i = 0; i < persons.length; i++) {
                System.out.println(persons[i].toString());
                }   
            }
        }
       




class Person implements Comparable<Person>{
    String name;
    int age;
    char gender;
    
    public Person(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    @Override
    public String toString(){
        return String.format("%-20s %-10s %-10s",name,String.valueOf(age),String.valueOf(gender));
    }
    
    @Override
    public int compareTo(Person o){
        return this.name.compareTo(o.name);
    }

}
    
