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
import com.jesseandswen.dev8.scatterplots.Models.StudentModel;
import processing.core.PApplet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class Canvas extends PApplet {
    private DataProvider dataProvider;
    private ScatterPlotMatrix scatterPlotMatrix;
    private ScatterPlot scatterPlot;
    
    public void setup(){
        size(1200, 800);
        
        dataProvider = new DataProvider();
        
        // Ugly
        LinkedHashMap<String, float[]> dataSet = new LinkedHashMap<>();
        List<StudentModel> studentModels = dataProvider.getStudentDataList();
        
        int size = studentModels.size();
        
        float[] studentNumbers = new float[size];
        float[] studentAge = new float[size];
        float[] ana = new float[size];
        float[] dev = new float[size];
        float[] prj = new float[size];
        float[] skl = new float[size];
        
        for (int i = 0; i < studentModels.size(); i++) {
            studentNumbers[i] = studentModels.get(i).getStnr();
            studentAge[i] = studentModels.get(i).getLftd();
            ana[i] = studentModels.get(i).getAna();
            dev[i] = studentModels.get(i).getDev();
            prj[i] = studentModels.get(i).getPrj();
            skl[i] = studentModels.get(i).getSkl();
        }
        
        dataSet.put("Skills", skl);
        dataSet.put("Project", prj);
        dataSet.put("Development", dev);
//        dataSet.put("Analysis", ana);
//        dataSet.put("Student Age", studentAge);
//        dataSet.put("StudentNumbers", studentNumbers);
        
        
        scatterPlotMatrix = new ScatterPlotMatrix(this, new Rect<>(100, 700, 600, 600), dataSet);
        
        // Assignment B
        scatterPlot = new ScatterPlot(this, new Rect<>(900, 300, 200, 200), dataProvider.getDataList());
        scatterPlot.intervalEvery(10, 100);
    }
    
    public void draw(){
        background(255);
        
        scatterPlotMatrix.draw();
        
        // Assignment B
        scatterPlot.draw();
        scatterPlot.drawAxis();
        scatterPlot.drawHelpLines();
    }
    
}
