
package com.mycompany.pft;

/**
 *
 * @author oluwabukunmi
 */
public class Balance {
    public BalanceSummary calculate(Transaction[] transactions){
        
        //
        double totalIncome =0;
        double totalExpense =0;
        
        for(int i =0; i<transactions.length; i++){
            if(transactions[i].getType().equalsIgnoreCase("income")){
                totalIncome = totalIncome + transactions[i].getAmount();
                
            }else if(transactions[i].getType().equalsIgnoreCase("expense")){
                totalExpense = totalExpense + transactions[i].getAmount();
            }
            //add errorline here...
        }
        
        double balance  = totalIncome-totalExpense;
        
        BalanceSummary summary = new BalanceSummary(totalIncome,totalExpense,
                balance);

        return summary;
    }
    
}
