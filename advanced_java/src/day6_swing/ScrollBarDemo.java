package day6_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollBarDemo extends JFrame implements ActionListener {
    static final int WIDTH = 300;
    static final int HEIGHT = 500;

    public static final int LINES = 15;
    public static final int CHAR_PER_LINE = 30;

    private JTextArea message;

    public ScrollBarDemo() throws HeadlessException {
        super("Confirm window");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        //setLayout(new BorderLayout());

        getContentPane().setBackground(Color.BLUE);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);
        btnPanel.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        btnPanel.add(btnClear);

        add(btnPanel, BorderLayout.SOUTH);

        message = new JTextArea(LINES, CHAR_PER_LINE);
        message.setLineWrap(true);
        message.setWrapStyleWord(false);

        JScrollPane scrollPane = new JScrollPane(message);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Add")) {
            message.append("This is a test.. ");
        } else if (cmd.equals("Clear")) {
            message.setText("");
        } else {
            System.out.println("System error!!!!");
        }
    }

    public static void main(String[] args) {
        ScrollBarDemo wnd = new ScrollBarDemo();
        wnd.setVisible(true);
    }
}
