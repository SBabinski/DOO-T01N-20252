import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraSwing extends JFrame implements ActionListener {

    private JTextField campoNumero1, campoNumero2, campoResultado;
    private JButton botaoSoma, botaoSub, botaoMult, botaoDiv;

    public CalculadoraSwing() {
        super("Calculadora Simples");
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Número 1:"));
        campoNumero1 = new JTextField();
        add(campoNumero1);

        add(new JLabel("Número 2:"));
        campoNumero2 = new JTextField();
        add(campoNumero2);

        add(new JLabel("Resultado:"));
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        add(campoResultado);

        botaoSoma = new JButton("+");
        botaoSub = new JButton("-");
        botaoMult = new JButton("×");
        botaoDiv = new JButton("÷");

        add(botaoSoma);
        add(botaoSub);
        add(botaoMult);
        add(botaoDiv);

        botaoSoma.addActionListener(this);
        botaoSub.addActionListener(this);
        botaoMult.addActionListener(this);
        botaoDiv.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(campoNumero1.getText());
            double num2 = Double.parseDouble(campoNumero2.getText());
            double resultado = 0;

            if (e.getSource() == botaoSoma)
                resultado = num1 + num2;
            else if (e.getSource() == botaoSub)
                resultado = num1 - num2;
            else if (e.getSource() == botaoMult)
                resultado = num1 * num2;
            else if (e.getSource() == botaoDiv) {
                if (num2 == 0)
                    throw new Exception("Divisão por zero não permitida.");
                resultado = num1 / num2;
            }

            campoResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida: use apenas números.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraSwing::new);
    }
}
