package clinic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pet
 */
class product {
    private int id;
    private String name,amount,category_id,use;
    
    public product(int Id,String Name,String Amount,String categoryid,String Use){
        this.id=Id;
        this.name=Name;
        this.amount=Amount;
        this.category_id=categoryid;
        this.use=Use;
    }
    public int getproduct_id(){
        return  id;
    }
    public void setProduct_Id(int Product_Id){
        this.id= Product_Id;
    
}
    public String getproduct_name(){
        return name;
    }
    public void setProduct_Name(String Product_Name){
        this.name= Product_Name;
        
    }
    public String getproduct_quantity(){
        return amount;
    }
     public void setProduct_Quantity(String Product_Quantity){
        this.name= Product_Quantity;
        
    }
    public String getcategory_id(){
        return category_id;
    }
     public void setCategory_Id(String Category_Id){
        this.name= Category_Id;
}
     public String getuse(){
         return use;
     }
     public void setUse(String Use){
         this.name=Use;
     }
}