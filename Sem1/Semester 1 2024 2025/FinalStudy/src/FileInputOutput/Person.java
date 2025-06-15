/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileInputOutput;

    public class Person implements Comparable<Person>{
        String name;
        int age;
        char gender;

        public Person(String name, int age, char gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age)*-1;
        }
        
        @Override
        public String toString(){
            String str = String.format("""
                                       %-15s%-5d%-1s
                                       """, this.name,this.age,this.gender);
            return str;
        }
    }
