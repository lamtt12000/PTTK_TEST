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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author lamtran
 */
public class KhachHangDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private KhachHang kh;
    private ResultSet rs;
    
    // searh theo ten => lich 
    
    public KhachHangDB() {
        myDB = new MyDB();
    }
    
    public KhachHangDB(KhachHang l) {
        this.kh = l;
        myDB = new MyDB();
    }
    
    public int insert() throws SQLException{
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "INSERT INTO khachhang(sodt, email, ten, diachi) VALUES(?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, kh.getSodt());
            ps.setString(2, kh.getEmail());
            ps.setString(3, kh.getTen());
            ps.setString(4, kh.getDiachi());
            ps.executeUpdate();
            kt = 10000;
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt;
    }
    
    public List<KhachHang> get_all(){
        List<KhachHang> list_l = new ArrayList<KhachHang>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM khachhang";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                KhachHang la = new KhachHang(rs.getInt("makh") ,rs.getString("ten"), rs.getString("sodt"), 
                rs.getString("email"), rs.getString("diachi"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public List<KhachHang> get_by_name(String name){
        List<KhachHang> list_l = new ArrayList<KhachHang>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM khachhang WHERE ten LIKE '%" + name + "%'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("sodt"));
                KhachHang la = new KhachHang(rs.getInt("makh") ,rs.getString("ten"), rs.getString("sodt"), 
                rs.getString("email"), rs.getString("diachi"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public KhachHang get_by_id(int makh) {
        KhachHang la = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM khachhang WHERE makh = " + makh;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            if (size != 0) {
                la = new KhachHang(rs.getInt("makh") , rs.getString("ten"), rs.getString("sodt"), 
                rs.getString("email"), rs.getString("diachi"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
    
    public static void main(String[] args) throws SQLException {
        KhachHang k = new KhachHang( 1, "KH A", "01223123", "akh@gmail.com", "Ha noi");
        KhachHangDB kdb = new KhachHangDB(k);
//        kdb.insert();
        KhachHang k1 = kdb.get_by_id(1);
        System.out.println(k1.getEmail());
    }
}
