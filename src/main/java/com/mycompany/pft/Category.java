package com.mycompany.pft;

/**
 *
 * @author oluwabukunmi
 */
public class Category {
    
    //declare instance variables private
    private int category_id;
    private String name;
    
    //declare constructor
    public Category(int id, String name){
        this.category_id = id;
        this.name = name;
    }
    
    //declare mutator and accessor methods.
    public int getCategoryID(){
       return category_id; 
    }
    
    public void setCategoryID(int id){
        this.category_id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }   
}
