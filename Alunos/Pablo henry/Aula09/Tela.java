package calcTela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela {
    public static void main(String[] args) {
        JFrame janela = new JFrame(); // cria a janela

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha 100% a janela
        janela.setBounds(500, 100, 400, 600); // x, y e tamanho
        janela.setLayout(null);

        JButton botaoPlus = new JButton("+");
        JButton botaoLess = new JButton("-");
        JButton botaoDiv = new JButton("/");
        JButton botaoMultiply = new JButton("*");

        janela.add(botaoPlus); // botao
        janela.add(botaoLess);
        janela.add(botaoDiv);
        janela.add(botaoMultiply);

        int w = 55, h = 50; // deixando padrao e de melhor usuabilidade

        botaoLess.setBounds(20, 80, w, h); // primeira linha
        botaoPlus.setBounds(85, 80, w, h);
        botaoMultiply.setBounds(150, 80, w, h);
        botaoDiv.setBounds(215, 80, w, h);

        JTextField visor = new JTextField(); // caixa de texto n1
        visor.setBounds(10, 20, 50, 40);
        visor.setEditable(true);
        janela.add(visor);

        JTextField visorTwo = new JTextField(); // caixa de texto n2
        visorTwo.setBounds(80, 20, 50, 40);
        visorTwo.setEditable(true);
        janela.add(visorTwo);

        JTextField resposta = new JTextField();
        resposta.setBounds(140, 20, 50, 40);
        resposta.setEditable(false);
        janela.add(resposta);

        String numeroUm = visor.getText();
        String numeroDois = visorTwo.getText();

        botaoPlus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String texto1 = visor.getText();
                    String texto2 = visorTwo.getText();

                    int numeroUm = Integer.parseInt(texto1);
                    int numeroDois = Integer.parseInt(texto2);

                    int resp = numeroUm + numeroDois;

                    resposta.setText(String.valueOf(resp)); // manda para a caixa de resposta

                } catch (Exception ex) {
                    // erro se digitar letra
                    resposta.setText("Erro");
                }
            }
        });

        botaoDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroUm = Integer.parseInt(visor.getText());
                    int numeroDois = Integer.parseInt(visorTwo.getText());

                    if (numeroDois == 0) {
                        resposta.setText("Div/0"); // mostra erro específico se disivel por 0
                    } else {
                        int resp = numeroUm / numeroDois;
                        resposta.setText(String.valueOf(resp));
                    }

                } catch (Exception ex) {
                    resposta.setText("Erro");
                }
            }
        });

        botaoMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroUm = Integer.parseInt(visor.getText());
                    int numeroDois = Integer.parseInt(visorTwo.getText());

                    int resp = numeroUm * numeroDois; // A única mudança é aqui

                    resposta.setText(String.valueOf(resp));
                } catch (Exception ex) {
                    resposta.setText("Erro");
                }
            }
        });

        botaoLess.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroUm = Integer.parseInt(visor.getText());
                    int numeroDois = Integer.parseInt(visorTwo.getSelectedText());

                    int resp = numeroUm - numeroDois;

                    resposta.setText(String.valueOf(resp));
                } catch (Exception ex) {
                    resposta.setText("Erro");
                }
            }

        });

        resposta.setVisible(true);
        visorTwo.setVisible(true);
        visor.setVisible(true);
        janela.setVisible(true);
    }
}