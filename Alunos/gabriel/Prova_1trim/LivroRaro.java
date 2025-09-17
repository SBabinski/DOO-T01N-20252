package Prova_1trim;


    public class LivroRaro extends Livro {
        private String motivoRaridade;
    
        
        public LivroRaro() {
            super(); 
        }
    
       
        public LivroRaro(String titulo, String autor, String tipo) {
            super(titulo, autor, tipo);
        }
        
        public LivroRaro(String titulo, String autor, String tipo, double precoLocacao) {
            super(titulo, autor, tipo, precoLocacao);
        }
    
        public String getMotivoRaridade() {
            return motivoRaridade;
        }
    
        public void setMotivoRaridade(String motivoRaridade) {
            this.motivoRaridade = motivoRaridade;
        }
    
        
        @Override
        public boolean emprestar() {
            System.out.println("O livro raro nao pode ser emprestado somente os comuns");
            return false;
        }
    }
     

