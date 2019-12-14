/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author lamtran
 */
public class NhanVienDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private NhanVien nv;
    private ResultSet rs;
    
    // searh theo ten => lich 
    
    public NhanVienDB() {
        myDB = new MyDB();
    }
    
    public NhanVienDB(NhanVien nv) {
        this.nv = nv;
        myDB = new MyDB();
    }
    
    public NhanVien login(int ma, String mk) {
        NhanVien nv = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM nhanvien WHERE manv ='" + ma + "' AND matkhau ='" + mk + "'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            if (size != 0) {
                nv = new NhanVien(rs.getInt("manv") , rs.getString("ten"), rs.getDate("ngaysinh"), 
                rs.getString("diachi"), rs.getInt("luong"), rs.getString("matkhau"),rs.getInt("status"), rs.getString("chucvu"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }
    
    
    public NhanVien get_by_id(int id) {
        NhanVien nv = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM nhanvien WHERE manv =" + id;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            if (size != 0) {
                nv = new NhanVien(rs.getInt("manv") , rs.getString("ten"), rs.getDate("ngaysinh"), 
                rs.getString("diachi"), rs.getInt("luong"), rs.getString("matkhau"),rs.getInt("status"), rs.getString("chucvu"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }
    
}
