package day5_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingFrame extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;

    public MySwingFrame() throws HeadlessException {
        super();

        setSize(WIDTH, HEIGHT);
        setTitle("My first swing window");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JButton button = new JButton("Close window");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(button);
    }
}
