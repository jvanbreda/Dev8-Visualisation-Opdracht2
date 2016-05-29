/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots.Models;

/**
 *
 * @author Jesse
 */
public class DataModel<T> {
    private int CAT;
    private T EIG1;
    private T EIG2;

    public DataModel() { }

    public DataModel(int CAT, T EIG1, T EIG2) {
        this.CAT = CAT;
        this.EIG1 = EIG1;
        this.EIG2 = EIG2;
    }

    public int getCAT() {
        return CAT;
    }

    public void setCAT(int CAT) {
        this.CAT = CAT;
    }

    public T getEIG1() {
        return EIG1;
    }

    public void setEIG1(T EIG1) {
        this.EIG1 = EIG1;
    }

    public T getEIG2() {
        return EIG2;
    }

    public void setEIG2(T EIG2) {
        this.EIG2 = EIG2;
    }
}
