package clinic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectToDB.java
 * Description: Handles the Database connection, updating and querying.
 * Created on September 26, 2007, 10:38 PM
 * Author: Gichamba,Amos.
 *
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

import javax.swing.JOptionPane;

//this class handles all database connections
public class DBConnection {

    static com.mysql.jdbc.Connection connectDB() {
        throw new UnsupportedOperationException("Not yet implemented");
 
    }

    Connection connect=null;
    Statement statement=null;
    ResultSet rs=null;

    /** Creates a new instance of ConnectToDB */
    //initialize the variables in this constructor

    public DBConnection() {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           //connect=DriverManager.getConnection("jdbc:mysql://172.16.0.116:3306/clinic_db","ben","");
           connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db","root","");
//Database URL	jdbc:mysql://172.16.0.116:3306/clinic_db?zeroDateTimeBehavior=convertToNull
           statement=connect.createStatement();
        }
        catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null, cnfe.getMessage(),"ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),"ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }


    }
    //method to update database; use this for all insert, update statements
    public void UpDate(String query)
    {
        try
        {
            statement.executeUpdate(query);
        }

        catch(SQLException sqle)
        {
                JOptionPane.showMessageDialog(null,sqle.getMessage(),"ERROR",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    //method to retrieve records from db;use this for all select statements
    public ResultSet Retrieve(String query)
    {
        try
        {
            rs=statement.executeQuery(query);
        }

        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),"ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }


        return rs;

    }


    //Close the database connection
    public void closeConnection()
    {
        try
        {
            statement.close();
            connect.close();
        }

        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null,error.getMessage(),"Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<product> getData( String Category_id){
        ArrayList<product> list = new ArrayList<product>();
        DBConnection connect= new DBConnection();
        Statement st;
        ResultSet rs;
        
        try {
             st=connect.createStatement();
            rs = st.executeQuery("SELECT `product_id`, `product_name`, `product_quantity`, `catengory_id` , `use` FROM `product` WHERE `catengory_id`=" +Category_id);
            
            product p;
            while(rs.next()){
                p = new product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_quantity"),
                        rs.getString("catengory_id"),
                        rs.getString("use")
                
                );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}

