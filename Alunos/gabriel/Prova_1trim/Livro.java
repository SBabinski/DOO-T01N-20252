package Prova_1trim;

public class Livro {


        private String titulo;
        private String autor;
        private boolean disponivel;
        protected String tipo;
        private int diasEmprestimo;
        private double precoLocacao;
        
        
        public Livro() {
            super();
        }
    
       
        public Livro(String titulo, String autor, String tipo) {
            this.titulo = titulo;
            this.autor = autor;
            this.tipo = tipo;
            this.disponivel = true; 
        }
        
        public Livro(String titulo, String autor, String tipo, double precoLocacao) {
            this.titulo = titulo;
            this.autor = autor;
            this.tipo = tipo;
            this.precoLocacao = precoLocacao;
            this.disponivel = true; 
        }
        


        
        public void setDiasEmprestimo(int diasEmprestimo) {
            this.diasEmprestimo = diasEmprestimo;
        }
        
        public double getPrecoLocacao() {
            return precoLocacao;
        }
        
        public void setPrecoLocacao(double precoLocacao) {
            this.precoLocacao = precoLocacao;
        }


        public String getTitulo() {
            return titulo;
        }
    
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    
        public String getAutor() {
            return autor;
        }
    
        public void setAutor(String autor) {
            this.autor = autor;
        }
    
        public boolean isDisponivel() {
            return disponivel;
        }
    
        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }
    
        
        public boolean emprestar() {
            if (disponivel) {
                disponivel = false;
                return true;
            }
            return false;
        }
    
        
        public void devolver() {
            disponivel = true;
        }
        
        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", Tipo: " + tipo + 
                   ", Preço Locação: R$ " + String.format("%.2f", precoLocacao) +
                   ", Disponibilidade: " + (disponivel ? "Disponível" : "Emprestado");
        }
    }
    



    

