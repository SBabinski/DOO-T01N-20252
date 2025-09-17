public class Vendas {
    private String nomeProduto;
    private int quantidade;
    private double precounidade;
    private double total;
    private int mes;
    private int ano;
    private int dia;

public Vendas(String nomeProduto, int quantidade, double precounidade,int dia, int mes, int ano){
    this.nomeProduto = nomeProduto;
    this.quantidade = quantidade;
    this.precounidade = precounidade; 
    this.total = quantidade * precounidade;
    this.mes = mes;
    this.ano = ano;
    this.dia = dia;

 }
  @Override
public String toString(){
   return String.format("\"Produto: %s | Qtd: %d | Unit: R$%.2f | Total: R$%.2f | Mês: %d | Ano: %d\",\r\n" + //
                         "nomeProduto, quantidade, precoUnitario, total, mes, ano");
 }

public int getMes(){
   return mes;

 }

public int getAno(){
   return ano;

 }

public double getTotal(){
   return total;

 }

public int getDia(){
   return dia;
} 

}
