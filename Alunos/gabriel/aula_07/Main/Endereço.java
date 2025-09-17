
   
public class Endereço {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    public Endereço(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Método para exibir endereço formatado
    public void apresentarLogradouro() {
        System.out.println(rua + ", " + numero +
                           (complemento.isEmpty() ? "" : " - " + complemento) +
                           " | Bairro: " + bairro +
                           " | Cidade: " + cidade + " - " + estado);
    }
}


