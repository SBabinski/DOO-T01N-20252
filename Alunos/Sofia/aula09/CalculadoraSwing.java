
import javax.swing.*;
import java.awt.*;

public class CalculadoraSwing extends JFrame {
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel resultadoLabel;

    public CalculadoraSwing() {
        super("Calculadora Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLayout(new GridLayout(6, 1));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        resultadoLabel = new JLabel("Resultado: ", SwingConstants.CENTER);

        JButton btnSomar = new JButton("+");
        JButton btnSubtrair = new JButton("-");
        JButton btnMultiplicar = new JButton("×");
        JButton btnDividir = new JButton("÷");
 
        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(btnSomar);
        botoesPanel.add(btnSubtrair);
        botoesPanel.add(btnMultiplicar);
        botoesPanel.add(btnDividir);
        add(botoesPanel);

        add(resultadoLabel);

        btnSomar.addActionListener(e -> calcular('+'));
        btnSubtrair.addActionListener(e -> calcular('-'));
        btnMultiplicar.addActionListener(e -> calcular('*'));
        btnDividir.addActionListener(e -> calcular('/'));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular(char operacao) {
        try {
            double n1 = lerNumero(campoNumero1.getText());
            double n2 = lerNumero(campoNumero2.getText());
            double resultado = 0;

            switch (operacao) {
                case '+':
                    resultado = n1 + n2;
                    break;
                case '-':
                    resultado = n1 - n2;
                    break;
                case '*':
                    resultado = n1 * n2;
                    break;
                case '/':
                    if (n2 == 0)
                        throw new EntradaInvalidaException("Erro: divisão por zero!");
                    resultado = n1 / n2;
                    break;
            }

            resultadoLabel.setText("Resultado: " + resultado);

        } catch (EntradaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida! Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double lerNumero(String texto) throws EntradaInvalidaException {
        if (texto == null || texto.trim().isEmpty())
            throw new EntradaInvalidaException("Erro: campo vazio!");

        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Erro: valor inválido! Digite apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSwing());
    }
}
