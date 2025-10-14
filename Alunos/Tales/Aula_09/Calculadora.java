import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel labelResultado;

    public Calculadora() {
        super("Calculadora Tales");

  
        setLayout(new GridLayout(7, 1, 5, 5));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        labelResultado = new JLabel("Resultado: ", SwingConstants.CENTER);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnSoma = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMult = new JButton("×");
        JButton btnDiv = new JButton("÷");

        painelBotoes.add(btnSoma);
        painelBotoes.add(btnSub);
        painelBotoes.add(btnMult);
        painelBotoes.add(btnDiv);

     
        JButton btnLimpar = new JButton("Limpar");

  
        add(new JLabel("Digite o primeiro número:", SwingConstants.CENTER));
        add(campoNumero1);
        add(new JLabel("Digite o segundo número:", SwingConstants.CENTER));
        add(campoNumero2);
        add(painelBotoes);
        add(labelResultado);
        add(btnLimpar);

        btnSoma.addActionListener(e -> calcular('+'));
        btnSub.addActionListener(e -> calcular('-'));
        btnMult.addActionListener(e -> calcular('*'));
        btnDiv.addActionListener(e -> calcular('/'));
        btnLimpar.addActionListener(e -> limpar());

       
        setSize(320, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular(char operacao) {
        try {
            double num1 = lerNumero(campoNumero1.getText());
            double num2 = lerNumero(campoNumero2.getText());
            double resultado;

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
                    if (num2 == 0) {
                        throw new CalculadoraException("Erro: Divisão por zero!");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new CalculadoraException("Operação inválida.");
            }

            labelResultado.setText("Resultado: " + resultado);

        } catch (CalculadoraException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Cálculo", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Entrada inválida! Digite apenas números.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double lerNumero(String texto) throws CalculadoraException {
        try {
            return Double.parseDouble(texto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Entrada inválida: use apenas números!");
        }
    }

    private void limpar() {
        campoNumero1.setText("");
        campoNumero2.setText("");
        labelResultado.setText("Resultado: ");
        campoNumero1.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
