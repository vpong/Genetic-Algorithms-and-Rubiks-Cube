package nonogram.gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;

import java.util.*;

import nonogram.Nonogram;

public class Canvas extends JPanel {

    Nonogram nonogram;
    int SQ_WIDTH = 20;
    int LABEL_WIDTH = 60;
    int LABEL_HEIGHT = 70;

    public Canvas() {
    }

    public void setNonogram(Nonogram nonogram) {
        this.nonogram = nonogram;

        int gridWidth = SQ_WIDTH * nonogram.getColumnHeaders().size();
        int gridHeight = SQ_WIDTH * nonogram.getRowHeaders().size();

        int panelWidth = gridWidth + LABEL_WIDTH;
        int panelHeight = gridHeight + LABEL_HEIGHT;

        setPreferredSize(new Dimension(panelWidth, panelHeight));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getBounds().width, getBounds().height);

        int x = LABEL_WIDTH;
        int y = LABEL_HEIGHT;

        g.setColor(Color.GRAY);

        for (ArrayList<Integer> header : nonogram.getColumnHeaders()) {
            g.drawLine(x, 0, x, getBounds().height);

            int step = 15;
            int yLabel = 15;
            
            for (Integer number : header) {
                g.drawString(number.toString(), x + 6, yLabel);
                yLabel += step;
            }

            x += SQ_WIDTH;
        }

        for (ArrayList<Integer> header : nonogram.getRowHeaders()) {
            g.drawLine(0, y, getBounds().width, y);
            y += SQ_WIDTH;

            String label = "";
            
            for (Integer number : header) {
                label += number.toString() + " ";
            }
            
            g.drawString(label, 5, y - 5);
        }




    }
}
