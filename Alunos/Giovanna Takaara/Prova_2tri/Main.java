import java.util.List;

class Serie {
    int id;
    String nome;
    String idioma;
    List<String> generos;
    Double nota;
    String estado;
    String estreia;
    String fim;
    String emissora;


    public Serie() {}

    @Override
    public String toString() {
        return nome;
    }

    public static void main(String[] args) {
        new App();
    }
}


