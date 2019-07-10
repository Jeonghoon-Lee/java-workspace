package day5_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDemo extends JFrame implements ActionListener {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    private JPanel redPanel;
    private JPanel whitePanel;
    private JPanel bluePanel;

    public PanelDemo() throws HeadlessException {
        super("Panel Demo");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // create container panel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(1, 3));

        redPanel = new JPanel();
        redPanel.setBackground(Color.LIGHT_GRAY);
        containerPanel.add(redPanel);

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.LIGHT_GRAY);
        containerPanel.add(whitePanel);

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.LIGHT_GRAY);
        containerPanel.add(bluePanel);

        add(containerPanel, BorderLayout.CENTER);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton redButton = new JButton("Red");
        redButton.setBackground(Color.RED);
        redButton.addActionListener(this);
        buttonPanel.add(redButton);

        JButton whiteButton = new JButton("White");
        whiteButton.setBackground(Color.WHITE);
        whiteButton.addActionListener(this);
        buttonPanel.add(whiteButton);

        JButton blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(this);
        buttonPanel.add(blueButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // create menus
        JMenu menu = new JMenu("Color menu");

        JMenuItem redMenuItem = new JMenuItem("Red");
        redMenuItem.setBackground(Color.RED);
        redMenuItem.addActionListener(this);
        menu.add(redMenuItem);

        JMenuItem whiteMenuItem = new JMenuItem("White");
        whiteMenuItem.addActionListener(this);
        menu.add(whiteMenuItem);

        JMenuItem blueMenuItem = new JMenuItem("Blue");
        blueMenuItem.addActionListener(this);
        menu.add(blueMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonString = e.getActionCommand();

        switch (buttonString) {
            case "Red":
                redPanel.setBackground(Color.RED);
                break;
            case "White":
                whitePanel.setBackground(Color.WHITE);
                break;
            case "Blue":
                bluePanel.setBackground(Color.BLUE);
                break;
            default:
                System.out.println("Unexpected error");
                break;
        }
    }

    public static void main(String[] args) {
        PanelDemo wnd = new PanelDemo();
        wnd.setVisible(true);
    }
}

