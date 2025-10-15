import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OperacionalSwing extends JFrame {
    
        private JTextField campo1;
        private JTextField campo2;
        private JLabel resultadoLabel;
           

     public OperacionalSwing(){
         setTitle("Calculadora simples");
         setSize(300, 250);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para fexar o sistema quando rodar 
         setLocationRelativeTo(null); // coloca a calculadora no sentro da tela 
         setLayout(new GridLayout(6 ,1 ));


        campo1 = new JTextField();
        campo2 = new JTextField();
        
        add(new JLabel("Numero 1"));
        add (campo1);
        add(new JLabel("Numero 2"));
        add(campo2);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout( new GridLayout(1, 4));

        String[] operacoes = {"+","-","*","/"};
          for(String op : operacoes){
            JButton botao = new JButton(op);
           botao.addActionListener(e -> calcular(op));
            botoesPanel.add(botao);
          }

         add(botoesPanel);
         resultadoLabel = new JLabel("resultado", SwingConstants.CENTER);
         add(resultadoLabel);

     }    
    
     private void calcular(String operacao){
        try{
         double num1 = Double.parseDouble(campo1.getText());
         double num2 = Double.parseDouble(campo2.getText());
   
         double resultado = Operacional.calcular(num1, num2, operacao);
          System.out.println("Resultado da conta é"+ resultado);
          resultadoLabel.setText("Resultado " + resultado);

         }catch(NumberFormatException e){
            mostrarErro("Porfavor insira numeros validos");

         }catch(InputInvalidoException e){
            mostrarErro(e.getMessage());

         }catch(Exception e){
            mostrarErro("Erro inesperado" + e.getMessage());
        }

     }

     private void mostrarErro(String mensagem) {
       JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}