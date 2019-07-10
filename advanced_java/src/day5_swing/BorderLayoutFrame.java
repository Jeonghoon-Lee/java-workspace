package day5_swing;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutFrame extends JFrame {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    public BorderLayoutFrame() throws HeadlessException {
        super("");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel label = new JLabel("First Label");
        add(label, BorderLayout.NORTH);

        add(new JLabel("Second Label"), BorderLayout.SOUTH);
        add(new JLabel("Third Label"), BorderLayout.CENTER);
        add(new JLabel("Fourth Label"), BorderLayout.EAST);
        add(new JLabel("Five Label"), BorderLayout.WEST);
    }
}
