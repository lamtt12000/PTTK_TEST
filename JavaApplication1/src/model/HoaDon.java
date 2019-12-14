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
    private int maNV;
    private int maL;
    private int status;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maNV, int maL, int status) {
        this.maHD = maHD;
        this.status = status;
        this.maNV = maNV;
        this.maL = maL;
    }
    
    public HoaDon(int maNV, int maL, int status) {
        this.status = status;
        this.maNV = maNV;
        this.maL = maL;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
