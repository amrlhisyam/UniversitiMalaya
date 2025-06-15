/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ledger.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author nitrom
 */
public class SavingsNotExist extends Savings_Menu {
    
   
        SavingsNotExist(String user_id, String name){
         super(user_id,name);
         
   
        //top right panel
        JLabel question = new JLabel(
                "<html>\n"
                + "  <div style='text-align: center;'>\n"
                + "    <span style='font-size: 24px; font-weight: bold;'>No savings account found.</span>\n"
                + "    <br>\n"
                + "    <span style='font-size: 18px;'>Would you like to create one now?</span>\n"
                + "  </div>\n"
                + "</html>");
        question.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        question.setForeground(Color.WHITE);
        question.setBounds(200, 10, 400, 400);
        right_top.add(question);
        right_top.setPreferredSize(new Dimension(800, 350));
        right_top.setBackground(new Color(46, 90, 109));
        
        // bottom right panel
        but1.setBounds(265, 100, 125, 50); 
        but1.addActionListener(this);
        but1.setText("Yes");

        but2.setBounds(410, 100, 125, 50);
        but2.addActionListener(this);
        but2.setText("No");
        
        right_bottom.add(but1);
        right_bottom.add(but2);
        right_bottom.setPreferredSize(new Dimension(800, 350));
        right_bottom.setBackground(new Color(46, 90, 109));
        
        // final addition
        this.add(left_Panel, BorderLayout.WEST);
        this.add(right_Panel, BorderLayout.EAST);
       
        this.setVisible(true); //set that frame to be visible
        
        
        }
}

    


