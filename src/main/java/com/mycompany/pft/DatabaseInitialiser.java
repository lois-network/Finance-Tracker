package com.mycompany.pft;

import java.sql.*;

/**
 *
 * @author oluwabukunmi
 */
public class DatabaseInitialiser {
    
    public static void initialiser() throws SQLException{
        //decide whether you'll open one connection in the main method and pass i through
        Connection conn = CreateLink.getConnection();
        createTables(conn);
        insertRecord(conn);
        
    }
    
    private static void createTables(Connection conn) throws SQLException{
        
        // initialise the create table statements
        String csql = """
                      CREATE TABLE IF NOT EXISTS Categories(
                      category_id INTEGER PRIMARY KEY ,
                      name VARCHAR
                      );
                      """;
        
        
        String tsql = """
                      CREATE TABLE IF NOT EXISTS Transactions(
                      transaction_id INTEGER PRIMARY KEY ,
                      category_id INTEGER NOT NULL,
                      type VARCHAR,
                      amount NUMERIC NOT NULL,
                      transaction_date DATE,
                      description VARCHAR
                      created_at TIMESTAMP,
                      FOREIGN KEY (category_id) REFERENCES Categories (category_id)
                      );
                      """;
        
        //execute sql statements
        
        /*
        Error in wraping try catch with conn as it automatically closes the 
        connection, rendering the object conn useless for being reused elsewhere
        or being passed into another method. come back and use resources of
        prepared statement instead??
        */
        
        
        try(conn){
            //prepare statements for injection???
            PreparedStatement tstmt = conn.prepareStatement(tsql);
            PreparedStatement cstmt = conn.prepareStatement(csql);
            
            //execute the sql statement
            tstmt.execute();
            cstmt.execute();
            
            System.out.println("Created Category and Transaction table..."); 
        } catch(SQLException e){
            //display potential errors
            System.err.println(e);
        }
    }
    
    private static void insertRecord(Connection conn) throws SQLException{
        String sql = "SELECT COUNT(*) FROM CATEGORIES";
        
        try(conn){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int count = rs.getInt(1);
            
            if(count == 0){
                //create list of category names
                String[] defaultCategories = {"Rent","Food","Transport",
                                              "Salary","Entertainment"};
                for(String name:defaultCategories){
                    String csql = "INSERT INTO categories (name) VALUES(?)";
                    
                    PreparedStatement cstmt = conn.prepareStatement(csql);
                    
                    cstmt.setString(1, name);
                    cstmt.executeUpdate(); 
                }
            }
                   
        }
    }
}
