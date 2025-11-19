package DOO-T01N-20252. Alunos.Alexandre.Prova_2tri;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Serie> favoritos;
    private List<Serie> assistidas;
    private List<Serie> querAssistir;

    public Usuario(String nome) {
        this.nome = nome;
        this.favoritos = new ArrayList<>();
        this.assistidas = new ArrayList<>();
        this.querAssistir = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Serie> getFavoritos() {
        return favoritos;
    }

    public List<Serie> getAssistidas() {
        return assistidas;
    }

    public List<Serie> getQuerAssistir() {
        return querAssistir;
    }
}