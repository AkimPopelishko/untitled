package com.bot;

import javax.swing.*;
import java.awt.*;
import static java.lang.System.*;

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
        double[] arr=new double[4];   //массив из четырёх координат двух точек
        boolean f=false;   //становится true, когда найдена первая точка пересечения с краями окна
        if (b<height && b>0){   //точка на левом крае
            arr[0]=0;
            arr[1]=b;
            f=true;
            System.out.println("левый край (1): "+arr[0]+";"+arr[1]);
        }
        if (-b/k<width && -b/k>0)   //точка на верхнем крае
            if (f) {
                arr[2] = -b / k;
                arr[3] = 0;
                System.out.println("верхний край (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else {
                arr[0] = -b / k;
                arr[1] = 0;
                f = true;
                System.out.println("верхний край (1): "+arr[0]+";"+arr[1]);
            }
        if ((height-b)/k<width && (height-b)/k>0)  //точка на верхнем крае
            if (f) {
                arr[2] = (height-b)/k;
                arr[3] = height;
                System.out.println("нижний край (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else {
                arr[0] = (height-b)/k;
                arr[1] = height;
                f = true;
                System.out.println("нижний край (1): "+arr[0]+";"+arr[1]);
            }
        if (k * width + b < height && k * width + b > 0)        //точка на правом крае
            if (f) {
                arr[2] = width;
                arr[3] = k * width + b;
                System.out.println("правый край (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else{
                arr[0] = width;
                arr[1] = k * width + b;
                System.out.println("правый край (1): "+arr[0]+";"+arr[1]);
                f=true;
            }
        if (b==0)
            if (f) {
                arr[2]=0;
                arr[3]=0;
                System.out.println("левый верхний угол (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else{
                arr[0]=0;
                arr[1]=0;
                System.out.println("левый верхний угол (1): "+arr[0]+";"+arr[1]);
                f = true;
            }
        if (b==height)
            if (f) {
                arr[2]=0;
                arr[3]=height;
                System.out.println("левый нижний угол (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else{
                arr[0]=0;
                arr[1]=height;
                System.out.println("левый нижний угол (1): "+arr[0]+";"+arr[1]);
                f = true;
            }
        if (k*width+b==0)
            if (f) {
                arr[2]=width;
                arr[3]=0;
                System.out.println("правый верхний угол (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else{
                arr[0]=width;
                arr[1]=0;
                System.out.println("правый верхний угол (1): "+arr[0]+";"+arr[1]);
                f = true;
            }
        if (k*width+b==height)
            if (f) {
                arr[2]=width;
                arr[3]=height;
                System.out.println("правый нижний угол (2): "+arr[2]+";"+arr[3]);
                return arr;
            }
            else{
                arr[0]=width;
                arr[1]=height;
                System.out.println("правый нижний угол (1): "+arr[0]+";"+arr[1]);
                f = true;
            }
        err.println("Ошибка в методе getEndpoints: не могу найти точки пересечения");   //если почему-то найдено меньше двух точек
        return null;
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        double[] arr=new double[4];
        arr=getEndpoints(k,b);
        g.drawLine((int)Math.round(arr[0]), (int)Math.round(arr[1]), (int)Math.round(arr[2]), (int)Math.round(arr[3]));
        System.out.println((int)Math.round(arr[0])+" " + (int)Math.round(arr[1])+  " "+ (int)Math.round(arr[2])+ "  "+ (int)Math.round(arr[3]));
        g.setColor(Color.red);
    }
}
