/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DichVu;
import model.HoaDon;

/**
 *
 * @author lamtran
 */
public class HoaDonDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private HoaDon hd;
    private ResultSet rs;

    public HoaDonDB() {
        this.myDB = new MyDB();
    }
    
    public HoaDonDB(HoaDon hd) {
        this.hd = hd;
        this.myDB = new MyDB();

    }
    
    public int insert() throws SQLException{
        int kt = 10002;
        con = myDB.openConnect();
        try {
            
            String sql = "INSERT INTO hoadon(manv, mal, status) VALUES(?, ?, ?)";
            ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hd.getMaNV());
            ps.setInt(2, hd.getMaL());
            ps.setInt(3, hd.getStatus());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                kt=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt;
    }
    
    public int delete(int id) throws SQLException {
        int kt = 10002;
        con = myDB.openConnect();
        try {
           
            String sql = "DELETE FROM hoadon WHERE mahd=" + id;
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            kt = 10000;
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt;
    }
}
