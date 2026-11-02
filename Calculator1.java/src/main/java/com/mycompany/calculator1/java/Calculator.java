/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator1.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    char operator;

    Calculator() {

        setTitle("Nehal's Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String value = e.getActionCommand();

        if (value.matches("[0-9]")) {
            if (display.getText().equals("0")) {
                display.setText(value);
            } else {
                display.setText(display.getText() + value);
            }
        }

        else if (value.equals("C")) {
            display.setText("0");
            num1 = 0;
            num2 = 0;
            operator = '\0';
        }

        else if (value.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Error");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(String.valueOf(result));

            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = value.charAt(0);
                display.setText("");
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

