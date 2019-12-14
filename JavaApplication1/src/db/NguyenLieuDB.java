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
import model.DichVu;
import model.NguyenLieu;

/**
 *
 * @author lamtran
 */
public class NguyenLieuDB {

    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private NguyenLieu nl;
    private ResultSet rs;

    public NguyenLieuDB() {
        myDB = new MyDB();
    }

    public NguyenLieuDB(NguyenLieu nl) {
        this.nl = nl;
        myDB = new MyDB();
    }

    public List<NguyenLieu> get_all() {
        List<NguyenLieu> list_l = new ArrayList<NguyenLieu>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM nguyenlieu WHERE soluong > 0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguyenLieu la = new NguyenLieu(rs.getInt("manl"), rs.getString("ten"), rs.getInt("soluong"), rs.getInt("dongia"), rs.getString("mota"), rs.getInt("mancc"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;

    }

    public List<NguyenLieu> get_by_name(String name) {
        List<NguyenLieu> list_l = new ArrayList<NguyenLieu>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM nguyenlieu WHERE ten LIKE '%" + name + "%' AND soluong > 0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                NguyenLieu la = new NguyenLieu(rs.getInt("manl"), rs.getString("ten"), rs.getInt("soluong"), rs.getInt("dongia"), rs.getString("mota"), rs.getInt("mancc"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public NguyenLieu get_by_id(int id) {
        NguyenLieu la = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM nguyenlieu WHERE manl=" + id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                la = new NguyenLieu(rs.getInt("manl"), rs.getString("ten"), rs.getInt("soluong"), rs.getInt("dongia"), rs.getString("mota"), rs.getInt("mancc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    

    public int updateSoluong(int manl, int soluong) throws SQLException {
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sql = "UPDATE nguyenlieu SET soluong =" + soluong + " WHERE manl=" + manl ;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            kt = 10000;
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return kt;
    }

    public static void main(String[] args) {
        NguyenLieu nl = new NguyenLieu(1, "ten", 0, 0, "mota", 0);
        NguyenLieuDB nldb = new NguyenLieuDB();
        System.out.println(nldb.get_all());
        System.out.println(nldb.get_by_name("2"));
//            System.out.println(nldb.update(nl));

    }
}
