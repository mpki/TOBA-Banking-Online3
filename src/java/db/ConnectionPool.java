/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Matt
 */
public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool()
    {
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDataSource");
        } catch (NamingException e)
        {
            System.out.println(e);
        }
    }
    
    public static synchronized ConnectionPool getInstance() {
        if (pool == null)
        {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    public Connection getConnection()
    {
        try
        {
         String dbURL = "jdbc:mysql://localhost:3306/toba";
         String username = "root";
         String password = "sesame";
         Connection connection = DriverManager.getConnection(dbURL, username, password);
         
         return connection;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void freeConnection(Connection c)
    {
        try
        {
            c.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    
}
