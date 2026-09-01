package com.mycompany.pft;

import java.time.LocalDate;
/**
 *
 * @author oluwabukunmi
 */
public class Transactions {
    //declare instance variables private
    private int transaction_id;
    private int category_id;
    private String type;
    private double amount;
    private LocalDate transaction_date; //check data type
    private String description;
    
    //declare constuctor
    public Transactions(int transactionid, int categoryid,String type, 
            double amount, LocalDate date,String description){
        
        this.transaction_id = transactionid;
        this.category_id = categoryid;
        this.type = type;
        this.amount = amount;
        this.transaction_date = date;
        this.description = description;
        
    }
    
    //declare mutator and accessor methods below. - complete next commit
    public int getTransactionID(){
        return transaction_id;
    }
    
    public void setTransactionID(int id){
        this.transaction_id= id;
    }
    
    public int getCategoryID(){
       return category_id; 
    }
    
    public void setCategoryID(int id){
        this.category_id = id;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public void setAmount(double amount){
        this.amount= amount;
    }
    
    public LocalDate getDate(){
        return transaction_date;
    }
    
    public void setDate(LocalDate date){
        this.transaction_date = date;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String desc){
        this.description = desc;  
    }  
}
