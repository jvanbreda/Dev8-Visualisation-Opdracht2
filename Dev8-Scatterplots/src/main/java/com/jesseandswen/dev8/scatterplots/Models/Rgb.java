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
public class Rgb {
    public static final Rgb YELLOW = new Rgb(255, 255, 0);
    public static final Rgb PINK = new Rgb(255, 0, 255);
    public static final Rgb RED = new Rgb(255, 0, 0);
    public static final Rgb BLUE = new Rgb(0, 0, 255);
    public static final Rgb GREEN = new Rgb(0, 255, 0);
    
    private int r;
    private int g;
    private int b;

    public Rgb(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
