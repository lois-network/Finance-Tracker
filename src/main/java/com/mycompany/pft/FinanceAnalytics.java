
package com.mycompany.pft;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author oluwabukunmi
 */
public class FinanceAnalytics {
    
    public Map<String,Double> calculate(Transaction[] transactions,Category[] categories){
        
        //
        Map<Integer,String> c = new HashMap<>();
        
        //iterate throu caategories and assign to hasmap
        for(Category category:categories){
            c.put(category.getCategoryID(), category.getName());
        }
        
        Map<String,Double> calc = new HashMap<>();
        
        //iterate through all the transactions
        for( Transaction transaction:transactions){
            
            //check the type of transaction
            if(transaction.getType().equals("expense")){
                
                String categoryName = c.get(transaction.getCategoryID());
                
                if(c.containsKey(categoryName)){
                    double currentTotal ;
                    
                    
                    
                }else{
                    
                }
                
            }
        }
    
        //initialise the map to hold the expense made and its equivalent
        
        //iterate through the map and initialise it with values
        return null;
    }
    
}
