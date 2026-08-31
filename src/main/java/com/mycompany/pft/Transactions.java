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
    
    
    
}
