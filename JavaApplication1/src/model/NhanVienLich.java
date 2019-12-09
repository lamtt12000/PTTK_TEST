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
public class NhanVienLich {
    private int maNVL;
    private int maNV;
    private int maL;

    public NhanVienLich() {
    }

    public NhanVienLich(int maNVL, int maNV, int maL) {
        this.maNVL = maNVL;
        this.maNV = maNV;
        this.maL = maL;
    }

    
    public int getMaNVL() {
        return maNVL;
    }

    public void setMaNVL(int maNVL) {
        this.maNVL = maNVL;
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
