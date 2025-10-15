import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora implements ActionListener {
    JTextField num1, num2, resultado;
    JButton mais, menos, vezes, dividir, igual;
    String operacao = "";

    public Calculadora() {

        JFrame janela = new JFrame("Calculadora");
        janela.setSize(500, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setLayout(null);

        num1 = new JTextField(5);
        num2 = new JTextField(5);
        resultado = new JTextField(5);

        num1.setBounds(250,80,100,50);
        num2.setBounds(250,240,100,50);
        resultado.setBounds(280,350,100,50);
        resultado.setEditable(false);

        janela.add(num1);
        janela.add(num2);
        janela.add(resultado);

        mais = new JButton("+");
        mais.setBounds(50,160,50,50);
        mais.setFont(new Font("Arial", Font.BOLD, 15));
        mais.setForeground(new Color(2, 0, 0));
        mais.setBackground(new Color(105, 219, 64));
        janela.add(mais);

        menos = new JButton("-");
        menos.setBounds(150,160,50,50);
        menos.setFont(new Font("Arial", Font.BOLD, 15));
        menos.setForeground(new Color(2, 0, 0));
        menos.setBackground(new Color(105, 219, 64));
        janela.add(menos);

        vezes = new JButton("x");
        vezes.setBounds(250,160,50,50);
        vezes.setFont(new Font("Arial", Font.BOLD, 15));
        vezes.setForeground(new Color(2, 0, 0));
        vezes.setBackground(new Color(105, 219, 64));
        janela.add(vezes);

        dividir = new JButton("/");
        dividir.setBounds(350,160,50,50);
        dividir.setFont(new Font("Arial", Font.BOLD, 15));
        dividir.setForeground(new Color(2, 0, 0));
        dividir.setBackground(new Color(105, 219, 64));
        janela.add(dividir);

        igual = new JButton("=");
        igual.setBounds(80,350,50,50);
        igual.setFont(new Font("Arial", Font.BOLD, 15));
        igual.setForeground(new Color(2, 0, 0));
        igual.setBackground(new Color(105, 219, 64));
        janela.add(igual);

        JLabel text1 = new JLabel("Digite um numero: ");
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setBounds(80, 80, 140,50 );
        janela.add(text1);

        JLabel text2 = new JLabel("Digite outro numero: ");
        text2.setFont(new Font("Arial", Font.PLAIN, 15));
        text2.setBounds(80, 240, 150,50 );
        janela.add(text2);

        JLabel textR = new JLabel("O resultado é: ");
        textR.setFont(new Font("Arial", Font.PLAIN, 15));
        textR.setBounds(170, 350, 150,50 );
        janela.add(textR);

        JLabel titulo = new JLabel("CALCULADORA");
        titulo.setFont(new Font("Arial", Font.BOLD, 17));
        titulo.setBounds(172, 10, 200,50 );
        janela.add(titulo);

        JLabel subt = new JLabel("Digite os números, escolha a operação e clique no igual.");
        subt.setFont(new Font("Arial", Font.PLAIN, 12));
        subt.setBounds(80, 25, 500,50 );
        janela.add(subt);

        mais.addActionListener(this);
        menos.addActionListener(this);
        vezes.addActionListener(this);
        dividir.addActionListener(this);
        igual.addActionListener(this);

        janela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object opcao =e.getSource();

        try {
            if (opcao == mais) operacao = "+";
            else if (opcao == menos) operacao = "-";
            else if (opcao == vezes) operacao = "*";
            else if (opcao == dividir) operacao = "/";
            else if (opcao == igual) calcular();

        } catch (Erro ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro inesperado." +
                    ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcular() throws Erro {
        double n1, n2;
        double total = 0;

        try {
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
        } catch (NumberFormatException ex) {
            throw new Erro("Digite apenas números");
        }

        switch (operacao) {
            case "+" -> total = n1 + n2;
            case "-" -> total = n1 - n2;
            case "*" -> total = n1 * n2;
            case "/" -> {
                if (n2 == 0) throw new Erro("Não é possível dividir por zero");
                total = n1 / n2;
            } default -> throw new Erro("Escolha uma operação");
         } resultado.setText(String.valueOf(total));
        operacao = "";

        }
    }
