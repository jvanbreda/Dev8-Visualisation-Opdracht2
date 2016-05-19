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
import javafx.scene.text.TextAlignment;
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
    
    private final int intervals = 10;

    public ScatterPlot(PApplet applet, Rect<Integer> area, List<DataModel> data) {
        this.applet = applet;
        this.area = area;
        this.dataList = data;
        
        mappedDataList = mapData(dataList);
    }
    
    public void draw() {
        drawAxis();
        
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
            DataModel model = new DataModel();
            model.setCAT(data.get(i).getCAT());  
            model.setEIG1((int)map(data.get(i).getEIG1(), 0, maxValues.x, area.x, area.x + area.width));
            model.setEIG2(map(data.get(i).getEIG2(), 0, maxValues.y, area.y, area.y - area.height));
            
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
    
    private void drawAxis() {
        applet.stroke(0);
        applet.line(area.x, area.y, area.x + area.width, area.y); // Horizontal line (X-axis)
        applet.line(area.x, area.y, area.x, area.y - area.height); // Vertical line (Y-axis)
        
        Vector2<Float> maxValues = getMaxValues();
        applet.textAlign(applet.CENTER, applet.TOP);
        applet.fill(0);
        int lineHeight = 10;
        
        // Horizontale intervals
        for (int i = 0; i <= intervals; i++) {
            applet.line(area.x + (i * (area.width / intervals)), area.y, area.x + (i * (area.width / intervals)), area.y + lineHeight);
            applet.text(Math.round((maxValues.x / intervals) * i), area.x + (i * (area.width / intervals)), area.y + lineHeight + 4);
        }
        
        applet.textAlign(applet.RIGHT, applet.CENTER);
        // Vertical intervals
        for (int i = 0; i <= intervals; i++) {
            applet.line(area.x, area.y - (i * (area.height / intervals)), area.x - lineHeight, area.y - (i * (area.height / intervals)));
            applet.text(Math.round((maxValues.y / intervals) * i), area.x - lineHeight - 4, area.y - (i * (area.width / intervals)));
        }
    }
}
