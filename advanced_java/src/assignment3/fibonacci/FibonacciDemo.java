package assignment3.fibonacci;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciDemo extends JFrame implements ActionListener {

    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    private JTextField inputText;
    private JTextArea resultText;

    public FibonacciDemo() throws HeadlessException {
        super("Fibonacci Demo - Jeonghoon");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);    // set starting position to center of screen
        setLayout(new BorderLayout());

        // create container panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputPanel.setLayout(new GridLayout(3, 1));

        // input label
        inputPanel.add(new JLabel("Enter the positive integer: "));
        // input text field
        inputText = new JTextField();
        inputPanel.add(inputText);
        // button
        JButton button = new JButton("Generate Fibonacci number");
        button.setBackground(Color.ORANGE);
        button.addActionListener(this);
        inputPanel.add(button);

        add(inputPanel, BorderLayout.NORTH);

        // create container panel
        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        resultPanel.setLayout(new BorderLayout());

        // create JLabel for displaying result
        resultText = new JTextArea("Result:\n");
        resultText.setEnabled(false);
        resultText.setLineWrap(true);
        resultText.setWrapStyleWord(true);
        resultText.setBackground(Color.DARK_GRAY);
        resultPanel.add(resultText, BorderLayout.CENTER);

        add(resultPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // clear result
            resultText.setText("Result:\n");

            // print Fibonacci Numbers
            printFibonacciNumbers(Integer.parseInt(inputText.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input data.\nPlease enter positive integer.",
                    "Fibonacci Demo - Jeonghoon",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void printFibonacciNumbers(int number) {
        for (int i=1; i<=number; i++) {
            // for display
            resultText.append((i == 1) ? "" : ", ");
            // print fibonacci number
            resultText.append(String.format("%d", Fibonacci.get(i)));
        }
    }

    public static void main(String[] args) {
        FibonacciDemo mainWnd = new FibonacciDemo();
        mainWnd.setVisible(true);
    }
}
