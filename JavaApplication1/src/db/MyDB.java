/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author lamtran
 */
public class MyDB {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url =  "jdbc:mysql://localhost:3306/spa";
    private final String user = "root";
    private final String pass = "";

    private Connection con;
    public Connection openConnect() throws SQLException{
        try {
            Class.forName(className);
            con=(Connection) DriverManager.getConnection(url,user,pass);
//            System.out.println("Connect success");

        } catch (ClassNotFoundException ex) {
            System.out.println("Connect failed");
            ex.printStackTrace();
        }
        
       return con;
    }
    
    public void closeConnect() throws SQLException {
        con.close();
    }
    
}
