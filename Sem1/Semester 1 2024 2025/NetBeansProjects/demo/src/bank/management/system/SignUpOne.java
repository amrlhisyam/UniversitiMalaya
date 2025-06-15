
package bank.management.system;

import javax.swing.*;
import java.awt.* ; 
import java.util.* ; 

public class SignUpOne extends JFrame {
    
    SignUpOne(){
        
        setLayout(null);
        
        Random ran = new Random() ; 
        long random = Math.abs((ran.nextLong() %9000L) + 1000L);
        
        JLabel formno = new JLabel ("APPLICATION FORM NO" + random);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel ("APPLICATION FORM NO" + random);
        personDetails.setFont(new Font("Raleway",Font.BOLD,36));
        personDetails.setBounds(140,20,600,40);
        add(personDetails);
        
        getContentPane().setBackground(Color.white);
        
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true) ;
    }
    
    
    public static void main(String[] args) {
        new SignUpOne() ;
    }
}
