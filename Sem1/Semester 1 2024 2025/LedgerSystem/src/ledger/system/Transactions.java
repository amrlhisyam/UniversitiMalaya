package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton debit, credit, saving, intrestpredict, loan, history, logout;
    String userid;
    String name;

    Transactions(String userid, String name) {
        this.userid = userid;
        this.name = name;
        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/menu.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Title
        JLabel text = new JLabel("Please select your option");
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setBounds(210, 100, 800, 35);
        image.add(text); // Add to image, not the frame

        // Buttons
        debit = new JButton("Debit");
        debit.setFont(new Font("System", Font.BOLD, 25));
        debit.setBounds(170, 250, 250, 70);
        debit.setBackground(Color.WHITE);
        debit.setForeground(Color.BLACK);
        debit.addActionListener(this);
        image.add(debit); // Add to image

        credit = new JButton("Credit");
        credit.setFont(new Font("System", Font.BOLD, 25));
        credit.setBounds(500, 250, 250, 70);
        credit.setBackground(Color.WHITE);
        credit.setForeground(Color.BLACK);
        credit.addActionListener(this);
        image.add(credit); // Add to image

        saving = new JButton("Saving");
        saving.setFont(new Font("System", Font.BOLD, 25));
        saving.setBounds(170, 350, 250, 70);
        saving.setBackground(Color.WHITE);
        saving.setForeground(Color.BLACK);
        saving.addActionListener(this);
        image.add(saving); // Add to image

        intrestpredict = new JButton("Interest Predictor");
        intrestpredict.setFont(new Font("System", Font.BOLD, 25));
        intrestpredict.setBounds(500, 350, 250, 70);
        intrestpredict.setBackground(Color.WHITE);
        intrestpredict.setForeground(Color.BLACK);
        intrestpredict.addActionListener(this);
        image.add(intrestpredict); // Add to image

        loan = new JButton("Credit Loan");
        loan.setFont(new Font("System", Font.BOLD, 25));
        loan.setBounds(170, 450, 250, 70);
        loan.setBackground(Color.WHITE);
        loan.setForeground(Color.BLACK);
        loan.addActionListener(this);
        image.add(loan); // Add to image

        history = new JButton("Trans. History");
        history.setFont(new Font("System", Font.BOLD, 25));
        history.setBounds(500, 450, 250, 70);
        history.setBackground(Color.WHITE);
        history.setForeground(Color.BLACK);
        history.addActionListener(this);
        image.add(history); // Add to image

        logout = new JButton("Log Out");
        logout.setFont(new Font("System", Font.BOLD, 25));
        logout.setBounds(365, 600, 200, 60);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        image.add(logout); // Add to image

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logout) {
            dispose();
            new Login().setVisible(true);
        } else if (ae.getSource() == history) {
            new TransactionHistory(userid).setVisible(true);
        } else if (ae.getSource() == debit) {
            setVisible(false);
            new Debit(userid,name).setVisible(true);
        } else if (ae.getSource() == credit) {
            setVisible(false);
            new Credit(userid,name).setVisible(true);
        } else if (ae.getSource() == intrestpredict) {
            setVisible(false);
            new InterestPredictor(userid,name).setVisible(true);
        } else if (ae.getSource() == loan) {
            new Creditloanwithgui(userid).setVisible(true);
        }
        else if (ae.getSource() == saving){
            setVisible(false);
            Savings savingsApp = new Savings();
            savingsApp.run(userid,name);}
        
    }

    public static void main(String args[]) {
        //new Transactions(userid,name);
    }
}
