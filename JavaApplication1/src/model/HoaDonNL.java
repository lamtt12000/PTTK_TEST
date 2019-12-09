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
public class HoaDonNL {
    private int maHDNL;
    private int maHD;
    private int maNL;
    private int soluong;
    private int dongiahientai;

    public HoaDonNL() {
    }

    public HoaDonNL(int maHDNL, int maHD, int maNL, int soluong, int dongiahientai) {
        this.maHDNL = maHDNL;
        this.maHD = maHD;
        this.maNL = maNL;
        this.soluong = soluong;
        this.dongiahientai = dongiahientai;
    }

    public int getMaHDNL() {
        return maHDNL;
    }

    public void setMaHDNL(int maHDNL) {
        this.maHDNL = maHDNL;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
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
