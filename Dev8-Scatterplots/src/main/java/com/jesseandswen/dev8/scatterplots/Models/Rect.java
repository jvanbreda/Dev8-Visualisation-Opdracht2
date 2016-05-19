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
public class Rect<T> {
    public T x;
    public T y;
    public T width;
    public T height;

    public Rect(T x, T y, T width, T height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
