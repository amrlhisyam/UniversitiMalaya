package lab4;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
    String name;
    int age;
    char gender;
    
    public Person(String name, int age, char gender){
        this.name= name;
        this.age = age;
        this.gender = gender ; 
    }
    
    @Override
    public String toString(){
        return name + " " + age + " " + gender  ; 
    }
    
}
public class q4{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\Hisyam\\Downloads\\Lab07 (1)\\Lab07\\person.dat";
        List<Person> personList = new ArrayList<>();
        
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filepath))){
            
            int totalRecords = inputStream.readInt();
            
            for (int i = 0; i < totalRecords; i++) {
                String name = inputStream.readUTF();
                int age = inputStream.readInt();
                char gender = inputStream.readChar();
                personList.add(new Person(name, age, gender));
            }
            
            Collections.sort(personList, Comparator.comparing(person -> person.name));
            
            for(Person person:personList){
                System.out.println(person);
            }
            
        }catch(IOException e){
            System.out.println("Error with file handling");
        }
    }
}

