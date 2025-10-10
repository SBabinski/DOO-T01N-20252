import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setSize(450, 163);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);

        JTextField campo1 = new JTextField("");
        JTextField campo2 = new JTextField("");
        JTextField resultado = new JTextField(" ");

        Estilizar(campo1);
        Estilizar(campo2);
        Estilizar(resultado);
        resultado.setEditable(false);

        JPanel entrada = new JPanel(new GridLayout(3, 3, 5, 5));
        entrada.add(new JLabel("Digite o primeiro valor:"));
        entrada.add(campo1);
        entrada.add(new JLabel("Digite o primeiro valor:"));
        entrada.add(campo2);
        entrada.add(new JLabel("Resultado:"));
        entrada.add(resultado);

        JPanel botao = new JPanel(new GridLayout(1, 4, 5, 5));
        botao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JButton soma = new JButton("+");
        JButton subtracao = new JButton("-");
        JButton multiplicacao = new JButton("*");
        JButton divisao = new JButton("/");


        EstilizarBotao(soma);
        EstilizarBotao(subtracao);
        EstilizarBotao(multiplicacao);
        EstilizarBotao(divisao);

        botao.add(soma);
        botao.add(subtracao);
        botao.add(multiplicacao);
        botao.add(divisao);

        panel.add(botao, BorderLayout.SOUTH);
        panel.add(entrada, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);

        ActionListener listener = e -> {
            try {

                double n1 = lerNumero(campo1.getText());
                double n2 = lerNumero(campo2.getText());
                double res = 0;

                switch (e.getActionCommand()) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "*":
                        res = n1 * n2;
                        break;
                    case "/":
                        if (n2 == 0) {
                            throw new Exception("Não se pode dividir um numero por 0");
                        }
                        res = n1 / n2;
                        break;
                }

                resultado.setText(String.valueOf(res));

            }catch (EntradaInvalida ei){
                    JOptionPane.showMessageDialog(frame,
                            ei.getMessage(),
                            "Não coloque letras nos campos de números", JOptionPane.ERROR_MESSAGE);
                }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame,
                        "Ocorreu um erro: " + ex.getMessage(),
                        "Erro geral",
                        JOptionPane.ERROR_MESSAGE);
            }
        };

        soma.addActionListener(listener);
        subtracao.addActionListener(listener);
        multiplicacao.addActionListener(listener);
        divisao.addActionListener(listener);

    }

    private static Double lerNumero(String campo) throws EntradaInvalida {
        try {
            return Double.parseDouble(campo.trim());
        }catch (NumberFormatException e){
            throw new EntradaInvalida("Não é permitido entrar com letras," +
                    " utilizar virgula (utilize pontos se for o caso)," +
                    " ou utilizar campos vazios");
        }
    }

    private static void Estilizar(JTextField e) {

        e.setFont(new Font("Arial", Font.BOLD, 20));
        e.setBackground(Color.LIGHT_GRAY);
        e.setHorizontalAlignment(JTextField.CENTER);
        e.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    private static void EstilizarBotao(JButton b){
        b.setFont(new Font("Arial", Font.BOLD, 20));
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.black);
        b.setBorder(BorderFactory.createLineBorder(Color.black));
    }

}

class EntradaInvalida extends Exception {
    public EntradaInvalida (String msg){
        super(msg);
    }
}