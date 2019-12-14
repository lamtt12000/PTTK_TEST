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
public class HoaDonDVNL {
    private int maHDDVNL;
    private int maHD;
    private int maDVNL;
    private int maNVPV;
    private int soluong;
    private int dongiahientai;
    private int type;

    public HoaDonDVNL() {
    }

    public HoaDonDVNL(int maHDDVNL, int maHD, int maDVNL, int maNVPV, int soluong, int dongiahientai, int type) {
        this.maHDDVNL = maHDDVNL;
        this.maHD = maHD;
        this.maDVNL = maDVNL;
        this.maNVPV = maNVPV;
        this.soluong = soluong;
        this.dongiahientai = dongiahientai;
        this.type = type;
    }

    public HoaDonDVNL(int maHD, int maDVNL, int maNVPV, int soluong, int dongiahientai, int type) {
        this.maHD = maHD;
        this.maDVNL = maDVNL;
        this.maNVPV = maNVPV;
        this.soluong = soluong;
        this.dongiahientai = dongiahientai;
        this.type = type;
    }

    public int getMaHDDVNL() {
        return maHDDVNL;
    }

    public void setMaHDDVNL(int maHDDVNL) {
        this.maHDDVNL = maHDDVNL;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaDVNL() {
        return maDVNL;
    }

    public void setMaDVNL(int maDVNL) {
        this.maDVNL = maDVNL;
    }

    public int getMaNVPV() {
        return maNVPV;
    }

    public void setMaNVPV(int maNVPV) {
        this.maNVPV = maNVPV;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    

}
