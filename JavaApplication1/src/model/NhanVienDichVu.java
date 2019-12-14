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
public class NhanVienDichVu {
    private int maNVDV;
    private int maNV;
    private int maDV;
    private int status;

    public NhanVienDichVu() {
        
    }

    public NhanVienDichVu(int maNVDV, int maNV, int maDV) {
        this.maNVDV = maNVDV;
        this.maNV = maNV;
        this.maDV = maDV;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaNVDV() {
        return maNVDV;
    }

    public void setMaNVDV(int maNVDV) {
        this.maNVDV = maNVDV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }
    
    
}
