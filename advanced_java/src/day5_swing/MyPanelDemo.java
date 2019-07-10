package day5_swing;

import javax.swing.*;

public class MyPanelDemo {
    public static void main(String[] args) {
        MyPanel panel = new MyPanel();

        JFrame app = new JFrame();

        app.add(panel);
        app.setTitle("My Application");
        app.setSize(400, 400);

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.setLocationRelativeTo(null);    // set center of screen

        app.setVisible(true);
    }
}
