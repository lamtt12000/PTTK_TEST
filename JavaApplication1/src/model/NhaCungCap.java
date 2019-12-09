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
public class NhaCungCap {
    private int maNCC;
    private String ten;
    private String diachi;
    private String email;

    public NhaCungCap() {
    }

    public NhaCungCap(int maNCC, String ten, String diachi, String email) {
        this.maNCC = maNCC;
        this.ten = ten;
        this.diachi = diachi;
        this.email = email;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
