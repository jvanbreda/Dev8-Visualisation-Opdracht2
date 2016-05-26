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
import java.util.List;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class ScatterPlotMatrix {

    private PApplet applet;

    private Rect<Integer> area;
    private HashMap dataSet;
    private List<ScatterPlot> scatterPlots;

    private String title;

    public ScatterPlotMatrix(PApplet applet, Rect<Integer> area, HashMap dataSet) {
        this.applet = applet;
        this.area = area;
        this.dataSet = dataSet;

//        scatterPlots = generateScatterPlots(dataSet.getDataSet());
//        
//        title = generateTitle(dataSet.getColumnNames());
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

    private String generateTitle(String[] columnNames) {
        StringBuilder stringBuilder = new StringBuilder("Matrix Plot of ");
        for (int i = 0; i < columnNames.length; i++) {
            if (i != 0) {
                stringBuilder.append(',');
            }

            stringBuilder.append(" " + columnNames[i]);
        }
        return stringBuilder.toString();
    }

//    private List<ScatterPlot> generateScatterPlots(HashMap<String, StudentModel> data) {
//        List<ScatterPlot> scatterPlots = new ArrayList<>();
//        int y = 0;
//        for (int i = 0; i < data.size(); i++) {
//            List<DataModel> dataModels = new ArrayList<>();
//            for (int j = 0; j < data.size(); j++) {
//                DataModel dataModel = new DataModel(0, data.get(j).getEIG1(), data.get(j).getEIG2());
//                dataModels.add(dataModel);
//            }
//            if(i % dataSet.getDataSet().length != 0)
//                scatterPlots.add(new ScatterPlot(applet, new Rect<Integer>(area.x + i * (area.width / dataSet.getDataSet().length), area.y + y * (area.height / dataSet.getDataSet().length), area.width / dataSet.getDataSet().length, area.height / dataSet.getDataSet().length), dataModels));
//            if(i + 1 == data.length)
//                y++;
//        }
//        return scatterPlots;
//    }
}
