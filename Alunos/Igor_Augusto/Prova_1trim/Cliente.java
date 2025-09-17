import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
    
    public String nome;

    public int idade;

    public String endereco;

    public Livro livroEmPosse;

    public LocalDate dataEmprestimo;

    public LocalDate dataDevolucao;

    public long diferenca;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLivro (Livro newLivro){
        this.livroEmPosse = newLivro;
    }

    public Livro getLivro (){
        return this.livroEmPosse;
    }

    
    public void setDataEmprestimo (LocalDate newEmprestimo){
        this.dataEmprestimo = LocalDate.now();
    }

    public LocalDate getDataEmprestimo (){
        return this.dataEmprestimo;
    }

    public void setDataDevolucao (LocalDate newDevolucao){
        this.dataDevolucao = LocalDate.now();
    }

    public LocalDate getDataDevolucao (){
        return this.dataDevolucao;
    }

    public void checarDiferenca (LocalDate dataEmprestimo, LocalDate dataDevolucao){
        diferenca = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        if (diferenca <= 7){
            System.out.println("Devolução realizada sem multa");
        }else if (diferenca > 7){
            double multa = 3.50 * diferenca;
            System.out.println("Devolução realizada com multa de R$" + multa);
        }
    }

}
