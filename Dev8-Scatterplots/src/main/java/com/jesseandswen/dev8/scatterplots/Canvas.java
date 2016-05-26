/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots;

import com.jesseandswen.dev8.scatterplots.Data.DataProvider;
import com.jesseandswen.dev8.scatterplots.Models.DataModel;
import com.jesseandswen.dev8.scatterplots.Models.Rect;
import com.jesseandswen.dev8.scatterplots.Models.ScatterMatrixDataSet;
import processing.core.PApplet;

/**
 *
 * @author Jesse
 */
public class Canvas extends PApplet {
    private DataProvider dataProvider;
    private ScatterPlotMatrix scatterPlotMatrix;
    // Assignment B
//    private ScatterPlot scatterPlot;
    
    public void setup(){
        size(1200, 800);
        
        dataProvider = new DataProvider();
//        scatterPlotMatrix = new ScatterPlotMatrix(this, new Rect<>(100, 700, 600, 600), new ScatterMatrixDataSet<DataModel>(new String[] { "Stnr", "lftd", "ANA", "DEV", "PRJ", "SKL" }, dataProvider.getStudentDataList()));
        
        // Assignment B
//        scatterPlot = new ScatterPlot(this, new Rect<>(100, 700, 600, 600), dataProvider.getDataList());
//        scatterPlot.intervalEvery(10, 100);
        
        
    }
    
    public void draw(){
        background(255);
        
        // Assignment B
//        scatterPlot.draw();
//        scatterPlot.drawAxis();
    }
    
}
