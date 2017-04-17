package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nurgalievtr.18 on 10.04.2017.
 */
public class Line extends JPanel {
    public double k;
    public double b;

    Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawLine(0, (int)Math.round(b), (int)Math.round((getHeight() - b) / (k)), getHeight());
        g.setColor(Color.red);
    }
}
