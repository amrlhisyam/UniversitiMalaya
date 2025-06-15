/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
public class test {
    public static void main(String[] args) {
        libraryMaterial lm = new libraryMaterial("hisyam","hisyam",true,LocalDate.now());
        DVD dvd =new DVD("amirul dvd", "amirul hisyam", true, LocalDate.now(), 123);
        Magazine mg = new Magazine("magazine", "amirul hisyam", false, LocalDate.now());
        lm.borrow();
        dvd.borrow();
        lm.borrow();
        dvd.borrow();
    }
}

class libraryMaterial{
String title;
String author;
boolean av;
LocalDate date;

    public libraryMaterial(String title, String author, boolean av, LocalDate date) {
        this.title = title;
        this.author = author;
        this.av = av;
        this.date = date;
    }
    
    public void borrow(){
        if (av == true){
            System.out.println("borrowed succesfully");
            System.out.println("please return book by " + date.plusDays(14));
            av = false; 
        }
        else{
            System.out.println("cannot be borrowed");
        }
    }
}

class DVD extends  libraryMaterial{
    int duration;
    public DVD(String title, String author, boolean av, LocalDate date, int duration) {
        super(title, author, av, date);
        this.duration = duration;
    }
    
    @Override
    public void borrow(){
        if (av == true){
            System.out.println("borrowed succesfully");
            System.out.println("please return book by " + date.plusDays(5));
            av = false; 
        }
        else{
            System.out.println("cannot be borrowed");
        }
    }

}

class Magazine extends libraryMaterial{
    
    public Magazine(String title, String author, boolean av, LocalDate date) {
        super(title, author, av, date);
    }
    
    public void borrow(){
        System.out.println("item cannot be borrowed");
        av = false;
    }
}