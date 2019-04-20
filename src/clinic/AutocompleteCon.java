/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import static org.eclipse.persistence.exceptions.JAXBException.classNotFoundException;

/**
 *
 * @author Benedict
 */
public class AutocompleteCon {
    public AutocompleteCon(){}
    Connection con;
    
    public void panginDriver(){
        try{
            String driver="con.mysql.jdbc.Driver";
            Class.forName(driver);
            System.out.println("connected");          
        }catch(ClassNotFoundException cnfe){            
            System.out.println("error" +cnfe);
        }
    }
    public Connection clinic_db()throws SQLException{
        Connection konex=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/clinic_db","root","");
            String url="jdbc:mysql://172.16.0.116:3306/clinic_db";
            String user="ben";
            String passw="";
            konex=DriverManager.getConnection(url, user, passw);
            
        }catch(SQLException e){
           System.out.println("failed" +e); 
        
    }
        return konex;
    }
}  
