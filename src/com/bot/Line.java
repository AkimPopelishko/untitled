package com.bot;

import javax.swing.*;
import java.awt.*;
import static java.lang.System.*;

/**
 * Created by nurgalievtr.18 on 10.04.2017.
 */
public class Line extends JPanel {
    public static int width=1500;
    public static int height=1000;
    public double k;
    public double b;

    Line(double k, double b) {
        this.k = k;
        this.b = b;
    }
    public static double[] getEndpoints(double k, double b){
        double[] arr=new double[4];
        boolean f=false;
        if (b<height && b>0){
            arr[0]=0;
            arr[1]=b;
            f=true;
        }
        if (-b/k<width && -b/k>0)
            if (f) {
                arr[2] = -b / k;
                arr[3] = 0;
                return arr;
        }
            else {
                arr[0] = -b / k;
                arr[1] = 0;
                f = true;
        }
        if ((height-b)/k<width && (height-b)/k>0)
            if (f) {
                arr[2] = (height-b)/k;
                arr[3] = width;
                return arr;
            } else {
                arr[0] = (height-b)/k;
                arr[1] = width;
                f = true;
            }
        if (k * width + b < height && k * width + b > 0 && f) {
            arr[2] = k * width + b;
            arr[3] = height;
            return arr;
        }
        err.println("Ошибка в методе getEndpoints: не могу найти точки пересечения");
        return null;
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        double[] arr=new double[4];
        arr=getEndpoints(k,b);
        g.drawLine((int)Math.round(arr[0]), (int)Math.round(arr[1]), (int)Math.round(arr[2]), (int)Math.round(arr[3]));
        g.setColor(Color.red);
    }
}
