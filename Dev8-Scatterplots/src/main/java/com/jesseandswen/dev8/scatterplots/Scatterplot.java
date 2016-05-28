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

    private Vector2<Integer> intervals = new Vector2<>(10, 10);
    private Vector2<Float> pointSize = new Vector2<>(5f, 5f);

    public ScatterPlot(PApplet applet, Rect<Integer> area, List<DataModel> data) {
        this.applet = applet;
        this.area = area;
        this.dataList = data;

        mappedDataList = mapData(dataList);
    }

    public void draw() {
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
            applet.ellipse(Float.parseFloat(model.getEIG1().toString()), Float.parseFloat(model.getEIG2().toString()), pointSize.x, pointSize.y);
        }
    }
    
    public void drawHelpLines() {
        Vector2<Integer> mousePosition = new Vector2(applet.mouseX, applet.mouseY);
        Vector2<Float> maxValues = getMaxValues();

        // If mouse is in area
        if (mousePosition.x > area.x && mousePosition.x < area.x + area.width && mousePosition.y < area.y && mousePosition.y > area.y - area.height) {
            applet.stroke(125);
            
            applet.textAlign(applet.CENTER, applet.BOTTOM);
            applet.text((int) map(mousePosition.x, area.x, area.x + area.width, 0, maxValues.x), mousePosition.x, area.y - area.height - 4);
            
            applet.textAlign(applet.LEFT, applet.CENTER);
            applet.text((int) map(mousePosition.y, area.y, area.y - area.height, 0, maxValues.y), area.x + area.width + 4, mousePosition.y);
            
            applet.line(area.x, mousePosition.y, area.x + area.width, mousePosition.y); // Horizontal line (X-axis)
            applet.line(mousePosition.x, area.y, mousePosition.x, area.y - area.height); // Vertical line (Y-axis)
        }
    }
    
    public void drawBorder() {
        applet.stroke(0);
        applet.fill(255);
        applet.rect(area.x, area.y, area.width, -area.height);
    }
    
    public void drawAxis() {
        applet.stroke(0);
        applet.line(area.x, area.y, area.x + area.width, area.y); // Horizontal line (X-axis)
        applet.line(area.x, area.y, area.x, area.y - area.height); // Vertical line (Y-axis)

        Vector2<Float> maxValues = getMaxValues();
        applet.fill(0);
        int lineHeight = 10;

        // Horizontal intervals
        applet.textAlign(applet.CENTER, applet.TOP);
        for (int i = 1; i <= intervals.x; i++) {
            applet.line(area.x + (i * (area.width / intervals.x)), area.y, area.x + (i * (area.width / intervals.x)), area.y + lineHeight);
            applet.text(Math.round((maxValues.x / intervals.x) * i), area.x + (i * (area.width / intervals.x)), area.y + lineHeight + 4);
        }

        // Vertical intervals
        applet.textAlign(applet.RIGHT, applet.CENTER);
        for (int i = 1; i <= intervals.y; i++) {
            applet.line(area.x, area.y - (i * (area.height / intervals.y)), area.x - lineHeight, area.y - (i * (area.height / intervals.y)));
            applet.text(Math.round((maxValues.y / intervals.y) * i), area.x - lineHeight - 4, area.y - (i * (area.width / intervals.y)));
        }

        // Origin
        applet.textAlign(applet.RIGHT, applet.TOP);
        applet.text(0, area.x - 4, area.y - 4);
    }
    
    public void drawAxisX() {
        applet.stroke(0);
        applet.line(area.x, area.y, area.x + area.width, area.y); // Horizontal line (X-axis)

        Vector2<Float> maxValues = getMaxValues();
        applet.fill(0);
        int lineHeight = 10;

        // Horizontal intervals
        applet.textAlign(applet.CENTER, applet.TOP);
        for (int i = 0; i <= intervals.x; i++) {
            applet.line(area.x + (i * (area.width / intervals.x)), area.y, area.x + (i * (area.width / intervals.x)), area.y + lineHeight);
            applet.text(Math.round((maxValues.x / intervals.x) * i), area.x + (i * (area.width / intervals.x)), area.y + lineHeight + 4);
        }
    }
    
    public void drawAxisY() {
        applet.stroke(0);
        applet.line(area.x, area.y, area.x, area.y - area.height); // Vertical line (Y-axis)

        Vector2<Float> maxValues = getMaxValues();
        applet.fill(0);
        int lineHeight = 10;

        // Vertical intervals
        applet.textAlign(applet.RIGHT, applet.CENTER);
        for (int i = 1; i <= intervals.y; i++) {
            applet.line(area.x, area.y - (i * (area.height / intervals.y)), area.x - lineHeight, area.y - (i * (area.height / intervals.y)));
            applet.text(Math.round((maxValues.y / intervals.y) * i), area.x - lineHeight - 4, area.y - (i * (area.width / intervals.y)));
        }
    }
    
    public void drawOrigin() {
        applet.stroke(0);

        // Origin
        applet.textAlign(applet.RIGHT, applet.TOP);
        applet.text(0, area.x - 4, area.y - 4);
    }

    public void intervalEvery(int x, int y) {
        Vector2<Float> maxValues = getMaxValues();

        int intervalX = (int)(maxValues.x / x);
        int intervalY = (int)(maxValues.y / y);

        intervals = new Vector2<>(intervalX, intervalY);
    }

    public Vector2<Integer> getIntervals() {
        return intervals;
    }

    public void setIntervals(Vector2<Integer> intervals) {
        this.intervals = intervals;
    }
    
    public Vector2<Float> getPointSize() {
        return pointSize;
    }

    public void setPointSize(Vector2<Float> pointSize) {
        this.pointSize = pointSize;
    }

    private List<DataModel> mapData(List<DataModel> data) {
        Vector2<Float> maxValues = getMaxValues();
        DataModel[] newData = new DataModel[data.size()];
        for (int i = 0; i < data.size(); i++) {
            DataModel model = new DataModel();
            model.setCAT(data.get(i).getCAT());
            model.setEIG1((int) map((float)data.get(i).getEIG1(), 0, maxValues.x, area.x, area.x + area.width));
            model.setEIG2(map((float)data.get(i).getEIG2(), 0, maxValues.y, area.y, area.y - area.height));

            newData[i] = model;
        }
        return Arrays.asList(newData);
    }

    // HMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM???????????????????
    @Deprecated
    private Vector2<Float> getRoundedMaxValues() {
        Vector2<Float> maxValues = getMaxValues();

        int lengthOfX = String.valueOf(Math.round(maxValues.x)).length();
        int lengthOfY = String.valueOf(Math.round(maxValues.y)).length();

        maxValues.x = maxValues.x - (maxValues.x % 10);
        maxValues.y = maxValues.y - (maxValues.y % 100) + 100;

        return maxValues;
    }

    private Vector2<Float> getMaxValues() {
        float maxEIG1 = 0f;
        float maxEIG2 = 0f;

        for (DataModel<Float> model : dataList) {
            float EIG1 = model.getEIG1();
            float EIG2 = model.getEIG2();
            if (EIG1 > maxEIG1) {
                maxEIG1 = (float)model.getEIG1();
            }
            if (EIG2 > maxEIG2) {
                maxEIG2 = (float)model.getEIG2();
            }
        }

        return new Vector2<>(maxEIG1, maxEIG2);
    }
}
