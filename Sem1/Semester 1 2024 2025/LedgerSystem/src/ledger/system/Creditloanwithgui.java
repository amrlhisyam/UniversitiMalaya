package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Creditloanwithgui extends JFrame {

    private double principal;
    private double interestRate;
    private int repaymentPeriod;
    private double totalAmount;
    private double monthlyPayment;
    private double remainingBalance;
    private double monthlyremainingBalance;
    private boolean accountEnabled;
    private double overpayment;
    private boolean hasPaid;
    private Double bank_balance;
    private String userid; // Add userid field

    public Creditloanwithgui(String userid) {
        this.userid = userid; // Initialize userid
        this.hasPaid = false;
        this.accountEnabled = false;

        //get data from database
        try {
            // Connect to MySQL
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c;
            if (connection != null) {
                System.out.println("Database connection successful!"); // tell console connection was successful
                String loan_query = "SELECT userid FROM applying_loan WHERE userid = ?";
                PreparedStatement loanStmt = connection.prepareStatement(loan_query);
                loanStmt.setString(1, userid); // change the ? with userId
                ResultSet rs = loanStmt.executeQuery(); //execute the query and add the result

                if (!rs.next()) { //Loan does not exist
                    //user does not exist
                    accountEnabled = false;

                } else { // loan exists
                    accountEnabled = true;

                    String loan_set = "SELECT * FROM applying_loan WHERE userid = ?";
                    PreparedStatement loan_set_stmt = connection.prepareStatement(loan_set);
                    loan_set_stmt.setString(1, userid); // Set the user_id for the query
                    ResultSet loan_result = loan_set_stmt.executeQuery();
                    loan_result.next();

                    this.principal = loan_result.getDouble("principal");
                    this.interestRate = loan_result.getDouble("interest_rate");
                    this.repaymentPeriod = loan_result.getInt("repayment_period");
                    this.totalAmount = loan_result.getDouble("total_loan");
                    this.monthlyPayment = loan_result.getDouble("monthly_payment");
                    this.remainingBalance = loan_result.getDouble("remaining_balance");
                    this.monthlyremainingBalance = loan_result.getDouble("monthly_remaining_balance");
                    this.hasPaid = loan_result.getBoolean("hasPaid");

                    if (remainingBalance == 0) {
                        accountEnabled = false;
                    }

                }
            }
        } //user exists
        catch (Exception e) {
            System.out.println("Database connection failed."); // tell console connection was not successful
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't establish the connection to the database!", "Database Connection Failed!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Create GUI
        setTitle("Credit Loan System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("CREDIT LOAN", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton applyButton = new JButton("APPLY");
        applyButton.setFont(new Font("Arial", Font.BOLD, 14));
        applyButton.setBackground(Color.BLUE);
        applyButton.setForeground(Color.WHITE);
        applyButton.addActionListener(e -> applyLoan());

        JButton repayButton = new JButton("REPAY");
        repayButton.setFont(new Font("Arial", Font.BOLD, 14));
        repayButton.setBackground(Color.BLUE);
        repayButton.setForeground(Color.WHITE);
        repayButton.addActionListener(e -> repayLoan());

        buttonPanel.add(applyButton);
        buttonPanel.add(repayButton);
        add(buttonPanel, BorderLayout.CENTER);

    }

    private double calculateTotalAmount() {
        return principal * Math.pow(1 + (interestRate / 100), repaymentPeriod);
    }

    private double calculateMonthlyPayment() {
        return totalAmount / (repaymentPeriod * 12);
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private void initializeLoan(double principal, double interestRate, int repaymentPeriod) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.repaymentPeriod = repaymentPeriod;
        this.totalAmount = roundToTwoDecimalPlaces(calculateTotalAmount());
        this.monthlyPayment = roundToTwoDecimalPlaces(calculateMonthlyPayment());
        this.remainingBalance = totalAmount;
        this.accountEnabled = true;
        this.hasPaid = false;

        // Insert loan details into the database
        insertLoanDetails();
    }

    private void insertLoanDetails() {
        try {
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c;

            String update_query_loan = "INSERT INTO applying_loan (userid, principal, interest_rate, repayment_period, total_loan, monthly_payment, remaining_balance, hasPaid) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "principal = VALUES(principal), "
                    + "interest_rate = VALUES(interest_rate), "
                    + "repayment_period = VALUES(repayment_period), "
                    + "total_loan = VALUES(total_loan), "
                    + "monthly_payment = VALUES(monthly_payment), "
                    + "remaining_balance = VALUES(remaining_balance), "
                    + "hasPaid = VALUES(hasPaid)";

            PreparedStatement loan_update = connection.prepareStatement(update_query_loan);
            loan_update.setString(1, userid); // userid
            loan_update.setDouble(2, principal); // principal
            loan_update.setDouble(3, interestRate); // interest_rate
            loan_update.setInt(4, repaymentPeriod); // repayment_period
            loan_update.setDouble(5, totalAmount); // total_loan
            loan_update.setDouble(6, monthlyPayment); // monthly_payment
            loan_update.setDouble(7, remainingBalance); // remaining_balance
            loan_update.setBoolean(8, hasPaid); // hasPaid

            loan_update.executeUpdate(); // Execute the query

            JOptionPane.showMessageDialog(this, "Loan details inserted into the database successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inserting loan details: " + e.getMessage());
        }
    }

    private void makePayment(double payment) {
        payment = roundToTwoDecimalPlaces(payment);

        if (!accountEnabled) {
            JOptionPane.showMessageDialog(this, "Your account is disabled. Please enable your account.");
            return;
        }

        double requiredPayment = Math.max(monthlyPayment - overpayment, 0);

        if (payment < requiredPayment) {
            JOptionPane.showMessageDialog(this, "Warning: Payment is less than the required amount for this month (" + requiredPayment + ").");
            return;
        }
        else if (payment > totalAmount) {
            JOptionPane.showMessageDialog(this, "Warning: Payment is more than the total required amount (" + totalAmount + ").");
            return;
        }
        hasPaid = true;
        overpayment = roundToTwoDecimalPlaces(payment - requiredPayment);
        remainingBalance = roundToTwoDecimalPlaces(remainingBalance - payment);

        if (remainingBalance <= 0) {
            JOptionPane.showMessageDialog(this, "Congratulations! You have fully repaid your loan.");
            remainingBalance = 0;
            overpayment = 0;
            accountEnabled = false;
        }
        try {
            ConnMYSQL conn = new ConnMYSQL();
            Connection connection = conn.c;

            String update_query_loan = "INSERT INTO applying_loan (userid, principal, interest_rate, repayment_period, total_loan, monthly_payment, remaining_balance, hasPaid) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "principal = VALUES(principal), "
                    + "interest_rate = VALUES(interest_rate), "
                    + "repayment_period = VALUES(repayment_period), "
                    + "total_loan = VALUES(total_loan), "
                    + "monthly_payment = VALUES(monthly_payment), "
                    + "remaining_balance = VALUES(remaining_balance), "
                    + "hasPaid = VALUES(hasPaid)";

            PreparedStatement loan_update = connection.prepareStatement(update_query_loan);
            loan_update.setString(1, userid); // userid
            loan_update.setDouble(2, principal); // principal
            loan_update.setDouble(3, interestRate); // interest_rate
            loan_update.setInt(4, repaymentPeriod); // repayment_period
            loan_update.setDouble(5, totalAmount); // total_loan
            loan_update.setDouble(6, monthlyPayment); // monthly_payment
            loan_update.setDouble(7, remainingBalance); // remaining_balance
            loan_update.setBoolean(8, hasPaid); // hasPaid

            loan_update.executeUpdate(); // Execute the query

            //update balance in bank
            String update_query_balance = "INSERT INTO bank (userid, datedata, type, description, amount, balance) "
                    + "VALUES (?, NOW(), 'Loan', 'Subtracted', ?, ?)";

            PreparedStatement balance_update = connection.prepareStatement(update_query_balance);
            balance_update.setString(1, userid); // userid
            balance_update.setDouble(2, -payment);
            balance_update.setDouble(3, bank_balance - payment);
            balance_update.executeUpdate();

            JOptionPane.showMessageDialog(this, "Loan details inserted into the database successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inserting loan details: " + e.getMessage());
        }

    }

    private void applyLoan() {
        if (accountEnabled) {
            JOptionPane.showMessageDialog(null, "An existing loan already exists!", "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            double principal = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter loan amount (principal):"));
            double interestRate = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter annual interest rate (in %):"));
            int repaymentPeriod = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter repayment period (in years):"));
            initializeLoan(principal, interestRate, repaymentPeriod);
            //Add to bank balance
            try {
                // Connect to MySQL
                ConnMYSQL conn = new ConnMYSQL();
                Connection connection = conn.c;
                String bank_query = "SELECT balance FROM bank WHERE userid = ? ORDER BY datedata DESC, balance DESC LIMIT 1";
                PreparedStatement bank_stmt = connection.prepareStatement(bank_query);
                bank_stmt.setString(1, userid); // Set the user_id for the query
                ResultSet bank_result = bank_stmt.executeQuery();

                bank_result.next(); 
                bank_balance = bank_result.getDouble("balance");
                
                bank_balance += principal;
          
               
                String update_query_balance = "INSERT INTO bank (userid, datedata, type, description, amount, balance) "
                    + "VALUES (?, NOW(), 'Loan', 'Added', ?, ?)";

            PreparedStatement balance_update = connection.prepareStatement(update_query_balance);
            balance_update.setString(1, userid); // userid
            balance_update.setDouble(2, principal);
            balance_update.setDouble(3, bank_balance);
            balance_update.executeUpdate();
            
               
            } catch (Exception e) {
                System.out.println("Database connection failed."); // tell console connection was not successful
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Couldn't establish the connection to the database!", "Database Connection Failed!", JOptionPane.WARNING_MESSAGE);
                return;}
            
            showLoanDetails();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
        }
    }

    private void repayLoan() {
    if (!accountEnabled) {
        JOptionPane.showMessageDialog(this, "No active loan. Please apply first.");
        return;
    }
    if (hasPaid) {
        JOptionPane.showMessageDialog(this, "Remaining Balance: " + remainingBalance
                + "\nYou've already paid this month!");

        int response = JOptionPane.showConfirmDialog(this,
                "Do you want to pay extra?",
                "Pay Extra",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.NO_OPTION) {
            return;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Remaining Balance: " + remainingBalance
                + "\nMonthly Payment: " + monthlyPayment);
    }

    try {
        String input = JOptionPane.showInputDialog(this, "Enter payment amount:");
        if (input != null && !input.trim().isEmpty()) { // Check for null or empty input
            double payment = Double.parseDouble(input);
            // Fetch the balance from the bank table
            try {
                // Connect to MySQL
                ConnMYSQL conn = new ConnMYSQL();
                Connection connection = conn.c;
                String bank_query = "SELECT balance FROM bank WHERE userid = ? ORDER BY datedata DESC, balance DESC LIMIT 1";
                PreparedStatement bank_stmt = connection.prepareStatement(bank_query);
                bank_stmt.setString(1, userid); // Set the user_id for the query
                ResultSet bank_result = bank_stmt.executeQuery();

                if (bank_result.next()) {
                    bank_balance = bank_result.getDouble("balance");
                } else {
                    JOptionPane.showMessageDialog(this, "You have no balance at all!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Database connection failed."); // tell console connection was not successful
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Couldn't establish the connection to the database!", "Database Connection Failed!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (payment <= bank_balance) {
                makePayment(payment);
            } else {
                JOptionPane.showMessageDialog(this, "Not enough balance!" + "\nCurrent total balance = " + bank_balance );
            }
        } else {
            JOptionPane.showMessageDialog(this, "No payment entered.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
    }
}


    private void showLoanDetails() {
        JOptionPane.showMessageDialog(this, "Loan Details:\nPrincipal: " + principal
                + "\nInterest Rate: " + interestRate + "%\nRepayment Period: " + repaymentPeriod + " years\nTotal Amount: " + totalAmount
                + "\nMonthly Payment: " + monthlyPayment);
    }

    public void loanReminder() {
        Calendar calendar = Calendar.getInstance();

        int current_day = Calendar.DAY_OF_MONTH;
        int last_day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (last_day - current_day <= 7 && last_day - current_day >= 0 && remainingBalance > 0 && hasPaid == false) {
            JOptionPane.showMessageDialog(null, "Your total remainning loan balance is " + totalAmount + " and your payment for this month is " + monthlyPayment, "Loan Reminder", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    public static void main(String[] args) {
        //new Creditloanwithgui(""); 
    }

}
