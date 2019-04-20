package clinic;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benedict
 */
import java.sql.DriverManager;
import java.sql.Connection;
public class myConnection {
    public static Connection getConnection()
    {
        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db","root","");
          // con=DriverManager.getConnection("jdbc:mysql://172.16.0.116:3306/clinic_db","ben","");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
    
}
