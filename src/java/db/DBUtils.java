/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matt
 */
public class DBUtils {
    
    
    
    public static void main(String[] args)
    {
     
       System.out.println("Initializing Database"); 
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Found");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not Found: "+ex);
        }
        
        String url = "jdbc:mysql://localhost:3306/toba?zeroDateTimeBehavior=convertToNull";
        
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(url, "root", "sesame");
            System.out.println("Connection Established");
        } catch (SQLException ex) {
            System.out.println("Could not Connect to Database: "+ex);
        }
        
    }
    
    
}
