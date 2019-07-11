package day6_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class Face extends JFrame {
    static final int WIDTH = 400;
    static final int HEIGHT = 400;

    public static final int FACE_DIAMETER = 200;
    static final int X_FACE = 100;
    static final int Y_FACE = 100;

    public static final int EYE_WIDTH = 20;
    public static final int X_RIGHT_EYE = X_FACE + 55;
    public static final int Y_RIGHT_EYE = Y_FACE + 60;
    public static final int X_LEFT_EYE = X_FACE + 130;
    public static final int Y_LEFT_EYE = Y_FACE + 60;


    public static final int MOUTH_WIDTH = 100;
    public static final int MOUTH_HEIGHT = 50;

    public static final int X_MOUTH = X_FACE + 50;
    public static final int Y_MOUTH = Y_FACE + 150;

    public static final int MOUTH_START_ANGLE = 180;
    public static final int MOUTH_ARC_SWEEP = 180;

    public Face() throws HeadlessException {
        super("First Graphics Demo");
        setSize(WIDTH, HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);

        g.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);

        //Draw Eyes:
        //g.drawLine(X_RIGHT_EYE, Y_RIGHT_EYE,
        //         X_RIGHT_EYE + EYE_WIDTH,Y_RIGHT_EYE);
        g.drawLine(X_LEFT_EYE, Y_LEFT_EYE,
                X_LEFT_EYE + EYE_WIDTH, Y_LEFT_EYE);

        g.drawArc(X_RIGHT_EYE, Y_RIGHT_EYE, X_RIGHT_EYE + EYE_WIDTH, Y_RIGHT_EYE, 0, 180);

        //Draw Mouth:
        // g.drawLine(X_MOUTH, Y_MOUTH, X_MOUTH + MOUTH_WIDTH, Y_MOUTH);

        //Draw Mouth:
        g.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, MOUTH_ARC_SWEEP);
    }

    public static void main(String[] args) {
        Face wnd = new Face();
        wnd.setVisible(true);
    }
}
