package ledger.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Credit extends JFrame implements ActionListener {

    JTextField amount, description;
    JButton withdraw, back;
    String userid;
    String name;

    Credit(String userid,String name) {
        this.userid = userid;
        this.name = name;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/menu.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please enter amount to withdraw"); // Changed label text
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setBounds(165, 100, 800, 35);
        image.add(text);

        JLabel rm = new JLabel("RM ");
        rm.setFont(new Font("System", Font.BOLD, 30));
        rm.setBounds(191, 200, 800, 35);
        image.add(rm);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 20));
        amount.setBounds(246, 200, 500, 35);
        image.add(amount);

        JLabel desc = new JLabel("Description");
        desc.setFont(new Font("System", Font.BOLD, 30));
        desc.setBounds(191, 250, 800, 35);
        image.add(desc);

        description = new JTextField();
        description.setFont(new Font("System", Font.BOLD, 20));
        description.setBounds(193, 290, 555, 35);
        image.add(description);

        withdraw = new JButton("Withdraw"); // Renamed button
        withdraw.setBounds(595, 350, 150, 35);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(595, 400, 150, 35);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 500);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String amountStr = amount.getText();
            String descp = description.getText();
            if (amountStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the amount you want to withdraw", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double amountValue = Double.parseDouble(amountStr);

                ConnMYSQL c = new ConnMYSQL();

                // Fetch current balance
                String balanceQuery = """
                              SELECT * FROM bank 
                              WHERE userid = ? 
                              ORDER BY datedata DESC 
                              LIMIT 1;""";
                PreparedStatement pstmtBalance = c.c.prepareStatement(balanceQuery);
                pstmtBalance.setString(1, userid);
                ResultSet rs = pstmtBalance.executeQuery();

                double currentBalance = 0.0;
                if (rs.next()) {
                    currentBalance = rs.getDouble("balance");
                }
                rs.close();

                // Check for sufficient balance
                if (currentBalance < amountValue) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance for withdrawal.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "INSERT INTO bank (userid, datedata, type, description, amount, balance) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, userid); // Added userid

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                pstmt.setString(2, dateFormat.format(new Date()));

                pstmt.setString(3, "Withdrawal");
                pstmt.setString(4, descp);
                pstmt.setDouble(5, -amountValue); // Use negative value for withdrawal
                pstmt.setDouble(6, currentBalance - amountValue);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "RM " + amountValue + " withdrawn Successfully!");
                    setVisible(false);
                    new Transactions(userid,name).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Withdrawal failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(userid,name).setVisible(true);
        }
    }

    public static void main(String args[]) {
        //new Credit("");
    }
}