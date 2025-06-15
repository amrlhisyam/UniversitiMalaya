package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.awt.event.*;

public class TransactionHistory extends JFrame {

    String userid;
    private JTextArea mini; // Declare mini as an instance variable

    TransactionHistory(String userid) {
        this.userid = userid;
        setTitle("Transaction History");

        setLayout(new BorderLayout());

        // Create a panel for the upper section (User ID, Balance, and Export Button)
        JPanel northPanel = new JPanel(new BorderLayout());

        // User ID Label
        JLabel userLabel = new JLabel("User ID: " + userid);
        northPanel.add(userLabel, BorderLayout.WEST);

        // Current Account Balance Label
        JLabel balanceLabel = new JLabel("Balance: Fetching...");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(balanceLabel, BorderLayout.CENTER);

        // Export Button
        JButton exportButton = new JButton("Export to CSV");
        exportButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save CSV File");
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    if (!filePath.endsWith(".csv")) {
                        selectedFile = new File(filePath + ".csv");
                    }

                    try (FileWriter writer = new FileWriter(selectedFile)) {
                        writer.write("Date,Type,Description,Amount\n" + mini.getText());
                        JOptionPane.showMessageDialog(this, "Data exported successfully!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        northPanel.add(exportButton, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);

        mini = new JTextArea(); // Initialize the instance variable
        mini.setEditable(false);
        add(new JScrollPane(mini), BorderLayout.CENTER);

        JLabel balance = new JLabel();

        // Create a panel for filters, sorting, and balance
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel filterPanel = new JPanel(new GridLayout(3, 3, 5, 5));

        // Date Range Filter
        JLabel fromDateLabel = new JLabel("From Date (YYYY-MM-DD):");
        JTextField fromDateField = new JTextField();
        JLabel toDateLabel = new JLabel("To Date (YYYY-MM-DD):");
        JTextField toDateField = new JTextField();

        // Transaction Type Filter
        JLabel typeLabel = new JLabel("Transaction Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"All", "Deposit", "Withdrawal"});

        // Amount Range Filter
        JLabel minAmountLabel = new JLabel("Minimum Amount:");
        JTextField minAmountField = new JTextField();
        JLabel maxAmountLabel = new JLabel("Maximum Amount:");
        JTextField maxAmountField = new JTextField();

        filterPanel.add(fromDateLabel);
        filterPanel.add(fromDateField);
        filterPanel.add(toDateLabel);
        filterPanel.add(toDateField);
        filterPanel.add(typeLabel);
        filterPanel.add(typeComboBox);
        filterPanel.add(minAmountLabel);
        filterPanel.add(minAmountField);
        filterPanel.add(maxAmountLabel);
        filterPanel.add(maxAmountField);

        southPanel.add(filterPanel, BorderLayout.NORTH);

        // Sorting Options
        JPanel sortingPanel = new JPanel();
        JLabel sortLabel = new JLabel("Sort By:");
        JComboBox<String> sortComboBox = new JComboBox<>(new String[]{"Date (Ascending)", "Date (Descending)", "Amount (Ascending)", "Amount (Descending)"});
        sortingPanel.add(sortLabel);
        sortingPanel.add(sortComboBox);

        southPanel.add(sortingPanel, BorderLayout.CENTER);

        JButton filterButton = new JButton("Apply Filters and Sort");
        filterButton.addActionListener(e -> fetchAndDisplayTransactions(mini, balanceLabel, fromDateField, toDateField, typeComboBox, minAmountField, maxAmountField, sortComboBox));
        southPanel.add(filterButton, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);

        // Fetch and Display Transactions
        fetchAndDisplayTransactions(mini, balanceLabel, fromDateField, toDateField, typeComboBox, minAmountField, maxAmountField, sortComboBox);
        fetchAndDisplayBalance(balanceLabel);

        setSize(800, 600);
        setLocation(100, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private void fetchAndDisplayTransactions(JTextArea mini, JLabel balanceLabel, JTextField fromDateField, JTextField toDateField, JComboBox<String> typeComboBox, JTextField minAmountField, JTextField maxAmountField, JComboBox<String> sortComboBox) {
        mini.setText("");

        try {
            ConnMYSQL conn = new ConnMYSQL();

            String query = "SELECT * FROM bank WHERE userid = ?";
            String fromDate = fromDateField.getText().trim();
            String toDate = toDateField.getText().trim();
            String type = typeComboBox.getSelectedItem().toString();
            String minAmount = minAmountField.getText().trim();
            String maxAmount = maxAmountField.getText().trim();

            // Add filters to query
            if (!fromDate.isEmpty() || !toDate.isEmpty()) {
                query += " AND datedata BETWEEN ? AND ?";
            }
            if (!type.equals("All")) {
                query += " AND type = ?";
            }
            if (!minAmount.isEmpty()) {
                query += " AND amount >= ?";
            }
            if (!maxAmount.isEmpty()) {
                query += " AND amount <= ?";
            }

            // Add sorting to query
            String sortOption = sortComboBox.getSelectedItem().toString();
            switch (sortOption) {
                case "Date (Ascending)":
                    query += " ORDER BY datedata ASC";
                    break;
                case "Date (Descending)":
                    query += " ORDER BY datedata DESC";
                    break;
                case "Amount (Ascending)":
                    query += " ORDER BY amount ASC";
                    break;
                case "Amount (Descending)":
                    query += " ORDER BY amount DESC";
                    break;
            }

            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, userid);

            int paramIndex = 2;
            if (!fromDate.isEmpty() || !toDate.isEmpty()) {
                pstmt.setString(paramIndex++, fromDate.isEmpty() ? "1900-01-01" : fromDate);
                pstmt.setString(paramIndex++, toDate.isEmpty() ? "2100-12-31" : toDate);
            }
            if (!type.equals("All")) {
                pstmt.setString(paramIndex++, type);
            }
            if (!minAmount.isEmpty()) {
                pstmt.setDouble(paramIndex++, Double.parseDouble(minAmount));
            }
            if (!maxAmount.isEmpty()) {
                pstmt.setDouble(paramIndex++, Double.parseDouble(maxAmount));
            }

            ResultSet rs = pstmt.executeQuery();

            mini.append("Date\t\tType\t\tDescription\t\tAmount\n");
            while (rs.next()) {
                String date = rs.getString("datedata");
                String transType = rs.getString("type");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");

                mini.append(date + "\t" + transType + "\t\t" + description + "\t\t" + String.format("%.2f", amount) + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fetchAndDisplayBalance(JLabel balanceLabel) {
        try {
            ConnMYSQL conn = new ConnMYSQL();

            String balanceQuery = """
                              SELECT * FROM bank 
                              WHERE userid = ? 
                              ORDER BY datedata DESC 
                              LIMIT 1;""";
            PreparedStatement pstmt = conn.c.prepareStatement(balanceQuery);
            pstmt.setString(1, userid);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                balanceLabel.setText("Balance: " + String.format("%.2f", balance));
            } else {
                balanceLabel.setText("Balance: No transactions found");
            }

        } catch (SQLException e) {
            balanceLabel.setText("Balance: Error fetching data");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with a valid user ID
        //new TransactionHistory("valid_user_id", name); // Use a valid user ID here 
    }
}