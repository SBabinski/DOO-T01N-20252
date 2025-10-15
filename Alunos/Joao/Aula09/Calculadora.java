import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora implements ActionListener {
    JLabel nome, nm1, nm2;
    JTextField num1, num2, resultado;
    JButton b1, b2, b3, b4, b5;
    String operacao = "";

    public Calculadora() {
        JFrame tela = new JFrame();
        tela.setTitle("Calculadora");
        tela.setSize(750, 500);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
        tela.setLayout(null);

        nome = new JLabel("Calculadora");
        nome.setBounds(100, 20, 250, 80);
        nome.setFont(new Font("Arial", Font.ITALIC, 35));
        nome.setForeground(new Color(255, 145, 2));
        tela.add(nome);


        b1 = new JButton("+");
        b1.setBounds(100, 180, 50, 50);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setForeground(new Color(255, 145, 2));
        b1.setBackground(new Color(51, 51, 51));
        tela.add(b1);

        b2 = new JButton("-");
        b2.setBounds(155, 180, 50, 50);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setForeground(new Color(255, 145, 2));
        b2.setBackground(new Color(51, 51, 51));
        tela.add(b2);

        b3 = new JButton("x");
        b3.setBounds(210, 180, 50, 50);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setForeground(new Color(255, 145, 2));
        b3.setBackground(new Color(51, 51, 51));
        tela.add(b3);

        b4 = new JButton("/");
        b4.setBounds(265, 180, 50, 50);
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b4.setForeground(new Color(255, 145, 2));
        b4.setBackground(new Color(51, 51, 51));
        tela.add(b4);

        b5 = new JButton("=");
        b5.setBounds(350, 180, 50, 50);
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setForeground(new Color(255, 145, 2));
        b5.setBackground(new Color(51, 51, 51));
        tela.add(b5);

        num1 = new JTextField(5);
        num1.setBounds(140, 105, 150, 60);
        num1.setFont(new Font("Arial", Font.BOLD, 35));
        tela.add(num1);

        num2 = new JTextField(5);
        num2.setBounds(140, 250, 150, 60);
        num2.setFont(new Font("Arial", Font.BOLD, 35));
        tela.add(num2);

        resultado = new JTextField(5);
        resultado.setBounds(430, 180, 170, 50);
        resultado.setFont(new Font("Arial", Font.BOLD, 35));
        tela.add(resultado);

        nm1 = new JLabel("Digite um Número:");
        nm1.setBounds(20, 115, 120, 45);
        nm1.setFont(new Font("Arial", Font.BOLD, 12));
        tela.add(nm1);

        nm2 = new JLabel("Digite outro Número:");
        nm2.setBounds(20, 252, 120, 45);
        nm2.setFont(new Font("Arial", Font.BOLD, 12));
        tela.add(nm2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        tela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        try {
            if (src == b1) operacao = "+";
            else if (src == b2) operacao = "-";
            else if (src == b3) operacao = "*";
            else if (src == b4) operacao = "/";
            else if (src == b5) calcular();

        } catch (Erro ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcular() throws Erro {
        double n1, n2;

        try {
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
        } catch (NumberFormatException e) {
            throw new Erro ("Digite apenas números válidos!");
        }

        double res = 0;

        switch (operacao) {
            case "+" -> res = n1 + n2;
            case "-" -> res = n1 - n2;
            case "*" -> res = n1 * n2;
            case "/" -> {
                if (n2 == 0) throw new Erro("Divisão por zero não é permitida!");
                res = n1 / n2;
            }
            default -> throw new Erro("Escolha uma operação antes de calcular!");
        }

        resultado.setText(String.valueOf(res));
        operacao = "";
    }
}

