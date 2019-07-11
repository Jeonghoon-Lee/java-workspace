package assignment4;

import javax.swing.*;
import java.awt.*;

public class Boat extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 350;

    private static final int INIT_X = 30;
    private static final int INIT_Y = 200;

    private static final int BOAT_HEIGHT = 50;
    private static final int BOAT_WIDTH = 200;

    private static final int BOAT_TOP_HEIGHT = 30;

    private static final int BOAT_DIAGONAL_WIDTH = 25;
    private static final int BOAT_BOTTOM_START_ANGLE = 180;
    private static final int BOAT_BOTTOM_ARC_ANGLE = 180;

    private static final int MAST_X = BOAT_WIDTH / 2;
    private static final int MAST_Y = INIT_Y;
    private static final int MAST_TOP_Y = 50;

    private static final int SAIL_TOP_X = MAST_X;
    private static final int SAIL_BOTTOM_X = 0;
    private static final int SAIL_TOP_Y = MAST_TOP_Y;
    private static final int SAIL_BOTTOM_Y = INIT_Y - BOAT_TOP_HEIGHT;

    private static final int MOVE_AMOUNT = 10;

    private static final int NAME_ANGLE = 50;
    private static final int NAME_X = 40;
    private static final int NAME_Y = 150;
    private static final String MY_NAME = "JEONGHOON";

    private int xPosition = INIT_X;
    private Color boatColor = Color.BLACK;

    public Boat() {
        super("Graphics Demonstration 2");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        JButton button = new JButton("Move the boat");
        button.addActionListener(e -> {
            xPosition += MOVE_AMOUNT;
            boatColor = boatColor.brighter();

            // for debugging
            System.out.println(boatColor);

            repaint();
        });
        add(button, BorderLayout.SOUTH);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(boatColor);

        // draw left/right diagonal line
        g.drawLine(xPosition, INIT_Y, xPosition + BOAT_DIAGONAL_WIDTH, INIT_Y + BOAT_HEIGHT);
        g.drawLine(xPosition + BOAT_WIDTH, INIT_Y,
                xPosition + BOAT_WIDTH - BOAT_DIAGONAL_WIDTH, INIT_Y + BOAT_HEIGHT);

        // draw top shape
        g.drawOval(xPosition, INIT_Y - (BOAT_TOP_HEIGHT / 2), BOAT_WIDTH, BOAT_TOP_HEIGHT);

        // draw bottom line
        g.drawArc(xPosition + BOAT_DIAGONAL_WIDTH, INIT_Y + BOAT_HEIGHT - 15,
                BOAT_WIDTH - 2 * BOAT_DIAGONAL_WIDTH, BOAT_TOP_HEIGHT,
                BOAT_BOTTOM_START_ANGLE, BOAT_BOTTOM_ARC_ANGLE);

        // draw sail
        g.drawLine(xPosition + SAIL_BOTTOM_X, SAIL_BOTTOM_Y, xPosition + SAIL_TOP_X, SAIL_BOTTOM_Y);
        g.drawLine(xPosition + SAIL_BOTTOM_X, SAIL_BOTTOM_Y, xPosition + SAIL_TOP_X, SAIL_TOP_Y);

        // draw text
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(xPosition + NAME_X, NAME_Y);
        g2.rotate(Math.toRadians(-NAME_ANGLE));
        g2.drawString(MY_NAME, 0, 0);

        // recover original position
        g2.rotate(Math.toRadians(NAME_ANGLE));
        g2.translate(-(xPosition + NAME_X), -NAME_Y);

        // draw mast
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(xPosition + MAST_X, MAST_Y, xPosition + MAST_X, MAST_TOP_Y);
    }

    public static void main(String[] args) {
        Boat drawing = new Boat();
        drawing.setVisible(true);
    }
}
