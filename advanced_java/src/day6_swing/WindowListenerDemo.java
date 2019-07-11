package day6_swing;

import day5_swing.PanelDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;
    static final int SMALL_WIDTH = 200;
    static final int SMALL_HEIGHT = 100;

    private class CheckExit implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            ConfirmWindow wnd = new ConfirmWindow();
            wnd.setVisible(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    private class ConfirmWindow extends JFrame implements ActionListener {

        public ConfirmWindow() throws HeadlessException {
            super("Confirm window");

            setSize(SMALL_WIDTH, SMALL_HEIGHT);
//            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            setLocationRelativeTo(this);
            setLayout(new BorderLayout());

            getContentPane().setBackground(Color.orange);

            add(new JLabel("Press Ok to exit"), BorderLayout.CENTER);

            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new FlowLayout());

            JButton btnOk = new JButton("OK");
            btnOk.addActionListener(this);
            btnPanel.add(btnOk);

            JButton btnNo = new JButton("NO");
            btnNo.addActionListener(this);
            btnPanel.add(btnNo);

            add(btnPanel, BorderLayout.SOUTH);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            if (action.equals("OK")) {
                System.exit(0);
            } else if (action.equals("NO")) {
                dispose();
            } else {
                System.out.println("Internal system error!!!!");
            }
        }
    }

    public WindowListenerDemo() throws HeadlessException {
        super("Window Listener Demo");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckExit());

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.LIGHT_GRAY);

        add(new JLabel("This is a Window Listener Demo."), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        WindowListenerDemo wnd = new WindowListenerDemo();
        wnd.setVisible(true);
    }
}

