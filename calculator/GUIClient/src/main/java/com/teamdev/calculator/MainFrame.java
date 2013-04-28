package com.teamdev.calculator;

import com.teamdev.calculator.impl.Calculator;
import com.teamdev.calculator.impl.EvaluationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

public class MainFrame extends JFrame  {
    private boolean visible;
    private JPanel mainPanel;
    private JLabel expressionLabel;
    private JLabel resultLabel;
    private JTextField expressionTextField;
    private JTextField resultTextField;
    private JButton calculateButton;
    private JButton exitButton;
    private Calculator calculator = new Calculator();

    public MainFrame(String caption) {
        super(caption);

        setBounds(400, 400, 500, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initControls();
    }

    private void initControls() {
        mainPanel = new JPanel(null);

        expressionLabel = new JLabel("Expression");
        expressionLabel.setBounds(15, 20, 70, 20);
        mainPanel.add(expressionLabel);

        expressionTextField = new JTextField(100);
        expressionTextField.setBounds(15, 40, 200, 23);
        mainPanel.add(expressionTextField);
        expressionTextField.addKeyListener(new KeyPressedListener());

        resultLabel = new JLabel("Result");
        resultLabel.setBounds(15, 60, 70, 20);
        mainPanel.add(resultLabel);

        resultTextField = new JTextField(100);
        resultTextField.setBounds(15, 80, 455, 25);
        resultTextField.setBackground(getBackground());
        resultTextField.setEditable(false);
        mainPanel.add(resultTextField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(240, 40, 120, 20);
        mainPanel.add(calculateButton);
        calculateButton.addActionListener(new ButtonPressedListener());


        exitButton = new JButton("Exit");
        exitButton.setBounds(370, 40, 100, 20);
        exitButton.addActionListener(new ButtonPressedListener());
        mainPanel.add(exitButton);

        add(mainPanel);
    }

    public void calculate() {
        try {
            BigDecimal result = calculator.evaluate(expressionTextField.getText());
            resultTextField.setText(result.toString());
        } catch (EvaluationException e) {
            expressionTextField.requestFocus();
            expressionTextField.select(e.getErrorPosition() + 1, e.getErrorPosition() + 1);
            resultTextField.setText(e.getMessage());
        } catch (IllegalArgumentException e) {
            expressionTextField.requestFocus();
            resultTextField.setText(e.getMessage());
        }
    }

    private class ButtonPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getActionCommand().equals("Exit")) {
                dispose();
            } else if (actionEvent.getActionCommand().equals("Calculate")) {
                calculate();
            }
        }
    }

    private class KeyPressedListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if ('\n' == e.getKeyChar()) {
                calculate();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
