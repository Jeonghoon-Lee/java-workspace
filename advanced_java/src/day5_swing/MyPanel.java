package day5_swing;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class MyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        // example 1
//        g.setColor(Color.blue);
//        g.drawLine(0, 0, w, h);

        // line width can use Graphics2D
        // Graphics2D g2 = (Graphics2D) g;
        // g2.setStroke(new BasicStroke(3));

        // example 2
//        int n = 40;
//
//        for (int i=0; i <= n; i++) {
//            int j = n - i;
//
//            g.setColor(new Color(255-i, 0, 0)); // Color.red);
//            g.drawLine(i*w/n, 0, 0, j*h/n);
//
//            g.setColor(new Color(0, 0, 255-j)); // Color.blue);
//            g.drawLine(i*w/n, h, w, j*h/n);
//        }

        // example 3
        g.setColor(Color.yellow);
        g.fillRect(20, 20, 200, 150);

        g.setColor(Color.red);
        g.drawRect(20, 20, 200, 150);

        // g.setColor(Color.yellow);
        g.drawOval(250, 20, 100, 150);

        g.setColor(Color.green);
        g.fillOval(50, 200, 150, 150);

        g.setColor(Color.black);
        g.drawOval(50, 200, 150, 150);

        g.drawString("Welcome to Java!", 50, 50);
    }
}
