package day6_swing;

import javax.swing.*;
import java.awt.*;

public class ColorChooserDemo extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;

    static final int FONT_SIZE = 20;

    Color sampleColor = Color.LIGHT_GRAY;
    Color penColor = Color.RED;

    Font fontStyle = new Font("SansSerif", Font.PLAIN, FONT_SIZE);

    public ColorChooserDemo() {
        super("Color Chooser Demo");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(sampleColor);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        JButton button = new JButton("Color chooser");
        button.addActionListener(e -> {
            sampleColor = JColorChooser.showDialog(this, "Color chooser", sampleColor);

            if (sampleColor != null) {
                getContentPane().setBackground(sampleColor);
            }
        });
        btnPanel.add(button);

        JButton button2 = new JButton("Change font");
        button2.addActionListener(e ->{
            penColor = Color.BLUE;
            fontStyle = new Font("Serif", Font.BOLD|Font.ITALIC, FONT_SIZE + 10);

            repaint();
        });
        btnPanel.add(button2);

        add(btnPanel, BorderLayout.SOUTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(penColor);
        g.setFont(fontStyle);
        g.drawString("This is test", 10, 100);
    }

    public static void main(String[] args) {
        ColorChooserDemo wnd = new ColorChooserDemo();
        wnd.setVisible(true);
    }
}
