package day5_swing;

import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame extends JFrame {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    public static void main(String[] args) {
        GridLayoutFrame wnd = new GridLayoutFrame();
        wnd.setVisible(true);
    }

    public GridLayoutFrame(int width, int height) throws HeadlessException {
        super("Grid Layout Demo");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 3));

        JLabel label = new JLabel("First Label");
        add(label);

        add(new JLabel("Second Label"));
        add(new JLabel("Third Label"));
        add(new JLabel("Fourth Label"));
        add(new JLabel("Five Label"));
    }

    public GridLayoutFrame() throws HeadlessException {
        this(WIDTH, HEIGHT);
    }
}
