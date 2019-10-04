package com.javacodegeeks.snippets.desktop;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Main {

    public static void main(String[] args) {

// Create a frame

        Frame frame = new Frame();

// Add a component with a custom paint method

        frame.add(new CustomPaintComponent());

// Display the frame

        int frameWidth = 300;

        int frameHeight = 300;

        frame.setSize(frameWidth, frameHeight);

        frame.setVisible(true);

    }

    /**
     * To draw on the screen, it is first necessary to subclass a Component and
     * override its paint() method. The paint() method is automatically called
     * by the windowing system whenever component's area needs to be repainted.
     */
    static class CustomPaintComponent extends Component {

        public void paint(Graphics g) {

            // Retrieve the graphics context; this object is used to paint shapes

            Graphics2D g2d = (Graphics2D) g;

/**
 * The coordinate system of a graphics context is such that the
 * origin is at the northwest corner and x-axis increases toward the
 * right while the y-axis increases toward the bottom.
 */

            int x = 0;

            int y = 10;

            // Set the desired font if different from default font

            Font font = new Font("Serif", Font.PLAIN, 12);

            g2d.setFont(font);

            // Draw a string such that its base line is at x, y

            g2d.drawString("This is a test string", x, y);

            FontMetrics fontMetrics = g2d.getFontMetrics();

            // Draw a string such that the top-left corner is at x, y

            g2d.drawString("This is another test string", x, y+fontMetrics.getAscent());

            // Draw string rotated clockwise 90 degrees

            AffineTransform affineTransform = new AffineTransform();

            affineTransform.setToRotation(Math.PI/2.0);

            g2d.setTransform(affineTransform);

            g2d.drawString("This is a vertical test string", x, y+2*fontMetrics.getAscent());

            // Draw string rotated counter-clockwise 90 degrees

            affineTransform = new AffineTransform();

            affineTransform.setToRotation(-Math.PI/2.0);

            g2d.setTransform(affineTransform);

            g2d.drawString("This is a another vertical test string", x + fontMetrics.getAscent(), y + 2*fontMetrics.getAscent() + fontMetrics.stringWidth("This is a another vertical test string"));

        }

    }

}