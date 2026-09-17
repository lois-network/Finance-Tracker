package com.mycompany.pft;
import java.sql.*;

/**
 *
 * @author oluwabukunmi
 */
public class TransactionDAO {
    
    public static Transaction[] retrieveAll(){
        return null;
    }
    
    public static Transaction retrieveById(int id){
        return null;
    }
    public int insert(Transaction t,Connection conn){
        String sql = "INSERT INTO  Transactions (category_id,type,amount,"
                + "transaction_date,description VALUES (?,?,?,?,?)";
        
        int key=-1; //failure catch
        try(PreparedStatement stmt= conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)){
            
            //insert into object t
            stmt.setInt(1,t.getCategoryID());
            stmt.setString(2, t.getType());
            stmt.setDouble(3, t.getAmount());
            stmt.setObject(4,t.getDate());
            stmt.setString(5, t.getDescription());
            
            //execute insert statement
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            
            if(keys.next()){
                 key = keys.getInt(1);
            }
            
        }catch(SQLException e){
            System.err.println(e);
            
        }
      return key;
    }
    
    public void delete(int id,Connection conn){
        String sql = "DELETE FROM Transactions WHERE transaction_id =?";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            int rowsAffected = stmt.executeUpdate();
            
        }catch(SQLException e){
            System.err.println(e);
        }
        
    }
    
    public void update(){
        
    }
    
    
}
