/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots;

import com.jesseandswen.dev8.scatterplots.Models.DataModel;
import com.jesseandswen.dev8.scatterplots.Models.Rect;
import com.jesseandswen.dev8.scatterplots.Models.Rgb;
import com.jesseandswen.dev8.scatterplots.Models.Vector2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import processing.core.PApplet;
import static processing.core.PApplet.map;

/**
 *
 * @author swenm_000
 */
public class ScatterPlot {
    private PApplet applet;
    
    private Rect<Integer> area;
    private List<DataModel> dataList;
    private List<DataModel> mappedDataList;

    public ScatterPlot(PApplet applet, Rect<Integer> area, List<DataModel> data) {
        this.applet = applet;
        this.area = area;
        this.dataList = data;
        
        mappedDataList = mapData(dataList);
    }
    
    public void draw() {
        applet.stroke(0);
        applet.line(area.x, area.y, area.width, area.y); // Horizontal line (X-axis)
        applet.line(area.x, area.y, area.x, applet.height - area.height); // Vertical line (Y-axis)
        
        for (DataModel model : mappedDataList) {
            Rgb rgb = Rgb.RED;
            switch (model.getCAT()) {
                case 1:
                    rgb = Rgb.RED;
                    break;
                case 2:
                    rgb = Rgb.BLUE;
                    break;
                case 3:
                    rgb = Rgb.GREEN;
                    break;
                case 4:
                    rgb = Rgb.PINK;
                    break;
                default:
                    System.err.println("Could not match category with color, using RED as default.");
            }
            applet.stroke(rgb.getR(), rgb.getG(), rgb.getB());
            applet.fill(rgb.getR(), rgb.getG(), rgb.getB());
            applet.ellipse(model.getEIG1(), model.getEIG2(), 5, 5);
        }
    }
    
    private List<DataModel> mapData(List<DataModel> data) {
        Vector2<Float> maxValues = getMaxValues();
        DataModel[] newData = new DataModel[data.size()];
        for (int i = 0; i < data.size(); i++) {
            DataModel model = data.get(i);
            
            model.setEIG1((int)map(model.getEIG1(), 0, maxValues.x, area.x, area.width));
            model.setEIG2(map(model.getEIG2(), 0, maxValues.y, area.y, applet.height - area.height));
            
            newData[i] = model;
        }
        return Arrays.asList(newData);
    }
    
    private Vector2<Float> getMaxValues() {
        float maxEIG1 = 0f;
        float maxEIG2 = 0f;
        
        for(DataModel model : dataList) {
            if(model.getEIG1() > maxEIG1)
                maxEIG1 = model.getEIG1();
            if(model.getEIG2() > maxEIG2)
                maxEIG2 = model.getEIG2();
        }
        
        return new Vector2<>(maxEIG1, maxEIG2);
    }
}
