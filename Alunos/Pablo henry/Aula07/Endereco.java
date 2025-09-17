package calculadora;

public class Endereco {
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", N°" + numero + ", " + complemento + ", Bairro " + bairro + ", " + cidade + " - " + estado);
    }
}