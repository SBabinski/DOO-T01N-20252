import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

    JFrame janela = new JFrame("Clima");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(350,160);
    janela.setLayout(new FlowLayout());
    janela.setLocationRelativeTo(null);

    JTextField campo = new JTextField(10);
    JButton pesquisar = new JButton("Buscar clima");

    pesquisar.addActionListener(e -> {
        String cidade = campo.getText().trim();

        if (cidade.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Digite o nome de alguma cidade",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Clima clima = Buscar.buscar(cidade);
            JOptionPane.showMessageDialog(janela, clima.toString(), "clima Atual",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(janela, "erro ao buscar o clima" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    });
    janela.add(new Label("Cidade:"));
    janela.add(campo);
    janela.add(pesquisar);

    janela.setVisible(true);
    }
}

