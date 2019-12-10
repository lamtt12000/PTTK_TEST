/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadestopbanhang.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class MyDB {
        private final String className = "com.mysql.jdbc.Driver";
        private final String url =  "jdbc:mysql://localhost:3306/sys";
        private final String user = "root";
        private final String pass = "1997";
 
       private final String table = "user_qlbh";
        private Connection con;
       public Connection getConnect() throws SQLException{
            try {
                Class.forName(className);
                con=DriverManager.getConnection(url,user,pass);
            } catch (ClassNotFoundException ex) {
                System.out.println("Lỗi kết nối ");
                ex.printStackTrace();
            }
           
           return con;
       }
      
}
