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
public class HoaDon {
    private int maHD;
    private int total;
    private int maNV;
    private int maL;

    public HoaDon() {
    }

    public HoaDon(int maHD, int total, int maNV, int maL) {
        this.maHD = maHD;
        this.total = total;
        this.maNV = maNV;
        this.maL = maL;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaL() {
        return maL;
    }

    public void setMaL(int maL) {
        this.maL = maL;
    }
    
    
}
