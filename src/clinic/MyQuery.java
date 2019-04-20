   package clinic;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raj
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
public class MyQuery {
    public Connection getConnection(){
     Connection con=null;
             try{   
               // con= DriverManager.getConnection("jdbc:mysql://172.16.0.116:3306/clinic_db","ben","");
                  con= DriverManager.getConnection("jdbc:mysql://localhost/clinic_db","root","");
            
        } catch(SQLException ex){
         java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }   
             return con;
}
    public ArrayList<product> getData(String categoryId){
        ArrayList<product> list = new ArrayList<product>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
             st=con.createStatement();
            rs = st.executeQuery("SELECT * FROM `drugs` WHERE `categoryId`='"+categoryId+"'");
          //  rs = st.executeQuery("SELECT `Id`, `Name`, `Amount`, `categoryId` FROM `drugs` WHERE `categoryId` = "+ "catID");
            product p;
            while(rs.next()){
                p = new product(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Amount"),
                        rs.getString("categoryId"),
                        rs.getString("Used")
                );
                list.add(p);
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
