/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots;

import com.jesseandswen.dev8.scatterplots.Data.DataProvider;
import com.jesseandswen.dev8.scatterplots.Models.Rect;
import processing.core.PApplet;

/**
 *
 * @author Jesse
 */
public class Canvas extends PApplet {
    private DataProvider dataProvider;
    private ScatterPlot scatterPlot;
    
    public void setup(){
        size(1200, 800);
        
        background(255);
        
        dataProvider = new DataProvider();
        scatterPlot = new ScatterPlot(this, new Rect<>(100, 700, 600, 600), dataProvider.getDataList());
        scatterPlot.intervalEvery(10, 100);
    }
    
    public void draw(){
        scatterPlot.draw();
    }
    
}
