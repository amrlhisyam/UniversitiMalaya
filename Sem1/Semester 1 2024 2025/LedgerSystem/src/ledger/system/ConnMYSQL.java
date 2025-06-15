/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ledger.system;

import java.sql.*;

public class ConnMYSQL {
    
    Connection c;
    Statement s;
    public ConnMYSQL() {
        try { 
            c = DriverManager.getConnection("jdbc:mysql:///ledgersystem", "root", "Hisyam_185");
            s = c.createStatement();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
  
}
