package FileInputOutput;
import java.io.*;
import java.util.Arrays;
public class L7Q5{
    public static void main(String[] args) {
        String fileName = "person.dat";
        Person [] persons = new Person[100];
        int t = -1;
        try{
            ObjectInputStream input = 
                    new ObjectInputStream(new FileInputStream(fileName));
            t = input.readInt();
            persons = new Person[t];
            try {
                while (true) {                    
                    for (int i = 0; i < t; i++) {
                        String name = input.readUTF();
                        int age = input.readInt();
                        char gender = input.readChar();
                        persons[i] = new Person(name, age, gender);
                    }
                }
            } catch (EOFException e) {}
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
        catch (IOException e) {
            System.out.println("Error with file input.");
        }
        Arrays.sort(persons);
        for(int i=0;i<t;i++){
            System.out.println(persons[i].toString());
        }
    }
    
}