package assignment3.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    static final String[] operators = { "+", "-", "*", "/", "%", "SQRT" };

    private JTextField inputText1;
    private JTextField inputText2;
    private JLabel resultLabel;

    public SimpleCalculator() throws HeadlessException {
        super("Simple Calculator - Jeonghoon");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);    // set starting position to center of screen
        setLayout(new GridLayout(2, 1));

        // create container panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputPanel.setLayout(new GridLayout(3, 1));

        // create input field
        inputText1 = new JTextField("Enter first operand:");
        inputPanel.add(inputText1);

        inputText2 = new JTextField("Enter second operand:");
        inputPanel.add(inputText2);

        // create JLabel for displaying result
        resultLabel = new JLabel("Result: ");
        inputPanel.add(resultLabel);

        add(inputPanel);

        // create container for buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        btnPanel.setBackground(Color.orange);

        for (String operator : operators) {
            JButton button = new JButton(operator);
            button.addActionListener(this);
            btnPanel.add(button);
        }

        add(btnPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double operand1 = Double.parseDouble(inputText1.getText());
            double operand2 = Double.parseDouble(inputText2.getText());

            switch (e.getActionCommand()) {
                case "+":
                    displayResult("+", operand1 + operand2);
                    break;
                case "-":
                    displayResult("-", operand1 - operand2);
                    break;
                case "*":
                    displayResult("*", operand1 * operand2);
                    break;
                case "/":
                    if (operand2 == 0) {
                        JOptionPane.showMessageDialog(this,
                                "Divide by 0\nPlease enter other number for second input!",
                                "Simple Calculator",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    displayResult("/", operand1 / operand2);
                    break;
                case "%":
                    if (operand2 == 0) {
                        JOptionPane.showMessageDialog(this,
                                "Divide by 0\nPlease enter other number for second input!",
                                "Simple Calculator",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    displayResult("%", operand1 % operand2);
                    break;
                case "SQRT":
                    resultLabel.setText(String.format("Result: sqrt(%s) = %.3f,  sqrt(%s) = %.3f",
                            inputText1.getText(), Math.sqrt(operand1),
                            inputText2.getText(), Math.sqrt(operand2))
                    );
                    break;
            }
        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input data.\nPlease enter number!",
                    "Simple Calculator",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void displayResult(String operator, double result) {
        resultLabel.setText(String.format("Result : %s %s %s = %.3f",
                inputText1.getText(),
                operator,
                inputText2.getText(),
                result)
        );
    }

    public static void main(String[] args) {
        SimpleCalculator mainWnd = new SimpleCalculator();
        mainWnd.setVisible(true);
    }
}
