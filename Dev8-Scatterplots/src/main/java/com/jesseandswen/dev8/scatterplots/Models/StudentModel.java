/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots.Models;

/**
 *
 * @author swenm_000
 */
public class StudentModel {
    private int stnr;
    private int lftd;
    private float ana;
    private float dev;
    private float prj;
    private float skl;

    public StudentModel() { }
    
    public StudentModel(int stnr, int lftd, float ana, float dev, float prj, float skl) {
        this.stnr = stnr;
        this.lftd = lftd;
        this.ana = ana;
        this.dev = dev;
        this.prj = prj;
        this.skl = skl;
    }
    
    public int getStnr() {
        return stnr;
    }

    public void setStnr(int stnr) {
        this.stnr = stnr;
    }

    public int getLftd() {
        return lftd;
    }

    public void setLftd(int lftd) {
        this.lftd = lftd;
    }

    public float getAna() {
        return ana;
    }

    public void setAna(float ana) {
        this.ana = ana;
    }

    public float getDev() {
        return dev;
    }

    public void setDev(float dev) {
        this.dev = dev;
    }

    public float getPrj() {
        return prj;
    }

    public void setPrj(float prj) {
        this.prj = prj;
    }

    public float getSkl() {
        return skl;
    }

    public void setSkl(float skl) {
        this.skl = skl;
    }
}
