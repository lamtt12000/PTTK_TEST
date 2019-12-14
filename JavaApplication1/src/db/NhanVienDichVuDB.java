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
import model.NhanVien;
import model.NhanVienDichVu;

/**
 *
 * @author lamtran
 */
public class NhanVienDichVuDB {
    private Connection con;
    private MyDB myDB;
    private PreparedStatement ps, ps1;
    private NhanVienDichVu nv;
    private ResultSet rs, rs1;

    public NhanVienDichVuDB() {
        this.myDB = new MyDB();
    }
    
    
    public List<NhanVien> get_by_dichvu(int id_dv) {
        List<NhanVien> list = new ArrayList<>();
        try {
            con = myDB.openConnect();
            String sq = "SELECT * FROM nhanvien_dichvu WHERE madv =" + id_dv;
            ps1=con.prepareStatement(sq);
            rs1=ps1.executeQuery();
            while (rs1.next()) {
                String sql = "SELECT * FROM nhanvien WHERE manv =" + rs1.getString("manv");
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();

                while(rs.next()) {
                    System.out.println(rs.getString("ten"));
                    NhanVien nv = new NhanVien(rs.getInt("manv") , rs.getString("ten"), rs.getDate("ngaysinh"), 
                    rs.getString("diachi"), rs.getInt("luong"), rs.getString("matkhau"),rs.getInt("status"), rs.getString("chucvu"));
                    list.add(nv);
                }
            }
           
                
            
        } catch (SQLException ex) {
            Logger.getLogger(LichDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        NhanVienDichVuDB n = new NhanVienDichVuDB();
        n.get_by_dichvu(1);
    }
    
}
