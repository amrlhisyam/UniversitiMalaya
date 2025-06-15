package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InterestPredictor extends JFrame implements ActionListener {
    
    JLabel Amount, InterestOccurence, banks, otherBank, interest, finalOutput, resetLabel;
    JTextField AmountTextField, otherBankTextField, interestTextField;
    JComboBox<String> chooseBanks, chooseOccurence ;
    JRadioButton amountBalance, amountOther;
    JButton confirm, reset, back;
    ButtonGroup group;
    String amountText, interestText, selectedBanks, selectedOccurence;
    
    int y;
    Double r = null, output = null, amount = null;
    
    String[] occurenceOptions = {"Select Occurence","Annually", "Monthly", "Daily"};
    String[] bankOptions = {"Select Bank","RHB", "Maybank", "Alliance", "AmBank", "Standard Chartered", "None of the listed"};
    
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Font textFieldFont = new Font("Arial", Font.PLAIN, 15);
    String userid;
    String name;

    
    public InterestPredictor(String userid, String name) {
        this.name = name;
        this.userid = userid;
        setLayout(null);

        
        setTitle("DEPOSIT INTEREST PREDICTOR");
        
        Amount = new JLabel("Amount:");
        Amount.setFont(labelFont);
        Amount.setBounds(140, 140, 200, 30);
        add(Amount);

        amountBalance = new JRadioButton("Balance");
        amountBalance.setBounds(340, 140, 100, 30);
        amountBalance.setFont(textFieldFont);
        add(amountBalance);

        amountOther = new JRadioButton("Others");
        amountOther.setBounds(490, 140, 100, 30);
        amountOther.setFont(textFieldFont);
        add(amountOther);

        group = new ButtonGroup();
        group.add(amountBalance);
        group.add(amountOther);

        InterestOccurence = new JLabel("Interest Occurence:");
        InterestOccurence.setFont(labelFont);
        InterestOccurence.setBounds(140, 240, 200, 30);
        add(InterestOccurence);

        chooseOccurence = new JComboBox<>(occurenceOptions);
        chooseOccurence.setBounds(340, 240, 200, 30);
        chooseOccurence.setFont(textFieldFont);
        add(chooseOccurence);

        banks = new JLabel("Banks:");
        banks.setFont(labelFont);
        banks.setBounds(140, 340, 200, 30);
        add(banks);

        chooseBanks = new JComboBox<>(bankOptions);
        chooseBanks.setBounds(340, 340, 200, 30);
        chooseBanks.setFont(textFieldFont);
        add(chooseBanks);

        confirm = new JButton("Confirm");
        confirm.setBounds(340, 540, 150, 30);
        confirm.setFont(labelFont);
        add(confirm);
        
        back = new JButton("Back");
        back.setBounds(340, 640, 150, 30);
        back.setFont(labelFont);
        add(back);
        
        resetLabel = new JLabel("Clear");
        resetLabel.setBounds(600,600,50,30);
        resetLabel.setFont(labelFont);
        add(resetLabel);
        
        reset = new JButton();
        reset.setBounds(650, 600, 30, 30);
        add(reset);
        
        amountBalance.addActionListener(this);
        amountOther.addActionListener(this);
        chooseOccurence.addActionListener(this);
        chooseBanks.addActionListener(this);
        confirm.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == amountOther && AmountTextField == null) {
            handleOtherAmount();
        }
    if (e.getSource() == amountBalance) {
    ConnMYSQL conn = new ConnMYSQL();

    
    try {
        String balanceQuery = """
                              SELECT * FROM bank 
                              WHERE userid = ? 
                              ORDER BY datedata DESC 
                              LIMIT 1;""";
        PreparedStatement balancePstmt = conn.c.prepareStatement(balanceQuery);
        balancePstmt.setString(1, userid); // Set the userid parameter
        ResultSet balanceRs = balancePstmt.executeQuery();
        
        if (balanceRs.next()) {
            amount = balanceRs.getDouble("balance"); // Retrieve the balance
            JOptionPane.showMessageDialog(this, "Your balance is: RM " + amount);
        } else {
            JOptionPane.showMessageDialog(this, "No balance found for this user.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error retrieving balance: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (conn.c != null) conn.c.close(); // Close the connection
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
        if (e.getSource() == amountBalance && AmountTextField != null) {
            handleRemoveTextField();
        }
        if (e.getSource() == chooseOccurence) {
            handleOccurence();
        }
        if (e.getSource() == chooseBanks) {
            handleBanks();
        }
        if (e.getSource() == confirm) {
            handleConfirm();
        }
        if(e.getSource() == reset){
            handleReset();
        }
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(userid,name).setVisible(true);
        }
    }
    
    private void removeOutput(){
        if (finalOutput != null){
            remove(finalOutput);
            finalOutput = null;
            revalidate();
            repaint();
            }
        }

    private void removeOtherBankFields() {
        if (otherBank != null) {
            remove(otherBank);
            otherBank = null;
        }
        if (otherBankTextField != null) {
            remove(otherBankTextField);
            otherBankTextField = null;
        }
        if (interest != null) {
            remove(interest);
            interest = null;
        }
        if (interestTextField != null) {
            remove(interestTextField);
            interestTextField = null;
        }
        revalidate();
        repaint();
    }
    
    public double interestAmount(double amount, double interest, int period){

    double interestRate = interest/100 ; 
    double totalAmount;
    totalAmount = (amount*interestRate) / period;
    return totalAmount ; 
}
    
    public static String returnType(int y) {
        String output;
        switch (y) {
            case 1:
                output = "Interest earn in a year: ";
                break;
            case 12:
                output = "Interest earn in a month: ";
                break;
            default:
                output = "Interest earn in a day: ";
                break;
        }
        return output ; 
    }
    
        private void handleOtherAmount(){
        AmountTextField = new JTextField();
        AmountTextField.setBounds(490, 190, 100, 30);
        AmountTextField.setFont(textFieldFont);
        add(AmountTextField);
        revalidate();
        repaint();
    }
        private void handleRemoveTextField(){
            remove(AmountTextField);
            AmountTextField = null;
            revalidate();
            repaint();
        }
        
        private void handleOccurence(){
            selectedOccurence =(String) chooseOccurence.getSelectedItem();
            if (selectedOccurence.equals(occurenceOptions[1])) {
                y = 1; // Annually
            } else if (selectedOccurence.equals(occurenceOptions[2])) {
                y = 12; // Monthly
            } else if (selectedOccurence.equals(occurenceOptions[3])) {
                y = 365; // Daily
            }
        }
        private void handleBanks(){
            selectedBanks = (String) chooseBanks.getSelectedItem();
            if (selectedBanks.equals(bankOptions[bankOptions.length - 1])) {
                if (otherBank == null && otherBankTextField == null) {
                    otherBank = new JLabel("Bank:");
                    otherBank.setBounds(140, 390, 200, 30);
                    otherBank.setFont(labelFont);
                    add(otherBank);

                    otherBankTextField = new JTextField();
                    otherBankTextField.setBounds(340, 390, 200, 30);
                    otherBankTextField.setFont(textFieldFont);
                    add(otherBankTextField);

                    interest = new JLabel("Interest rate[%]:");
                    interest.setBounds(140, 440, 200, 30);
                    interest.setFont(labelFont);
                    add(interest);

                    interestTextField = new JTextField();
                    interestTextField.setBounds(340, 440, 200, 30);
                    interestTextField.setFont(textFieldFont);
                    add(interestTextField);
                    
                    revalidate();
                    repaint();
                }
            } else {
                switch (selectedBanks) {
                    case "RHB":
                        r = 2.6;
                        break;
                    case "Maybank":
                        r = 2.5;
                        break;
                    case "Alliance":
                        r = 2.3;
                        break;
                    case "AmBank":
                        r = 2.85;
                        break;
                    case "Standard Chartered":
                        r = 2.55;
                        break;
                }
                removeOtherBankFields();
            }
        }
    
        private boolean isNegative(double x){
            return x<0 ; 
        }
        
        private void handleConfirm(){
             removeOutput();
            
            if (AmountTextField != null) {
                try {
                    amountText = AmountTextField.getText();
                    amount = Double.valueOf(amountText);
                    if(isNegative(amount)){
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
            }

            if (interestTextField != null) {
                try {
                    interestText = interestTextField.getText();
                    r = Double.valueOf(interestText);
                    if(isNegative(r)){
                        JOptionPane.showMessageDialog(null, "Please enter a valid interest rate.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid interest rate.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
            }

            if (selectedOccurence == null || selectedOccurence.equals(occurenceOptions[0])){
                JOptionPane.showMessageDialog(null,"Please select Occurence","Input error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (selectedBanks == null || selectedBanks.equals(bankOptions[0])){
                JOptionPane.showMessageDialog(null,"Please select Bank","Input error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (amount == null || r == null) {
                JOptionPane.showMessageDialog(null, "Please ensure both amount and interest rate are provided.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            else {
                output = interestAmount(amount, r, y);
                StringBuilder str = new StringBuilder();
                str.append(returnType(y));
                str.append("RM ");
                str.append(String.format("%.2f", output));

                finalOutput = new JLabel(str.toString());
                finalOutput.setBounds(140,490,300,30);
                finalOutput.setFont(labelFont);
                add(finalOutput);
                
                revalidate();
                repaint();
            }
        }
        
        private void handleReset(){
            if (AmountTextField != null){
                AmountTextField.setText("");
            }
            
            if(interestTextField != null){
                interestTextField.setText("");
            }
            
            chooseOccurence.setSelectedIndex(0);
            chooseBanks.setSelectedIndex(0);
            group.clearSelection();
            
            if (AmountTextField != null && AmountTextField.getParent() != null){
                remove(AmountTextField);
                AmountTextField = null ;
            }
            
            if (interestTextField != null && interestTextField.getParent() != null){
                remove(interestTextField);
                interestTextField = null ;
            }
            removeOtherBankFields();
            removeOutput();
            
            revalidate();
            repaint();
        }

    public static void main(String[] args) {
       // new InterestPredictor("");
    }
}