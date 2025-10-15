import javax.swing.*;
import java.awt.*;

class CalculadoraException extends Exception {
    public CalculadoraException(String mensagem) {
        super(mensagem);
    }
}

public class CalculadoraSwing extends JFrame {
    private JTextField campoNum1, campoNum2, campoResultado;
    private JButton btnSoma, btnSub, btnMult, btnDiv;

    public CalculadoraSwing() {
        super("Calculadora Simples");

        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblNum1 = new JLabel("Número 1:");
        JLabel lblNum2 = new JLabel("Número 2:");
        JLabel lblResultado = new JLabel("Resultado:");

        campoNum1 = new JTextField();
        campoNum2 = new JTextField();
        campoResultado = new JTextField();
        campoResultado.setEditable(false);

        btnSoma = new JButton("+");
        btnSub = new JButton("-");
        btnMult = new JButton("×");
        btnDiv = new JButton("÷");

        add(lblNum1); add(campoNum1);
        add(lblNum2); add(campoNum2);
        add(lblResultado); add(campoResultado);

        add(btnSoma);
        add(btnSub);
        add(btnMult);
        add(btnDiv);

        btnSoma.addActionListener(e -> calcular('+'));
        btnSub.addActionListener(e -> calcular('-'));
        btnMult.addActionListener(e -> calcular('*'));
        btnDiv.addActionListener(e -> calcular('/'));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular(char operacao) {
        try {
            double num1 = lerNumero(campoNum1.getText());
            double num2 = lerNumero(campoNum2.getText());
            double resultado = 0;

            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0)
                        throw new CalculadoraException("Erro: divisão por zero!");
                    resultado = num1 / num2;
                    break;
            }

            campoResultado.setText(String.valueOf(resultado));

        } catch (CalculadoraException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage(), "Erro de Cálculo", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Erro: insira apenas números válidos!", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private double lerNumero(String texto) throws CalculadoraException {
        if (texto == null || texto.trim().isEmpty())
            throw new CalculadoraException("Erro: campo vazio!");
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Erro: entrada inválida! Digite apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSwing());
    }
}