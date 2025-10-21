import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Clima - Visual Crossing");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(350, 160);
        tela.setLayout(new FlowLayout());
        tela.setLocationRelativeTo(null);

        JTextField campoC = new JTextField(15);
        JButton botaoBuscar = new JButton("Buscar Clima");

        botaoBuscar.addActionListener(e -> {
            String cidade = campoC.getText().trim();

            if (cidade.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Digite o nome de uma cidade!",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Tempo clima = ConsultaClima.buscarClima(cidade);
                JOptionPane.showMessageDialog(tela, clima.toString(), "Clima Atual",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao buscar clima: " +
                        ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        tela.add(new JLabel("Cidade:"));
        tela.add(campoC);
        tela.add(botaoBuscar);

        tela.setVisible(true);
    }
}