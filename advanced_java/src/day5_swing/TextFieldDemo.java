package day5_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo extends JFrame implements ActionListener {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    private JPanel redPanel;
    private JPanel whitePanel;
    private JPanel bluePanel;

    JLabel message;
    JTextField name;

    public TextFieldDemo() throws HeadlessException {
        super("Text Field Demo");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        // create container panel
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout());

        name = new JTextField("Enter the name", 10);
        textFieldPanel.add(name, BorderLayout.SOUTH);

        message = new JLabel("Welcome to");
        textFieldPanel.add(message);

        add(textFieldPanel, BorderLayout.CENTER);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton displayBtn = new JButton("Display");
        displayBtn.setBackground(Color.RED);
        displayBtn.addActionListener(this);
        buttonPanel.add(displayBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBackground(Color.WHITE);
        clearBtn.addActionListener(this);
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonString = e.getActionCommand();

        switch (buttonString) {
            case "Display":
                message.setText("Welcome to " + name.getText());
                break;
            case "Clear":
                message.setText("");
                break;
            default:
                System.out.println("Unexpected error");
                break;
        }
    }

    public static void main(String[] args) {
        TextFieldDemo wnd = new TextFieldDemo();
        wnd.setVisible(true);
    }
}

