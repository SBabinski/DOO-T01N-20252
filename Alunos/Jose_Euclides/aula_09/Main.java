package Alunos.Jose_Euclides.aula_09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

    public static JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        return frame;
    }


    public static class InputException extends RuntimeException {
        public InputException(String message) {
            super(message);
        }
    }

    public static ArrayList<Double> getNumbers(ArrayList<JTextField> arrayField) {
        try {
            ArrayList<Double> nums = new ArrayList<Double>();
            for (JTextField i : arrayField) {
                String textField = i.getText().trim();
                if (textField.isEmpty())
                    throw new InputException("Por favor, preencha ambos os campos.");

                Double numToAdd = Double.parseDouble(textField);

                nums.add(numToAdd);
            }

            return nums;
        } catch (NumberFormatException e) {
            throw new RuntimeException(new InputException("Entrada inválida! Digite apenas números."));
        }
    };

    public static void main(String[] args) {
        JFrame frame = createFrame("Calculadora");
        frame.setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new java.awt.GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        
        JPanel num1Panel = new JPanel(new BorderLayout());
        JLabel labelNum1 = new JLabel("Primeiro Número:");
        JTextField num1 = new JTextField(8);
        num1.setPreferredSize(new java.awt.Dimension(200, 25));
        num1Panel.add(labelNum1, BorderLayout.WEST);
        num1Panel.add(num1, BorderLayout.CENTER);
        
        JPanel num2Panel = new JPanel(new BorderLayout());
        JLabel labelNum2 = new JLabel("Segundo Número:");
        JTextField num2 = new JTextField(8);
        num2.setPreferredSize(new java.awt.Dimension(120, 25));
        num2Panel.add(labelNum2, BorderLayout.WEST);
        num2Panel.add(num2, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton addButton = new JButton("+");
        addButton.setPreferredSize(new java.awt.Dimension(60, 30));
        JButton subButton = new JButton("-");
        subButton.setPreferredSize(new java.awt.Dimension(60, 30));
        JButton mulButton = new JButton("×");
        mulButton.setPreferredSize(new java.awt.Dimension(60, 30));
        JButton divButton = new JButton("÷");
        divButton.setPreferredSize(new java.awt.Dimension(60, 30));
        
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        
        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("Resultado: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(16));
        resultPanel.add(resultLabel);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = java.awt.GridBagConstraints.CENTER;
        mainPanel.add(num1Panel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(num2Panel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(buttonPanel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(resultPanel, gbc);
        
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        ArrayList<JTextField> arr = new ArrayList<>();
        arr.add(num1);
        arr.add(num2);

        addButton.addActionListener(e -> {
            try {
                ArrayList<Double> currentNums = getNumbers(arr);
                double res = currentNums.get(0) + currentNums.get(1);
                resultLabel.setText("Resultado: " + res);
            } catch (RuntimeException ex) {
                Throwable cause = ex.getCause();
                if (cause instanceof InputException) {
                    resultLabel.setText("Erro: " + cause.getMessage());
                } else {
                    resultLabel.setText("Erro: Entrada inválida! Digite apenas números.");
                }
            }
        });

        subButton.addActionListener(e -> {
            try {
                ArrayList<Double> currentNums = getNumbers(arr);
                double res = currentNums.get(0) - currentNums.get(1);
                resultLabel.setText("Resultado: " + res);
            } catch (RuntimeException ex) {
                Throwable cause = ex.getCause();
                if (cause instanceof InputException) {
                    resultLabel.setText("Erro: " + cause.getMessage());
                } else {
                    resultLabel.setText("Erro: Entrada inválida! Digite apenas números.");
                }
            }
        });

        mulButton.addActionListener(e -> {
            try {
                ArrayList<Double> currentNums = getNumbers(arr);
                double res = currentNums.get(0) * currentNums.get(1);
                resultLabel.setText("Resultado: " + res);
            } catch (RuntimeException ex) {
                Throwable cause = ex.getCause();
                if (cause instanceof InputException) {
                    resultLabel.setText("Erro: " + cause.getMessage());
                } else {
                    resultLabel.setText("Erro: Entrada inválida! Digite apenas números.");
                }
            }
        });

        divButton.addActionListener(e -> {
            try {
                ArrayList<Double> currentNums = getNumbers(arr);
                if (currentNums.get(1) == 0) {
                    throw new InputException("Divisão por zero não é permitida!");
                }
                double res = currentNums.get(0) / currentNums.get(1);
                resultLabel.setText("Resultado: " + res);
            } catch (InputException ex1) {
                resultLabel.setText("Erro: " + ex1.getMessage());
            } catch (RuntimeException ex) {
                Throwable cause = ex.getCause();
                if (cause instanceof InputException) {
                    resultLabel.setText("Erro: " + cause.getMessage());
                } else {
                    resultLabel.setText("Erro: Entrada inválida! Digite apenas números.");
                }
            }
        });
    }
}
