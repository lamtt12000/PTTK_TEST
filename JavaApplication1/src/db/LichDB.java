/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lich;
import java.sql.Date;  
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author lamtran
 */
public class LichDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private Lich l;
    private ResultSet rs;
    public LichDB(Lich l) {
        this.l = l;
        myDB = new MyDB();
    }
    
    
    public int insert() throws SQLException{
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "INSERT INTO lich(sdt_kh, ngay, status, manv) VALUES(?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,l.getSdtkhachhang());
            ps.setDate(2,l.getNgay());
            ps.setInt(3, l.getStatus());
            ps.setInt(4, l.getMaNV());
            ps.executeUpdate();
            kt = 10000;
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt;
    }
    
    public int update() throws SQLException{
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sqlcheck = "Select * from lich WHERE mal = " + l.getMaL();
            rs = con.prepareStatement(sqlcheck).executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            System.out.println(size);
            if (size != 0) {
                String sql = "UPDATE lich SET sdt_kh = ?, ngay = ?, status = ?, manv = ?"
                    + " WHERE mal = ?";
                ps=con.prepareStatement(sql);
                ps.setString(1,l.getSdtkhachhang());
                ps.setDate(2,l.getNgay());
                ps.setInt(3, l.getStatus());
                ps.setInt(4, l.getMaNV());
                ps.setInt(5, l.getMaL());
                ps.executeUpdate();
                System.out.println(ps);
                kt = 10000;
            }else{
                kt = 10001; //id not exist in table
            }      
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt; 
    }
    
    
    
    public List<Lich> get_all(){
        List<Lich> list_l = new ArrayList<Lich>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Lich la = new Lich(rs.getInt("mal"), rs.getDate("ngay"), 
                rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public Lich get_by_id(int mal) {
        Lich la = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich WHERE mal = " + mal;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            if (size != 0) {
                la = new Lich(rs.getInt("mal"), rs.getDate("ngay"),
                    rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
    public List<Lich> get_by_status(int status) {
        List<Lich> list_l = new ArrayList<Lich>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich WHERE status = " + status;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Lich la = new Lich(rs.getInt("mal"), rs.getDate("ngay"),
                    rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    
    public static void main(String[] args) {
        String str="2019-03-24";
        Date date=Date.valueOf(str);
        Lich l = new Lich(2, date, "037686566999", 1, 1);
        LichDB ldb = new LichDB(l);
        System.out.println(ldb.get_by_id(1));
        System.out.println(ldb.get_by_status(2));
    }
            
    
    
}
