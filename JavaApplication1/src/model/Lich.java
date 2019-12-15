/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author lamtran
 */
public class Lich {
    private int maL;
    private int maLSpa;
    private String sdtkhachhang;
    private int status;
    private int maNV;


    public Lich(int maL, int maLSpa, String sdtkhachhang, int status, int maNV) {
        this.maL = maL;
        this.maLSpa = maLSpa;
        this.sdtkhachhang = sdtkhachhang;
        this.status = status;
        this.maNV = maNV;
    }

    public Lich(int maLSpa, String sdtkhachhang, int status, int maNV) {
        this.maLSpa = maLSpa;
        this.sdtkhachhang = sdtkhachhang;
        this.status = status;
        this.maNV = maNV;
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

    public int getMaLSpa() {
        return maLSpa;
    }

    public void setMaLSpa(int maLSpa) {
        this.maLSpa = maLSpa;
    }
   
    public String getSdtkhachhang() {
        return sdtkhachhang;
    }

    public void setSdtkhachhang(String sdtkhachhang) {
        this.sdtkhachhang = sdtkhachhang;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
   
}
