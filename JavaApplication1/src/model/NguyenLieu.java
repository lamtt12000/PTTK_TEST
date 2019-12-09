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
public class NguyenLieu {
    private int maNL;
    private String ten;
    private int soluong;
    private int dongia;
    private int nhaCungCapId;

    public NguyenLieu() {
    }

    public NguyenLieu(int maNL, String ten, int soluong, int dongia, int nhaCungCapId) {
        this.maNL = maNL;
        this.ten = ten;
        this.soluong = soluong;
        this.dongia = dongia;
        this.nhaCungCapId = nhaCungCapId;
    }

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getNhaCungCapId() {
        return nhaCungCapId;
    }

    public void setNhaCungCapId(int nhaCungCapId) {
        this.nhaCungCapId = nhaCungCapId;
    }

    
    
    
}
