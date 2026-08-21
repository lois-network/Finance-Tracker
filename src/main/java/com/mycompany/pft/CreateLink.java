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
    
    private static final Properties db_properties = loadProperties();
    
    private static Properties loadProperties(){
        
        Properties prop = new Properties();
        try(InputStream input = CreateLink.class.getClassLoader().getResourceAsStream("db.properties")){
            
            if(input==null){
                System.err.println("db.properties is not found");
            }else{
            prop.load(input);
            }
            
        } catch(IOException e){
            System.err.println("Failed to load db properties: " + e);
        }
        return prop;
    }
    
    public static Connection getConnection() throws SQLException{
        
        //set connection to null initially
        Connection conn = null;
        //retrieve the db url from file
        String url = db_properties.getProperty("db.url");
        
        try{
            conn = DriverManager.getConnection(url);
            
            //connection success message
            System.out.println("Successfully connected to database");
        } catch(SQLException e){
            System.err.println(e);
        }
        return conn;
    }
    
}
