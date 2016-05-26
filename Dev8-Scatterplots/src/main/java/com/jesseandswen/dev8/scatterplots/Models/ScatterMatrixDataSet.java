/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots.Models;

import java.util.List;

/**
 *
 * @author swenm_000
 */

// CAN JUST BE A HASHMAP!!!
@Deprecated
public class ScatterMatrixDataSet {
    private String[] columnNames;
    private StudentModel[][] dataSet;

    public ScatterMatrixDataSet() { }
    
    public ScatterMatrixDataSet(String[] columnNames, StudentModel[][] dataSet) {
        this.columnNames = columnNames;
        this.dataSet = dataSet;
    }
    
//    public ScatterMatrixDataSet(String[] columnNames, List<StudentModel> dataList) {
//        this.columnNames = columnNames;
//        
//        int size = dataList.size();
//        
//        float[] studentNumbers = new float[size];
//        float[] studentAge = new float[size];
//        float[] ana = new float[size];
//        float[] dev = new float[size];
//        float[] prj = new float[size];
//        float[] skl = new float[size];
//
//        for (int i = 0; i < dataList.size(); i++) {
//            studentNumbers[i] = dataList.get(i).getStnr();
//            studentAge[i] = dataList.get(i).getLftd();
//            ana[i] = dataList.get(i).getAna();
//            dev[i] = dataList.get(i).getDev();
//            prj[i] = dataList.get(i).getPrj();
//            skl[i] = dataList.get(i).getSkl();
//        }
//        
//        float[][] dataSet = new float[6][size];
//    
//        dataSet[0] = studentNumbers;
//        dataSet[1] = studentAge;
//        dataSet[2] = ana;
//        dataSet[3] = dev;
//        dataSet[4] = prj;
//        dataSet[5] = skl;
//        
//        this.dataSet = dataSet;
//    }
    
    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public StudentModel[][] getDataSet() {
        return dataSet;
    }

    public void setDataSet(StudentModel[][] dataSet) {
        this.dataSet = dataSet;
    }
}
