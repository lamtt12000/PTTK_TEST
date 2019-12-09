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
public class HoaDonDV {
    private int maHDDV;
    private int maHD;
    private int maDV;
    private int maNV;
    private int soluong;
    private int dongiahientai;

    public HoaDonDV() {
    }

    public HoaDonDV(int maHDDV, int maHD, int maDV, int maNV, int soluong, int dongiahientai) {
        this.maHDDV = maHDDV;
        this.maHD = maHD;
        this.maDV = maDV;
        this.maNV = maNV;
        this.soluong = soluong;
        this.dongiahientai = dongiahientai;
    }

    public int getMaHDDV() {
        return maHDDV;
    }

    public void setMaHDDV(int maHDDV) {
        this.maHDDV = maHDDV;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongiahientai() {
        return dongiahientai;
    }

    public void setDongiahientai(int dongiahientai) {
        this.dongiahientai = dongiahientai;
    }
    
    

}
