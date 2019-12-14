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
import model.KhachHang;
import model.Lich;

/**
 *
 * @author lamtran
 */
public class DichVuDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private DichVu dv;
    private ResultSet rs;
    
    public DichVuDB() {
        myDB = new MyDB();
    }
    
    public DichVuDB(DichVu l) {
        this.dv = l;
        myDB = new MyDB();
    }
    
    public List<DichVu> get_all(){
        List<DichVu> list_l = new ArrayList<DichVu>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM dichvu";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DichVu la = new DichVu(rs.getInt("madv") ,rs.getString("ten"), rs.getInt("dongia"), rs.getString("mota"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
        
    }
    
    
    public List<DichVu> get_by_name(String name){
        List<DichVu> list_l = new ArrayList<DichVu>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM dichvu WHERE ten LIKE '%" + name + "%'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                DichVu la = new DichVu(rs.getInt("madv") ,rs.getString("ten"), rs.getInt("dongia"), rs.getString("mota"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    
    public DichVu get_by_id(int id){
        DichVu la = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM dichvu WHERE madv=" + id;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
               la = new DichVu(rs.getInt("madv") ,rs.getString("ten"), rs.getInt("dongia"), rs.getString("mota"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
}
