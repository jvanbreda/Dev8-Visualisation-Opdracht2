/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jesseandswen.dev8.scatterplots.Models;

import com.jesseandswen.dev8.scatterplots.Canvas;
import processing.core.PApplet;

/**
 *
 * @author Jesse
 */
public class Legend {
    
    private Rect<Integer> area;
    
    private final PApplet applet;
    private final String[] content;
    private final int margin = 30;
    private final int linespace = 15;

    public Legend(Rect area, PApplet applet) {
        this.area = area;
        this.applet = applet;
        this.content = new String[]{"= Cat1", "= Cat2", "= Cat3", "= Cat4"};
    }
    
    public void draw(){
        applet.fill(255);
        applet.stroke(0);
        applet.rect(area.x, area.y, area.width, area.height);
        String text = "";
        for (int i = 1; i <= 4; i++) {
            text = content[i-1];
            switch(i){
                case 1:
                    applet.stroke(Rgb.RED.getR(), Rgb.RED.getG(), Rgb.RED.getB());
                    applet.fill(Rgb.RED.getR(), Rgb.RED.getG(), Rgb.RED.getB());
                    break;
                case 2:
                    applet.stroke(Rgb.BLUE.getR(), Rgb.BLUE.getG(), Rgb.BLUE.getB());
                    applet.fill(Rgb.BLUE.getR(), Rgb.BLUE.getG(), Rgb.BLUE.getB());
                    break;
                case 3:
                    applet.stroke(Rgb.GREEN.getR(), Rgb.GREEN.getG(), Rgb.GREEN.getB());
                    applet.fill(Rgb.GREEN.getR(), Rgb.GREEN.getG(), Rgb.GREEN.getB());
                    break;
                case 4:
                    applet.stroke(Rgb.PINK.getR(), Rgb.PINK.getG(), Rgb.PINK.getB());
                    applet.fill(Rgb.PINK.getR(), Rgb.PINK.getG(), Rgb.PINK.getB());
                    break;
            }
            
            applet.ellipse(area.x + margin, area.y + (linespace * i), 5, 5);
            applet.fill(0);
            applet.text(text, area.x + margin + 10, area.y + (linespace * i));
            
        }
        
    }
    
}
