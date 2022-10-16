package model;

import java.sql.*;


 public class DBHandler {
    
   Connection con ;
    public  DBHandler(){
             
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://student.veleri.hr:3306/bcarevic"
                    ,"bcarevic", "GEEIIM");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
       
    }
    
     public Connection spajanje(){
        
         return con;
    }
}
