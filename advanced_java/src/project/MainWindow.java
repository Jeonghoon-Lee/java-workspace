package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements ActionListener {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 400;

    private boolean mousePressed;

    private JButton startPauseButton;
    private JButton ResetButton;
    private JButton speedUpButton;
    private JButton speedDownButton;

    private JLabel speedLabel;

    private MovingBoatThread movingBoatThread;

    private Boat boat;

    public MainWindow() throws HeadlessException {
        super("Final Project - Jeonghoon");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        initComponent();
    }

    private void initComponent() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        startPauseButton = new JButton("Start");
        startPauseButton.setIcon(new ImageIcon("res/icons8-start-24.png"));
        startPauseButton.addActionListener(this);
        buttonPanel.add(startPauseButton);

        ResetButton = new JButton("Reset");
        ResetButton.setIcon(new ImageIcon("res/icons8-reset-24.png"));
        ResetButton.addActionListener(this);
        buttonPanel.add(ResetButton);

        // add gap between component
        buttonPanel.add(Box.createHorizontalStrut(20));

        speedDownButton = new JButton(new ImageIcon("res/icons8-down-24.png"));
        speedDownButton.setActionCommand("speedDown");
        speedDownButton.setToolTipText("Speed down");
        speedDownButton.addActionListener(this);
        // add mouse listener to catch mousePressed event
        speedDownButton.addMouseListener(new MousePressHandler());

        buttonPanel.add(speedDownButton);

        // add gap between component
        buttonPanel.add(Box.createHorizontalStrut(3));

        speedLabel = new JLabel(String.format("%d", MovingBoatThread.INIT_BOAT_SPEED));
        speedLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        speedLabel.setForeground(Color.RED);
        buttonPanel.add(speedLabel);

        // add gap between component
        buttonPanel.add(Box.createHorizontalStrut(3));

        speedUpButton = new JButton(new ImageIcon("res/icons8-up-24.png"));
        speedUpButton.setActionCommand("speedUp");
        speedUpButton.setToolTipText("Speed up");
        speedUpButton.addActionListener(this);
        // add mouse listener to catch mousePressed event
        speedUpButton.addMouseListener(new MousePressHandler());

        buttonPanel.add(speedUpButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // create a boat
        boat = new Boat();
        add(boat, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Start":
                startMovingBoat();
                break;
            case "Pause":
                pauseBoat();
                break;
            case "Resume":
                resumeBoat();
                break;
            case "Reset":
                resetBoat();
                break;
            case "speedUp":
                speedUp();
                break;
            case "speedDown":
                speedDown();
                break;
        }
    }

    private void startMovingBoat() {
        movingBoatThread = new MovingBoatThread(boat);
        movingBoatThread.setBoatSpeed(Integer.parseInt(speedLabel.getText()));
        movingBoatThread.start();

        startPauseButton.setText("Pause");
        startPauseButton.setIcon(new ImageIcon("res/icons8-pause-24.png"));
    }

    private void pauseBoat() {
        movingBoatThread.setMovingBoat(false);

        startPauseButton.setText("Resume");
        startPauseButton.setIcon(new ImageIcon("res/icons8-resume-24.png"));
    }

    private void resumeBoat() {
        movingBoatThread.setMovingBoat(true);

        startPauseButton.setText("Pause");
        startPauseButton.setIcon(new ImageIcon("res/icons8-pause-24.png"));
    }

    private void resetBoat() {
        if (movingBoatThread != null) {
            movingBoatThread.setMovingBoat(false);
            movingBoatThread.setExitThread(true);
        }
        startPauseButton.setText("Start");
        startPauseButton.setIcon(new ImageIcon("res/icons8-start-24.png"));

        speedLabel.setText(String.format("%d", MovingBoatThread.INIT_BOAT_SPEED));

        boat.setxPosition(Boat.INIT_X);
        boat.repaint();
    }

    private int getBoatSpeed() {
        return (movingBoatThread == null) ? Integer.parseInt(speedLabel.getText()) : movingBoatThread.getBoatSpeed();
    }

    private void setBoatSpeed(int boatSpeed) {
        if (movingBoatThread != null) {
            movingBoatThread.setBoatSpeed(boatSpeed);
        }
        speedLabel.setText(String.format("%d", boatSpeed));
    }

    private void speedUp() {
        int boatSpeed = getBoatSpeed();

        if (boatSpeed >= MovingBoatThread.MAX_BOAT_SPEED) return;

        setBoatSpeed(boatSpeed + 1);
    }

    private void speedDown() {
        int boatSpeed = getBoatSpeed();

        if (boatSpeed <= MovingBoatThread.MIN_BOAT_SPEED) return;

        setBoatSpeed(boatSpeed - 1);
    }

    private class MousePressHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;

            new Thread(() -> {
                String btnName = ((JButton)e.getSource()).getActionCommand();

                final int MIN_SPEED_CHANGE_INTERVAL = 10;   // msec
                final int MIN_BUTTON_PRESSED_TIME = 300;    // msec

                int speedChangeInterval = 500;     // msec
                int buttonPressedTime = 0;
                int loopCounter = 1;

                while (mousePressed) {
                    try {
                        // Waiting time to increase the speed value
                        if (buttonPressedTime < MIN_BUTTON_PRESSED_TIME) {
                            Thread.sleep(MIN_SPEED_CHANGE_INTERVAL);
                            buttonPressedTime += MIN_SPEED_CHANGE_INTERVAL;
                            continue;
                        }

                        if (btnName == "speedUp") {
                            speedUp();
                        } else {
                            speedDown();
                        }

                        if (speedChangeInterval > MIN_SPEED_CHANGE_INTERVAL) {
                            speedChangeInterval /= loopCounter++;
                            Thread.sleep(speedChangeInterval);
                        } else {
                            Thread.sleep(MIN_SPEED_CHANGE_INTERVAL);
                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
