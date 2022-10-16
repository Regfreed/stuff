/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mansarda.gradnja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matej
 */
public class Mansarda {
    
    
    Connection con;
    public Mansarda(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
        
            con = DriverManager.getConnection("jdbc:mysql://localhost/mansarda-gradnja?serverTimezone=UTC", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Mansarda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
         Connection connectionMaker(){
        return con;
    }
    
}
