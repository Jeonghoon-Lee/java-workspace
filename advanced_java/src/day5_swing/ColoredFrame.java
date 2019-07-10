package day5_swing;

import javax.swing.*;
import java.awt.*;

public class ColoredFrame extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;

    public ColoredFrame(Color bgColor) throws HeadlessException {
        super("No Charge for Color");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(bgColor);

        JLabel label = new JLabel("Close-window button works.");
        add(label);
    }

    public ColoredFrame() throws HeadlessException {
        this(Color.yellow);
    }
}
