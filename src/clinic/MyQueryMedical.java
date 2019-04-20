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
public class MyQueryMedical {
    
        public Connection getConnection(){
     Connection con=null;
             try{   
                // con= DriverManager.getConnection("jdbc:mysql://172.16.0.116:3306/clinic_db","ben","");
                 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db","root","");
            
        } catch(SQLException ex){
         java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }   
             return con;
}
    public ArrayList<medical> getData(String AdmNo){
        ArrayList<medical> list = new ArrayList<medical>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
             st=con.createStatement();
            rs = st.executeQuery("SELECT * FROM `medication` WHERE `AdmNo`='"+AdmNo+"'");
           //rs = st.executeQuery("SELECT `Id`, `Name`, `Amount`, `categoryId` FROM `drugs` WHERE `categoryId` = "+ "catID");
            medical p;
            while(rs.next()){
                p = new medical(
                        rs.getString("AdmNo"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Test_Type"),
                        rs.getString("Disease"),
                        rs.getString("Comment"),
                        rs.getString("Drugs_Issued"),
                        
                        rs.getString("Date")
                
                );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //staff medication previous part
    public ArrayList<medicals> getData2(String AdmNo){
        ArrayList<medicals> list = new ArrayList<medicals>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
             st=con.createStatement();
            rs = st.executeQuery("SELECT * FROM `staffmedication` WHERE `IDNumber`='"+AdmNo+"'");
           //rs = st.executeQuery("SELECT `Id`, `Name`, `Amount`, `categoryId` FROM `drugs` WHERE `categoryId` = "+ "catID");
            medicals p;
            while(rs.next()){
                p = new medicals(
                        rs.getString("IDNumber"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Test"),
                        rs.getString("Comment"),
                        rs.getString("Drugs"),
                        rs.getString("Disease"),
                        
                        rs.getString("date")
                
                );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
