package com.javacodegeeks.snippets.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Main {

    public static void main(String[] args){
        JFrame J = new JFrame("Up Next");
        Container c = J.getContentPane();
        Billboard Ca = new Billboard();
        c.add(Ca);
        J.setSize(1920, 1080);
        J.setVisible(true);
    }
}
class Billboard extends JComponent {

    public void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawString("Hello World", 70, 80);
        }
    }
}