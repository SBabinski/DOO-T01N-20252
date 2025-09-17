import java.time.LocalDate;

public class Livro {
    
    public String nome;

    public String autor;

    public String edicao;

    public String ano;

    public Boolean disponivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void apresentarLivro(){
        System.out.println("Livro \n Nome: " + nome + "\n Autor " + autor + " \n Edição " + edicao + " \n Ano: "
        + ano);
    }

    

}
