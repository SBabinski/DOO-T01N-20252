
public class LivroRaro extends Livro {
private String motivoRaridade;


public LivroRaro(int id, String titulo, String autor, String motivoRaridade) {
    super(id, titulo, autor);
    this.motivoRaridade = motivoRaridade;
}


    @Override
 public boolean podeEmprestar() { return false; }


public String getMotivoRaridade() { return motivoRaridade; }


@Override
public String toString() {
    return super.toString() + " — RARO: " + motivoRaridade + " (NÃO EMPRESTÁVEL)";
}
}