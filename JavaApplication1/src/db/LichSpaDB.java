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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lich;
import model.LichSpa;

/**
 *
 * @author lamtran
 */
public class LichSpaDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps;
    private Lich l;
    private ResultSet rs;
    
    public LichSpaDB() {
        myDB = new MyDB();
    }
     
    public LichSpaDB(Lich l) {
        this.l = l;
        myDB = new MyDB();
    }
    
    public List<LichSpa> get_lich_trong(String time) {
        List<LichSpa> list_l = new ArrayList<LichSpa>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lichspa WHERE status =0 AND thoigian >='" + time + "'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                LichSpa la = new LichSpa(rs.getInt("malsp"), rs.getTimestamp("thoigian"), rs.getInt("status"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public LichSpa get_by_id(int id) {
        LichSpa la = null;
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lichspa WHERE malsp=" + id;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                la = new LichSpa(rs.getInt("malsp"), rs.getTimestamp("thoigian"), rs.getInt("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
    
    
    public boolean update(int id, int status) {
        boolean kt = false;
        try {
            con = myDB.openConnect();
            String sql = "UPDATE lichspa SET status="+ status +" WHERE malsp=" + id;
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            kt= true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kt;
    }
    
}
