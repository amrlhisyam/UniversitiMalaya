package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, register, clear;
    JTextField EmailTextField;
    JPasswordField PassTextField;
    String userid; // This will hold the retrieved user ID
    String name;   // This will hold the retrieved user name

    Login() {
        setTitle("Ledger System");
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/front.png"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to your Personal Ledger System!");
        text.setFont(new Font("Roven", Font.BOLD, 25));
        text.setBounds(200, 40, 1000, 40);
        add(text);

        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Osward", Font.BOLD, 20));
        Email.setBounds(120, 150, 500, 30);
        add(Email);

        EmailTextField = new JTextField();
        EmailTextField.setBounds(300, 150, 250, 30);
        EmailTextField.setFont(new Font("Aroal", Font.BOLD, 14));
        add(EmailTextField);

        JLabel Password = new JLabel("Password:");
        Password.setFont(new Font("Osward", Font.BOLD, 20));
        Password.setBounds(120, 220, 500, 40);
        add(Password);

        PassTextField = new JPasswordField();
        PassTextField.setBounds(300, 225, 250, 30);
        PassTextField.setFont(new Font("Aroal", Font.BOLD, 14));
        add(PassTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        register = new JButton("REGISTER");
        register.setBounds(300, 350, 230, 30);
        register.setBackground(Color.BLUE);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            EmailTextField.setText("");
            PassTextField.setText("");
        } else if (ae.getSource() == login) {
            ConnMYSQL conn = new ConnMYSQL();
            String email = EmailTextField.getText();
            String password = PassTextField.getText();
            String hashPassword = PasswordUtils.hashPasswordSHA256(password);
            String query = "SELECT u.userid, u.name FROM user u JOIN login l ON u.userid = l.userid WHERE l.email = ? AND l.password = ?";

            try {
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, email);
                pstmt.setString(2, hashPassword);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    userid = rs.getString("userid"); // Retrieve the userid
                    name = rs.getString("name");     // Retrieve the name
                    setVisible(false);
                    
                    //code to update savings after login
                    Savings savings = new Savings();
                    savings.savings_update(userid);
                    
                    Creditloanwithgui loan = new Creditloanwithgui(userid);
                    loan.loanReminder();

                    new Transactions(userid, name).setVisible(true); // Pass userid and name to Transactions
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong email or password, try again");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == register) {
            setVisible(false);
            new Register().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
