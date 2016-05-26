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
        for (ScatterPlot scatterPlot : scatterPlots) {
            scatterPlot.draw();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String generateTitle(LinkedHashMap<String, float[]> dataSet) {
        String[] columnNames = (String[])dataSet.keySet().toArray();
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
        int y = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            List<DataModel> dataModels = new ArrayList<>();
            for (int j = 0; j < dataSet.values().size(); j++) {
                DataModel dataModel = new DataModel(0, dataSet.get(i)[j], dataSet.get(i)[j]);
                dataModels.add(dataModel);
            }
            if(i % dataSet.size() != 0)
                scatterPlots.add(new ScatterPlot(applet, new Rect<Integer>(area.x + i * (area.width / dataSet.size()), area.y + y * (area.height / dataSet.size()), area.width / dataSet.size(), area.height / dataSet.size()), dataModels));
            if(i + 1 == dataSet.size())
                y++;
        }
        return scatterPlots;
    }
}
