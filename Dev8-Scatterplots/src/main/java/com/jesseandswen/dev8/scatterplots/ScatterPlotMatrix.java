/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots;

import com.jesseandswen.dev8.scatterplots.Models.DataModel;
import com.jesseandswen.dev8.scatterplots.Models.Rect;
import com.jesseandswen.dev8.scatterplots.Models.ScatterMatrixDataSet;
import com.jesseandswen.dev8.scatterplots.Models.StudentModel;
import com.jesseandswen.dev8.scatterplots.Models.Vector2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class ScatterPlotMatrix {

    private PApplet applet;

    private Rect<Integer> area;
    private LinkedHashMap dataSet;
    private List<ScatterPlot> scatterPlots;

    private String title;

    public ScatterPlotMatrix(PApplet applet, Rect<Integer> area, LinkedHashMap<String, float[]> dataSet) {
        this.applet = applet;
        this.area = area;
        this.dataSet = dataSet;

        scatterPlots = generateScatterPlots(dataSet);

        title = generateTitle(dataSet);
    }

    public void draw() {
//        applet.stroke(0);
        applet.textAlign(applet.CENTER);
        applet.textSize(16);
        applet.fill(0);
        applet.text(title, area.x + area.width / 2, area.y - area.height - 20);
//        applet.fill(240);
//        applet.rect(area.x, area.y, area.width, -area.height);
        
        for (ScatterPlot scatterPlot : scatterPlots) {
            scatterPlot.drawBorder();
            scatterPlot.draw();
        }
        
        drawDiagonals();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String generateTitle(LinkedHashMap<String, float[]> dataSet) {
        Object[] columnNames = dataSet.keySet().toArray();
        StringBuilder stringBuilder = new StringBuilder("Matrix Plot of ");
        for (int i = 0; i < columnNames.length; i++) {
            if (i != 0) {
                stringBuilder.append(',');
            }

            stringBuilder.append(" " + columnNames[i]);
        }
        return stringBuilder.toString();
    }

    private List<ScatterPlot> generateScatterPlots(LinkedHashMap<String, float[]> dataSet) {
        List<ScatterPlot> scatterPlots = new ArrayList<>();
        for (int k = 0; k < dataSet.size(); k++) {
            for (int i = 0; i < dataSet.size(); i++) {
                if ((i + 1 + k) % dataSet.size() == 0)
                    continue;

                List<DataModel> dataModels = new ArrayList<>();
                for (int j = 0; j < dataSet.values().size(); j++) {
                    DataModel dataModel = new DataModel(1, dataSet.get((String) dataSet.keySet().toArray()[k])[j], dataSet.get((String) dataSet.keySet().toArray()[dataSet.size() - 1 - i])[j]);
                    dataModels.add(dataModel);
                }

                scatterPlots.add(new ScatterPlot(applet, new Rect<Integer>(area.x + i * (area.width / dataSet.size()), area.y - k * (area.height / dataSet.size()), area.width / dataSet.size(), area.height / dataSet.size()), dataModels));
            }
        }
        return scatterPlots;
    }
    
    private void drawDiagonals() {
        for (int k = 0; k < dataSet.size(); k++) {
            for (int i = 0; i < dataSet.size(); i++) {
                if ((i + 1 + k) % dataSet.size() != 0)
                    continue;
                
                applet.stroke(0);
                applet.fill(240);
                applet.rect(area.x + i * (area.width / dataSet.size()), area.y - k * (area.height / dataSet.size()), area.width / dataSet.size(), -area.height / dataSet.size());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(14);
                applet.fill(0);
                applet.text((String) dataSet.keySet().toArray()[k], area.x + i * (area.width / dataSet.size()), area.y - k * (area.height / dataSet.size()), area.width / dataSet.size(), -area.height / dataSet.size());
            }
        }
    }
}
