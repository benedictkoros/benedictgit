/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Benedict
 */
public class MyQuery2 {
    
        public Connection getConnection(){
     Connection con=null;
             try{   
                 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db","root","");
                //con= DriverManager.getConnection("jdbc:mysql://172.16.0.116:3306/clinic_db","ben","");

            
        } catch(SQLException ex){
         java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }   
             return con;
}
    public ArrayList<search> getData(String FirstName){
        ArrayList<search> list = new ArrayList<search>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
             st=con.createStatement();
            rs = st.executeQuery("SELECT * FROM `student_details` WHERE First Name = '"+FirstName+"'");
           //rs = st.executeQuery("SELECT `Id`, `Name`, `Amount`, `categoryId` FROM `drugs` WHERE `categoryId` = "+ "catID");
           search p;
            while(rs.next()){
                p = new search(
                        rs.getString("Adm_No"),
                        rs.getString("First Name"),
                        rs.getString("Sirname"),
                        rs.getString("Gender"),
                        rs.getString("Date of Birth"),
                        rs.getString("Student Contact"),
                        rs.getString("Preferred Hosp"),
                        rs.getString("Next of Kin Name"),
                        rs.getString("Next of Kin Contact")
                        
                
                );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
