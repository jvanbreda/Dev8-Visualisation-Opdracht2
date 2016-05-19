/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots.Data;

import com.jesseandswen.dev8.scatterplots.Models.DataModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class DataProvider {

    public String getData(URL url) {
        String allData = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            Iterator lines = br.lines().iterator();
            while (lines.hasNext()) {
                String line = (String) lines.next();
                if (!line.contains("CAT"))
                    allData += line + "\n";
            }
        } catch (IOException e) {
            System.err.println("IO Exception occured while reading the data!");
        }
        return allData;
    }

    public List<DataModel> getDataList() {
        List<DataModel> plots = new ArrayList<>();
        String data = "";
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("scatterplot.txt").getFile());
            data = getData(file.toURI().toURL());
        } catch (IOException e) {
            System.err.println("IO Exception occured while transforming data to list!");
        }
        
        Scanner fileScanner = new Scanner(data);
        fileScanner.useDelimiter("\n");
        
        while (fileScanner.hasNext()){
            String line = fileScanner.next();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\t");
            DataModel dm = new DataModel();
            dm.setCAT(Integer.parseInt(lineScanner.next()));
            dm.setEIG1(Integer.parseInt(lineScanner.next()));
            dm.setEIG2(Double.parseDouble((lineScanner.next()).replace(',', '.')));
            plots.add(dm);
        }
        
        return plots;
    }
}
