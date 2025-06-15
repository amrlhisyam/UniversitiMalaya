/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut8;

/**
 *
 * @author Hisyam
 */
public class Student {
    
    private String contactNumber;
    
    public Student(){
        contactNumber = null;
    }
    
    public Student (String c){
        contactNumber = c;
    }
    
    public String getContactNumber(){
        return contactNumber ;
    }
    
    public void setContactNumber(String c){
        this.contactNumber = c ;
    }
    
    public void displayContactNumber(){
        System.out.println("Contact Number: "+contactNumber);
    }
    
    
}
