
 package resturant;

import java.sql.*;
import javax.swing.*;


public class Connect {

  public static Connection connect() {
     
    try {
    Class.forName("org.sqlite.JDBC");
   
    Connection con = DriverManager.getConnection("jdbc:sqlite:Resturant.sqlite");
   // JOptionPane.showMessageDialog(null, "connected");
    return con;
    
    } catch (Exception e) {
    //JOptionPane.showMessageDialog(null, "can't connect to database");
     JOptionPane.showMessageDialog(null,e);
    }
    return null;
    }
     
    public static void main(String[] args) {
    Connect.connect();
     
    }
     
        
}   

