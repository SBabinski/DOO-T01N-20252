import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Tela implements ActionListener {
    
    // Variáveis para armazenar os números
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JLabel resultadoLabel;

    public static void main(String[] args) {
        new Tela().criarInterface();
    }
    
    // Método para validar e converter números usando nossa exceção personalizada
    private double converterNumero(String texto, String nomeCampo) throws JavaException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new JavaException.CampoVazioException(nomeCampo);
        }
        
        // Remove espaços em branco
        texto = texto.trim();
        
        // Converte vírgula para ponto
        texto = texto.replace(",", ".");
        
        try {
            double numero = Double.parseDouble(texto);
            
            // Verifica se é um número válido (não infinito)
            if (Double.isInfinite(numero) || Double.isNaN(numero)) {
                throw new JavaException.NumeroInvalidoException(nomeCampo);
            }
            
            return numero;
        } catch (NumberFormatException e) {
            throw new JavaException.FormatoInvalidoException(texto, nomeCampo);
        }
    }
    
    public void criarInterface() {
            //CRIANDO UM JFRAME
        JFrame frame = new JFrame("CALCULADORA");
        frame.setSize(400, 500);
        //TAMANHO DA JANELA
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //comportamento para fechar o Jframe

        //CRIANDO UM PANEL PARA A TELA (JPANEL)
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5)); // 4 linhas: 2 campos + botões + resultado
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        
        // Primeira linha - Primeiro número
        JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label1 = new JLabel("DIGITE O PRIMEIRO NUMERO:");
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        
        campoTexto1 = new JTextField(15);
        campoTexto1.setFont(new Font("Arial", Font.PLAIN, 12));
        
        linha1.add(label1);
        linha1.add(campoTexto1);
        
        // Segunda linha - Segundo número
        JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label2 = new JLabel("DIGITE O SEGUNDO NUMERO:");
        label2.setForeground(Color.RED);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        
        campoTexto2 = new JTextField(15);
        campoTexto2.setFont(new Font("Arial", Font.PLAIN, 12));

        linha2.add(label2);
        linha2.add(campoTexto2);
        
        // Terceira linha - Botões de operação
        JPanel linha3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botaoSoma = new JButton("+");
        JButton botaoSubtracao = new JButton("-");
        JButton botaoMultiplicacao = new JButton("×");
        JButton botaoDivisao = new JButton("÷");
        
        
        // Configurar botões
        Font fonteBotao = new Font("Arial", Font.BOLD, 14);
        botaoSoma.setFont(fonteBotao);
        botaoSubtracao.setFont(fonteBotao);
        botaoMultiplicacao.setFont(fonteBotao);
        botaoDivisao.setFont(fonteBotao);
        

        // Adicionar ActionListener aos botões
        botaoSoma.addActionListener(this);
        botaoSubtracao.addActionListener(this);
        botaoMultiplicacao.addActionListener(this);
        botaoDivisao.addActionListener(this);
        

        linha3.add(botaoSoma);
        linha3.add(botaoSubtracao);
        linha3.add(botaoMultiplicacao);
        linha3.add(botaoDivisao);
        
        

        // Quarta linha - Resultado
        JPanel linha4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultadoLabel = new JLabel("RESULTADO: ");
        resultadoLabel.setForeground(Color.BLUE);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        linha4.add(resultadoLabel);
        
        panel.add(linha1);
        panel.add(linha2);
        panel.add(linha3);
        panel.add(linha4);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Capturar e validar os números dos campos de texto
            double numero1 = converterNumero(campoTexto1.getText(), "Primeiro Número");
            double numero2 = converterNumero(campoTexto2.getText(), "Segundo Número");
            double resultado = 0;
            
            // Determinar qual operação foi clicada
            String operacao = e.getActionCommand();
            
            switch (operacao) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "×":
                    resultado = numero1 * numero2;
                    break;
                case "÷":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        throw new JavaException.DivisaoPorZeroException();
                    }
                    break;
            
            }
            
            JOptionPane.showMessageDialog(null, 
             numero1 + " " + operacao + " " + numero2 + " = " + resultado,
             "Operação realizada com sucesso!", 
             JOptionPane.INFORMATION_MESSAGE);

            // Exibir o resultado
            resultadoLabel.setText("RESULTADO: " + resultado);
            
        } catch (JavaException ex) {
            // Tratamento específico para nossa exceção personalizada
            resultadoLabel.setText("ERRO: " + ex.getMessage());
            JOptionPane.showMessageDialog(
                null, 
                "Erro na Calculadora:\n" + ex.getMessage(), 
                "Erro de Entrada", 
                JOptionPane.ERROR_MESSAGE
            );
            
        } catch (Exception ex) {
            // Exibir erro geral para outras exceções
            JOptionPane.showMessageDialog(
                null, 
                "Erro inesperado:\n" + ex.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE
            );
            resultadoLabel.setText("ERRO: Ocorreu um erro inesperado.");
        }
    }
}