
package com.mycompany.pft;

/**
 *
 * @author oluwabukunmi
 */

//class to group all the calculated values together
public class BalanceSummary {
    private double totalIncome;
    private double totalExpense;
    private double balance;
    
    public BalanceSummary(double totalIncome,double totalExpense, double balance){
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }
    
    //mutator and accessor methods below
    
    //income
    public double getIncome(){
        return totalIncome;
    }
    
    public void setIncome(double income){
        this.totalIncome = income;  
    }
    
    //expenses
    public double getExpense(){
        return totalExpense;
    }
    
    public void setExpense(double expense){
        this.totalExpense = expense;
    }
    
    //balance
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
}
