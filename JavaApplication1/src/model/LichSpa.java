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
public class LichSpa {
    private int malsp;
    private Timestamp thoigian;
    private int status;

    public LichSpa(int malsp, Timestamp thoigian,int status ) {
        this.malsp = malsp;
        this.thoigian = thoigian;
        this.status = status;
    }

    public LichSpa() {
    }

    public int getMalsp() {
        return malsp;
    }

    public void setMalsp(int malsp) {
        this.malsp = malsp;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
