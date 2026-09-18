package com.mycompany.pft;

import java.sql.*;
/**
 *
 * @author oluwabukunmi
 */
public class CategoryDAO {
    
    public static Category[] retrieveAll(Connection conn){
        
        //store size of category array as 0 initially
        int categoryNo =0;
        
        String sql = "SELECT COUNT (*) FROM Categories";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            if(rs.next()){
                categoryNo = rs.getInt(1);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        Category[] categories = new Category[categoryNo];
        String pSql = "SELECT * FROM Categories";
        
        try(PreparedStatement pstmt = conn.prepareStatement(pSql);
            ResultSet prs = pstmt.executeQuery()){
            
            int i=0;
            
            while(prs.next()){
                categories[i] = new Category(
                        prs.getInt("category_id"),
                        prs.getString("name")
                );
                i++;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return categories;
    }
    
    //allows users to add a new transaction category! - optional...
    public void insert(Category newCategory){
        
        
    }
    
}
