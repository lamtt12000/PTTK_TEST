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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.KhachHang;

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
    
    public LichDB() {
        myDB = new MyDB();
    }
     
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
            ps.setTimestamp(2, l.getNgay());
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
    
    public int update(int mal, int status) throws SQLException{
        int kt = 10002;
        try {
            con = myDB.openConnect();
            String sqlcheck = "Select * from lich WHERE mal = " + mal;
            rs = con.prepareStatement(sqlcheck).executeQuery();
            rs.last();    // moves cursor to the last row
            int size = rs.getRow(); // get row id 
            System.out.println(size);
            if (size != 0) {
                String sql = "UPDATE lich SET status = ?"
                    + " WHERE mal = ?";
                ps=con.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, mal);
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
                Lich la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"), 
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
                la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"),
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
                Lich la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"),
                    rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public List<Lich> get_by_sdt_and_date(String sdt, Date date) {
        List<Lich> list_l = new ArrayList<Lich>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich WHERE sdt_kh = "+ sdt +" AND ngay = '" + String.valueOf(date) + "'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Lich la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"),
                    rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                list_l.add(la);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_l;
    }
    
    public List<Lich> get_by_lstsdt_and_date(List<KhachHang> list, String date) {
        List<Lich> list_l = new ArrayList<Lich>();
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich WHERE sdt_kh = ?";
            ps=con.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("-------------" + list.get(i).getSodt());
                ps.setString(1, list.get(i).getSodt());
                rs = ps.executeQuery();
                while(rs.next()) {
                    System.out.println(rs.getInt("manv"));
                    Lich la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"),
                        rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                    list_l.add(la);
                }
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list_l;
    }
    
    public List<Lich> getLichTrong(String date) {
        List<Lich> list_l = new ArrayList<Lich>();
        //tinh tu thoi diem hien tai
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        String tempHour = hour + ":" + minute + ":" + second;
        String start_time = date + " " + tempHour;
        String end_time = date + " 23:59:59";
        try {
            con = myDB.openConnect();
            String sql = "SELECT * FROM lich WHERE ngay >='" + start_time + "' AND"
                    + " ngay<= '" + end_time + "' AND status = 0";
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                    System.out.println(rs.getInt("manv"));
                    Lich la = new Lich(rs.getInt("mal"), rs.getTimestamp("ngay"),
                        rs.getString("sdt_kh"), rs.getInt("status"), rs.getInt("manv"));
                    list_l.add(la);
           }
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list_l;
        
    }
    public static void main(String[] args) {
//        String str="2019-03-24 10:08:08";
//        Timestamp date= new Timestamp(Date.valueOf(str).getTime());
//        Lich l = new Lich(2, date, "037686566999", 1, 1);
        LichDB ldb = new LichDB();
        try {
            ldb.update(1, 1);
//        System.out.println(ldb.get_by_sdt_and_date("037686566999", date));
//        System.out.println(ldb.get_by_status(2));
//        System.out.println(ldb.get_by_sdt_and_date("037686566999", date));
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    
    
}
