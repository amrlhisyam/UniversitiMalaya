/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ledger.system;

/**
 *
 * @author Aliff
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Register extends JFrame implements ActionListener{
     
    long random;
    JTextField nameTextField, emailTextField, passTextField, confirmPassTextField;
    JButton proceed;
    JRadioButton male, female;
    
    Register() {
        
        setLayout(null);
        
        Random r = new Random();
        random = Math.abs((r.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("REGISTRATION");
        formno.setFont(new Font("Arial", Font.BOLD, 40));
        formno.setBounds(250, 20, 600, 40);
        add(formno);
        
        JLabel details = new JLabel("Please Fill in The Form");
        details.setFont(new Font("Arial", Font.ITALIC, 25));
        details.setBounds(265, 80, 2000, 40);
        add(details);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 23));
        name.setBounds(100, 200, 100, 40);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 13));
        nameTextField.setBounds(300, 200, 400, 40);
        add(nameTextField);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 23));
        email.setBounds(100, 250, 100, 40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 13));
        emailTextField.setBounds(300, 250, 400, 40);
        add(emailTextField);
        
        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.BOLD, 23));
        password.setBounds(100, 300, 200, 40);
        add(password);
        
        passTextField = new JPasswordField();
        passTextField.setFont(new Font("Arial", Font.BOLD, 13));
        passTextField.setBounds(300, 300, 400, 40);
        add(passTextField);
        
        JLabel confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("Arial", Font.BOLD, 20));
        confirmPassword.setBounds(100, 350, 200, 40);
        add(confirmPassword);

        confirmPassTextField = new JPasswordField();
        confirmPassTextField.setFont(new Font("Arial", Font.BOLD, 13));
        confirmPassTextField.setBounds(300, 350, 400, 40);
        add(confirmPassTextField);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 23));
        gender.setBounds(100, 400, 100, 40);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 400, 60, 40);
        male.setBackground(Color.cyan);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 400, 80, 40);
        female.setBackground(Color.pink);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        proceed = new JButton("Proceed");
        proceed.setBackground(Color.WHITE);
        proceed.setForeground(Color.BLACK);
        proceed.setFont(new Font("Aroal", Font.BOLD, 14));
        proceed.setBounds(600, 560, 100, 30);
        proceed.addActionListener(this);
        add(proceed);
                
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String userid = "" + random;
        String name = nameTextField.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String password = passTextField.getText();
        String confirmPassword = confirmPassTextField.getText();
        String hashPassword;
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your name");
            }
            else if(!name.matches("^[a-zA-Z0-9 ]+$")){
                JOptionPane.showMessageDialog(null, "Name must be alphanumeric and should not contain special characters.");
            }        
            else if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                JOptionPane.showMessageDialog(null, "Please enter a valid email address (e.g., name@example.com).");
            }       
            else if(password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()].*")){
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and include uppercase, lowercase, a number, and a special character.");
            }
            else if(!password.equals(confirmPassword)){
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
            }
            else {
                hashPassword = PasswordUtils.hashPasswordSHA256(password);
                ConnMYSQL c = new ConnMYSQL();
                String query = "insert into user values('"+userid+"', '"+name+"', '"+email+"', '"+hashPassword+"', '"+gender+"')";
                String query2 = "insert into login values('"+userid+"', '"+email+"', '"+hashPassword+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                setVisible(false);
                new Debit(userid,name);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
    public static void main(String [] args){
        new Register();
    }
}
