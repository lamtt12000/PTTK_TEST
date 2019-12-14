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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.HoaDonDVNL;

/**
 *
 * @author lamtran
 */
public class HoaDonDVNLDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private HoaDonDVNL hddvnl;
    private ResultSet rs;

    public HoaDonDVNLDB() {
        this.myDB = new MyDB();
    }
    
    public HoaDonDVNLDB(HoaDonDVNL hd) {
        this.hddvnl = hd;
        this.myDB = new MyDB();
    }
    
    public int insert() throws SQLException{
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "INSERT INTO hoadon_dichvu_nguyenlieu(mahd, madvnl, manvpv, soluong, dongia_hientai, type) VALUES(?, ?, ?, ?, ?, ?)";
            ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hddvnl.getMaHD());
            ps.setInt(2, hddvnl.getMaDVNL());
            ps.setInt(3, hddvnl.getMaNVPV());
            ps.setInt(4, hddvnl.getSoluong());
            ps.setInt(5, hddvnl.getDongiahientai());
            ps.setInt(6, hddvnl.getType());
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
    
    
    public int delete_by_id(int id) throws SQLException {
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "DELETE FROM hoadon_dichvu_nguyenlieu WHERE mahddvnl=" + id;
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
    
    public int delete_by_mahd(int id) throws SQLException {
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "DELETE FROM hoadon_dichvu_nguyenlieu WHERE mahd=" + id;
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
    
    
    public List<HoaDonDVNL> get_by_id_hd(int id_hd) {
        List<HoaDonDVNL> list_l = new ArrayList<HoaDonDVNL>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM hoadon_dichvu_nguyenlieu WHERE  mahd=" + id_hd;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonDVNL la = new HoaDonDVNL(rs.getInt("mahddvnl"), rs.getInt("mahd"),
                        rs.getInt("madvnl"), rs.getInt("manvpv"), rs.getInt("soluong"), rs.getInt("dongia_hientai"),
                        rs.getInt("type"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public List<HoaDonDVNL> get_dv_by_id_hd(int id_hd, boolean isShowAll) {
        List<HoaDonDVNL> list_l = new ArrayList<HoaDonDVNL>();
        String strManv = "";
        if (!isShowAll) {
            strManv =  " AND manvpv=0";
        } 
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM hoadon_dichvu_nguyenlieu WHERE  mahd=" 
                    + id_hd + " AND type=0" + strManv;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonDVNL la = new HoaDonDVNL(rs.getInt("mahddvnl"), rs.getInt("mahd"),
                    rs.getInt("madvnl"), rs.getInt("manvpv"), rs.getInt("soluong"), rs.getInt("dongia_hientai"),
                    rs.getInt("type"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public boolean update_idNV (int id_nv, int mahddvnl) {
        boolean kt = false;
        try {
            con = myDB.openConnect();
            String sql = "UPDATE hoadon_dichvu_nguyenlieu SET manvpv =" + id_nv
                    + " WHERE mahddvnl=" + mahddvnl;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            kt = true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDVNLDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return kt;
        }
    }
    
    public static void main(String[] args) {
        HoaDonDVNLDB h = new HoaDonDVNLDB();
//        for(HoaDonDVNL hd : h.get_dv_by_id_hd(14)) {
//            System.out.println(hd.getType());
//        }
        h.update_idNV(1, 16);
    }
}
