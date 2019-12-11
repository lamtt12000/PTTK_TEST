/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lamtran
 */
public class KhachHang {
    private int maKH;
    private String ten;
    private String sodt;
    private String email;
    private String diachi;

    public KhachHang() {
    }

    
    public KhachHang(int makh, String ten, String sodt, String email, String diachi) {
        this.ten = ten;
        this.sodt = sodt;
        this.email = email;
        this.diachi = diachi;
        this.maKH = makh;
    }

    
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    
    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
