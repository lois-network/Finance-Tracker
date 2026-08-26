package com.mycompany.pft;

import java.sql.*;

/**
 *
 * @author oluwabukunmi
 */
public class DatabaseInitialiser {
    
    public void initialiser() throws SQLException{
        //decide whether you'll open one connection in the main method and pass i through
        Connection conn = CreateLink.getConnection();
        createTables(conn);
        
    }
    
    private void createTables(Connection conn) throws SQLException{
        
        // initialise the create table statements
        String csql = """
                      CREATE TABLE IF NOT EXISTS Categories(
                      category_id INTEGER AUTO-INCREMENT PRIMARY KEY ,
                      name VARCHAR
                      );
                      """;
        
        
        String tsql = """
                      CREATE TABLE IF NOT EXISTS Transactions(
                      transaction_id INTEGER AUTO-INCREMENT PRIMARY KEY ,
                      category_id INTEGER NOT NULL,
                      type VARCHAR,
                      amount NUMERIC NOT NULL,
                      transaction_date DATE,
                      description VARCHAR
                      created_at TIMESTAMP,
                      FOREIGN KEY category_id REFERENCES Categories (category_id)
                      );
                      """;
        
        //execute sql statements
        
        try(conn){
            //prepare statements for injection???
            Statement tstmt = conn.prepareStatement(tsql);
            Statement cstmt = conn.prepareStatement(csql);
            
            //execute the sql statement
            tstmt.execute(tsql);
            cstmt.execute(csql);
            
            System.out.println("Created Category and Transaction table..."); 
        } catch(SQLException e){
            //display potential errors
            System.err.println(e);
        }
    }
    
    private void insertRecord(){
        
        
    
    }
    
    
    
 
}
