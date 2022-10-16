/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojaaplikacija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matej
 */
public class MyConnection {
    
    Connection con;
    public MyConnection(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Matej/Desktop/mydb.accdb;memory=true");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
         Connection connectionMaker(){
        return con;
    }
    
}
