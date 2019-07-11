package day6_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IconDemo extends JFrame implements ActionListener {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;

    private JTextField message;
    private JLabel label1;
    private JLabel label2;

    public IconDemo() throws HeadlessException {
        super("Confirm window");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.orange);

        JLabel label = new JLabel("This is a Label");
        ImageIcon icon = new ImageIcon("res\\duke_waving.gif");
        label.setIcon(icon);

        add(label, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        JButton btnOk = new JButton("Happy");
        btnOk.addActionListener(this);
        btnOk.setIcon(new ImageIcon("res\\smiley.gif"));
        btnPanel.add(btnOk);

        JButton btnNo = new JButton("Sad");
        btnNo.addActionListener(this);
        btnNo.setIcon(new ImageIcon("res\\sad.gif"));
        btnPanel.add(btnNo);

        add(btnPanel, BorderLayout.SOUTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));

        message = new JTextField("This is text area");
        contentPanel.add(message);

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new FlowLayout());

        label1 = new JLabel(new ImageIcon("res\\smiley.gif"));
        label1.setVisible(true);
        iconPanel.add(label1);

        label2 = new JLabel(new ImageIcon("res\\sad.gif"));
        label2.setVisible(false);
        iconPanel.add(label2);

        contentPanel.add(iconPanel);

        add(contentPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Happy")) {
            message.setText("Happy");
            label1.setVisible(true);
            label2.setVisible(false);
        } else if (cmd.equals("Sad")) {
            message.setText("Sad");
            label1.setVisible(false);
            label2.setVisible(true);
        } else {
            System.out.println("System error!!!!");
        }
    }

    public static void main(String[] args) {
        IconDemo wnd = new IconDemo();
        wnd.setVisible(true);
    }
}
