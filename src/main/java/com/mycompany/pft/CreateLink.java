package com.mycompany.pft;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author oluwabukunmi
 */
public class CreateLink {
    
    public static Connection getConnection() throws SQLException{
        
        //set connection to null initially
        Connection conn = null;
        
        String url = DB_PROPERTIES.getProperty("db.url");
        
        try{
            conn = DriverManager.getConnection(url);
            
            //connection success message
            System.out.println("Successfully connected to database");
        } catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
