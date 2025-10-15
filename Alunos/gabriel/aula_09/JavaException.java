// Exceção personalizada para erros específicos na entrada de dados da calculadora
public class JavaException extends Exception {
    
    // Construtor padrão
    public JavaException(String mensagem) {
        super(mensagem);
    }
    
    // Construtor com causa da exceção
    public JavaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
    // Método para obter detalhes específicos do erro
    public String getDetalhesErro() {
        return "Erro personalizado: " + getMessage();
    }
    
    // Tipos específicos de erro para a calculadora
    public static class CampoVazioException extends JavaException {
        public CampoVazioException(String nomeCampo) {
            super("Campo '" + nomeCampo + "' está vazio! Por favor, digite um número.");
        }
    }
    
    public static class FormatoInvalidoException extends JavaException {
        public FormatoInvalidoException(String valor, String nomeCampo) {
            super("Formato inválido no campo '" + nomeCampo + "': '" + valor + "'\n" +
                  "Digite apenas números (use ponto como separador decimal).");
        }
    }
    
    public static class NumeroInvalidoException extends JavaException {
        public NumeroInvalidoException(String nomeCampo) {
            super("Número inválido no campo '" + nomeCampo + "'!\n" +
                  "Não é possível usar infinito ou valores não numéricos.");
        }
    }
    
    public static class DivisaoPorZeroException extends JavaException {
        public DivisaoPorZeroException() {
            super("Erro: Divisão por zero não é permitida!\n" +
                  "O segundo número deve ser diferente de zero.");
        }
    }
}
