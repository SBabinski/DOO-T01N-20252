public class Item {
    
    private double id;
    private String nome;
    private String tipo;
    private double valor;

    

    public Item(double id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void gerarDescrição(){
       System.out.println("Id: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", valor: " + valor);
    
        
    }



    public double calcularSubtotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSubtotal'");
    }


}


