/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ledger.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.PreparedStatement;

/**
 *
 * @author nitrom
 */
public class Savings_Menu extends JFrame implements ActionListener {

    MainButton but1 = new MainButton();
    MainButton but2 = new MainButton();
    JPanel right_bottom = new JPanel();
    JPanel right_top = new JPanel();
    JPanel right_Panel = new JPanel();
    JPanel left_Panel = new JPanel();
    protected String user_id;
    protected String name;

    Savings_Menu(String user_id, String name) {
        this.user_id = user_id;
        this.name = name;
        ImageIcon savings_iconOri = new ImageIcon(getClass().getResource("/icons/file.png"));
        ImageIcon savings_icon = resize(savings_iconOri, 0.5);
        Color background_colour = new Color(24, 25, 28);

        this.setTitle("Savings"); //title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the this on exit
        this.setResizable(true); // prevent or allow the frame from being resized
        this.setLayout(new BorderLayout());
        this.setSize(1600, 700);
        this.getContentPane().setBackground(background_colour);

        //Logo and title
        JLabel label_icon = new JLabel();
        label_icon.setText("Savings"); // Set text of label
        label_icon.setIcon(savings_icon);
        label_icon.setHorizontalTextPosition(JLabel.CENTER);
        label_icon.setVerticalTextPosition(JLabel.BOTTOM);
        label_icon.setForeground(Color.WHITE); //set font colour
        label_icon.setFont(new Font("Segoe UI", Font.BOLD, 20)); //set font
        label_icon.setIconTextGap(-100);
        label_icon.setBounds(100, 50, 800, 800);

        // set label alignment
        label_icon.setVerticalAlignment(JLabel.TOP);
        label_icon.setHorizontalAlignment(JLabel.CENTER);

        //Declaration and layout
        JPanel left_top = new JPanel();
        JPanel left_bottom = new JPanel();

        this.left_Panel.setLayout(new BorderLayout());
        left_bottom.setLayout(new BorderLayout());
        this.right_bottom.setLayout(null);
        this.right_top.setLayout(null);
        this.right_Panel.setLayout(new BorderLayout());

        //top left panel
        left_top.setBackground(background_colour);
        left_top.setPreferredSize(new Dimension(400, 450));

        // bottom left panel
        JLabel welcome_user = new JLabel();
        welcome_user.setText("Welcome " + name + "!");
        welcome_user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        welcome_user.setForeground(Color.WHITE);
        welcome_user.setHorizontalAlignment(JLabel.CENTER);

        left_bottom.add(welcome_user, BorderLayout.NORTH);
        left_bottom.setBackground(background_colour);
        left_bottom.setPreferredSize(new Dimension(400, 200));

        //left panel
        left_Panel.setPreferredSize(new Dimension(800, 800));
        left_Panel.setBackground(background_colour);
        left_top.add(label_icon);
        left_Panel.add(left_top, BorderLayout.NORTH);
        left_Panel.add(left_bottom, BorderLayout.SOUTH);

        // right panel
        this.right_Panel.add(right_bottom, BorderLayout.SOUTH);
        this.right_Panel.add(right_top, BorderLayout.NORTH);

    }

    public class MainButton extends JButton {

        MainButton() {
            this.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            this.setFocusable(false);
            this.setBackground(Color.WHITE);
        }
    }

    private static ImageIcon resize(ImageIcon imageIcon, double scale) {
        int oldWidth = imageIcon.getIconWidth();
        int oldHeight = imageIcon.getIconHeight();
        int newWidth = (int) (oldWidth * scale);
        int newHeight = (int) (oldHeight * scale);

        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(imageIcon.getImage(), 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return new ImageIcon(bi);
    } // method to resize icons«

    @Override
    public void actionPerformed(ActionEvent e) {
        String percentage_answer = "Waiting For Input";

        if (e.getSource() == but1) {
            do {
                percentage_answer = JOptionPane.showInputDialog("Please enter your percentage.");
                percentage_answer = percentage_answer.trim();

                if (isValidPercentage(percentage_answer)) {
                    try {
                        // Test connection
                        ConnMYSQL conn = new ConnMYSQL();
                        Connection connection = conn.c; // Use the connection from ConnMYSQL
                        if (connection != null) {
                            System.out.println("Database connection successful!");
                            String acc_update = "INSERT INTO Savings (percentage, user_id)\n"
                                    + "VALUES (?, ?)\n"
                                    + "ON DUPLICATE KEY UPDATE percentage = VALUES(percentage)";
                            double percentage = Double.parseDouble(percentage_answer);
                            PreparedStatement prepared_acc_update = connection.prepareStatement(acc_update);
                            prepared_acc_update.setDouble(1, percentage);
                            prepared_acc_update.setString(2, user_id);
                            prepared_acc_update.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Succesfully added!", "Info!", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        System.out.println("Database connection failed.");
                        JOptionPane.showMessageDialog(null, "Database connection failed!", "Warning!", JOptionPane.WARNING_MESSAGE);
                        ex.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid percentage! Try again.", "Warning!", JOptionPane.WARNING_MESSAGE);
                }

            } while (isValidPercentage(percentage_answer) == false);
            this.dispose();
            new SavingsExist(user_id, name);

        } else if (e.getSource() == but2) {
            this.dispose();
            Savings savings = new Savings();
            savings.savings_update(user_id);
            new Transactions(user_id,name);
        }
    }

    private boolean isValidPercentage(String str) {
        try {
            Savings.percentage = Float.parseFloat(str);
            return Savings.percentage >= 0 && Savings.percentage <= 100;
        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }

}
