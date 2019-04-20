package clinic;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benedict
 */
//inser student to database
public class Student {
    public void insertUpdateDeliteStudent(char operation, Integer id,String admno,String fname,String lname,String sex,String 
                                          dateofbirth,String phoneno,String address,String gurname,String gurno)
    { 
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='i')
       {
           try {
               ps=con.prepareStatement("INSERT INTO student_details( `Adm_No`,`First Name`,`Sirname`,`Date of Birth`,`Gender`,`Student Contact`,`Preferred Hosp`,`Next of Kin Name`,`Next of Kin Contact`)VALUES(?,?,?,?,?,?,?,?,?)");
               ps.setString(1, admno);
               ps.setString(2, fname);
               ps.setString(3, lname);
               ps.setString(5, dateofbirth);
               ps.setString(4, sex);
               ps.setString(6, phoneno);
               ps.setString(7, address);
               ps.setString(8, gurname);
               ps.setString(9, gurno);
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"New Student Added");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(operation=='u')//for update
       {
           try {
               ps=con.prepareStatement("UPDATE `student_details` SET `Adm_No`= ?,`First Name`= ?,`Sirname`= ?,`Date of Birth`= ?,`Gender`= ?,`Student Contact`= ?,`Preferred Hosp`= ?,`Next of Kin Name`= ?,`Next of Kin Contact`= ? WHERE `Id`= ?");
               ps.setString(1, admno);
               ps.setString(2, fname);
               ps.setString(3, lname);
               ps.setString(4, dateofbirth);
               ps.setString(5, sex);
               ps.setString(6, phoneno);
               ps.setString(7, address);
               ps.setString(8, gurname);
               ps.setString(9, gurno);
               ps.setInt(10, id);
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Student Record Updated");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     
       if(operation=='r')//for removing
       {
           try {
               ps=con.prepareStatement("DELETE FROM `student_details` WHERE `Id`= ?"); 
               ps.setInt(1, id);
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Student Record Deleted");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        if(operation=='p')//for removing start
       {
           try {
               ps=con.prepareStatement("DELETE FROM `start` WHERE `ID`= ?"); 
               ps.setInt(1, id);
               
              if(ps.executeUpdate()>0){
                 // JOptionPane.showMessageDialog(null,"Student Record Deleted");
              }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        if(operation=='f')//for removing staff treatment redcord start
       {
           try {
               ps=con.prepareStatement("DELETE FROM `staff_treat` WHERE `IDNumber`= ?"); 
               ps.setInt(1, id);
               
              if(ps.executeUpdate()>0){
                 // JOptionPane.showMessageDialog(null,"Student Record Deleted");
              }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(operation=='d')//for removing staff
       {
           try {
               ps=con.prepareStatement("DELETE FROM `staff_details` WHERE `ID`= ?"); 
               ps.setInt(1, id);
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Staff Record Deleted");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
      public void insertTreat(char operation,String admno,String fname,String lname,String test,String disese,String 
                                          comment,String date)
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='i')
       {
           try {
               ps=con.prepareStatement("INSERT INTO start( AdmNo, FirstName, LastName, Test,disease,Comment,date)VALUES(?,?,?,?,?,?,?)");
               ps.setString(1, admno);
               ps.setString(2, fname);
               ps.setString(3, lname);
               ps.setString(4, test);
               ps.setString(5, disese);
               ps.setString(6, comment);
               ps.setString(7, date);
              
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Treatment saved. Now procced to issue medication");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
       public void insertTreatStaff(char operation,String admno,String fname,String lname,String test,String 
                                          comment,String disease,String date)
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='i')
       {
           try {
               ps=con.prepareStatement("INSERT INTO staff_treat(IDNumber, FirstName, LastName, LabTest,Comments,Disease,date)VALUES(?,?,?,?,?,?,?)");
               ps.setString(1, admno);
               ps.setString(2, fname);
               ps.setString(3, lname);
               ps.setString(4, test);
               ps.setString(5, comment);
               ps.setString(6, disease);
               ps.setString(7, date);
              
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Treatment saved. Now procced to issue medication");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
    
        public void insertStaff(char operation,Integer id, String fname,String lname,String gender,String  
                                          idnun ,String cont)
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='i')
       {
           try {
               ps=con.prepareStatement("INSERT INTO staff_details(`First Name`, `Last Name`, `Gender`, `ID No`, `Contract No`)VALUES(?,?,?,?,?)");
               ps.setString(1, fname);
               ps.setString(2, lname);
               ps.setString(3, gender);
               ps.setString(4, idnun);
               ps.setString(5, cont);
              
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Staff added");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
         if(operation=='s')//for update staff
       {
           try {
               ps=con.prepareStatement("UPDATE `staff_details` SET `First Name`= ?,`Last Name`= ?,`Gender`= ?,`ID No`= ?,`Contract No`= ? WHERE `ID`= ?");
               ps.setString(1, fname);
               ps.setString(2, lname);
               ps.setString(3, gender);
               ps.setString(4, idnun);
               ps.setString(5, cont);
               ps.setInt(6, id);
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"Student Record Updated");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    } 
     //Insert to inventory
       public void insertToInventory(char operation,String name,String amount,String gategoryid 
                                          )
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='d')
       {
           try {
               ps=con.prepareStatement("INSERT INTO drugs( Name, Amount, categoryId)VALUES(?,?,?)");
               ps.setString(1, name);
               ps.setString(2, amount);
               ps.setString(3, gategoryid);
               //ps.setString(4, test);
              // ps.setString(5, comment);
              
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"New Drug Added");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
        public void insertTocategory(char operation,String name
                                          )
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='m')
       {
           try {
               ps=con.prepareStatement("INSERT INTO category( Name)VALUES(?)");
               ps.setString(1, name);
               //ps.setString(2, amount);
              // ps.setString(3, gategoryid);
               //ps.setString(4, test);
              // ps.setString(5, comment);
              
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"New Category Added");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
     public void insertTojtable3(char operation,String id,String name,String amount,String gategoryid 
                                          )
    {
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       //i for insertion
       if(operation=='q')
       {
           try {
               ps=con.prepareStatement("INSERT INTO drugs( Id,Name, Amount, categoryId)VALUES(?,?,?,?)");
               ps.setString(1, id);
               ps.setString(2, name);
               ps.setString(3, amount);
               ps.setString(4, gategoryid);
               //ps.setString(4, test);
              // ps.setString(5, comment);
              
                
               
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"New Drug Added");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
    }
    public void fillStudentJTable(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `student_details` WHERE CONCAT(`Adm_No`,`First Name`,`Sirname`,`Date of Birth`,`Gender`,`Student Contact`,`Preferred Hosp`,`Next of Kin Name`,`Next of Kin Contact`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[10];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
                row[7]=rs.getString(8);
                row[8]=rs.getString(9);
                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void filltablesearch(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;    
        try {
            ps=con.prepareStatement("SELECT * FROM `student_details` WHERE CONCAT(`Adm_No`,`First Name`,`Sirname`,`Date of Birth`,`Gender`,`Student Contact`,`Preferred Hosp`,`Next of Kin Name`,`Next of Kin Contact`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[10];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
                row[7]=rs.getString(8);
                row[8]=rs.getString(9);
                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fillStaffJTable(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `staff_details` WHERE CONCAT( `First Name`, `Last Name`, `Gender`, `ID No`, `Contract No`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[6];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
//                row[6]=rs.getString(7);
//                row[7]=rs.getString(8);
//                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fillTret(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `student_details` WHERE CONCAT(`Adm_No`,`First Name`,`Sirname`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[4];
                row[0]=rs.getString(2);
                row[1]=rs.getString(3);
                row[2]=rs.getString(4);
//                row[3]=rs.getString(4);
//                row[4]=rs.getString(5);
//                row[5]=rs.getString(6);
//                row[6]=rs.getString(7);
//                row[7]=rs.getString(8);
//                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public void fillTretStaff(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `staff_details` WHERE CONCAT(`ID No`,`First Name`,`Last Name`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[4];
                row[0]=rs.getString(5);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
//                row[3]=rs.getString(4);
//                row[4]=rs.getString(5);
//                row[5]=rs.getString(6);
//                row[6]=rs.getString(7);
//                row[7]=rs.getString(8);
//                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            public void filllessin(JTable table,String ValueToSearch)
                    //inventory waring
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `drugs` WHERE `Amount`<3 and CONCAT(`Name`,`Amount`,`categoryId`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[4];
                row[0]=rs.getString(2);
                row[1]=rs.getString(3);
                row[2]=rs.getString(4);
//                row[3]=rs.getString(4);
//                row[4]=rs.getString(5);
//                row[5]=rs.getString(6);
//                row[6]=rs.getString(7);
//                row[7]=rs.getString(8);
//                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void fillPreviousTret(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `medication` WHERE CONCAT(`AdmNo`, `First_Name`, `Last_Name`, `Test_Type`, `Comment`, `Drugs_Issued`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[9];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
                row[7]=rs.getString(8);
                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void fillPreviousTrets(JTable table,String ValueToSearch)
    {
     Connection con=myConnection.getConnection();
     PreparedStatement ps;
        try {
            ps=con.prepareStatement("SELECT * FROM `staffmedication` WHERE CONCAT(`IDNumber`, `FirstName`, `LastName`, `Test`, `Comment`, `Drugs`)LIKE ?");
            ps.setString(1, "%"+ValueToSearch+"%");
            
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row=new Object[8];
                row[0]=rs.getString(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getString(6);
                row[6]=rs.getString(7);
               row[7]=rs.getString(8);
//                row[8]=rs.getString(9);
//                row[9]=rs.getString(10);
                
                model.addRow(row);
                
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void UpdateDrugs(char operation, Integer id,String Name,String Amount,String categoryId ,String use)
    { 
       Connection con=myConnection.getConnection();
       PreparedStatement ps;
       if(operation=='z')//for update
       {
           try {
               ps=con.prepareStatement("UPDATE `drugs` SET `Name`= ?,`Amount`= ?,`categoryId`= ? ,`used`= ?  WHERE `Id`= ?");
               ps.setString(1, Name);
               ps.setString(2, Amount);
               ps.setString(3, categoryId);
               ps.setString(4, use);
              // ps.setString(5, dat);
               ps.setInt(5, id);
              
               if(ps.executeUpdate()>0){
                   JOptionPane.showMessageDialog(null,"drug issued successful");
               }
           } catch (SQLException ex) {
               Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
           }
       }     
     
    }
          
}
