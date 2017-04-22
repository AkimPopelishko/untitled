package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static int width=1500;
    public static int height=1000;
    private static ArrayList<Line> points = new ArrayList<Line>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Субъект");
	    frame.setPreferredSize(new Dimension(width,height));
	    JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,height));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);

	    JLabel addPointwithCoords = new JLabel("Добавить прямую");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
        JLabel X = new JLabel("Угловой коэффициент:");
        X.setBounds(2,25,140,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Cмещение:");
        Y.setBounds(2,45,75,25);
        butPanel.add(Y);
        final JTextField x = new JTextField();
        x.setBackground(Color.yellow);
        x.setBounds(140,25, 100,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(70,50, 100,25);
        y.setBackground(Color.yellow);
        butPanel.add(y);

        JButton button1 = new JButton("Добавить прямую");
        button1.setBounds(2,100,160,40);
        button1.setBackground(Color.yellow);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double X = (!x.getText().equals("")?Double.parseDouble(x.getText()):0);
                double Y= (!y.getText().equals("")?Double.parseDouble(y.getText()):0);
                if ((X>0)&&(Y>0)) {
                    Line b = new Line(X, Y);
                    points.add(b);
                    double[] arr=new double[4];
                    arr=Line.getEndpoints(b.k,b.b);
                    b.setBounds((int)Math.round(arr[0]), (int)Math.round(arr[1]), (int)Math.round(arr[2]), (int)Math.round(arr[3]));
                    pointpane.add(b);
                    pointpane.repaint();
                }

            }
        });
        JButton button2 = new JButton("очистить");
        button2.setBackground(Color.yellow);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Line point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });
        button2.setBounds(2,150,160,40);
        butPanel.add(button2);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();}});}}