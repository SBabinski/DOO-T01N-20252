class InputInvalidoException extends Exception {
    public InputInvalidoException(String mensagem) {
    super(mensagem);
    
    }
}

public class Operacional {

    public static double calcular(double a, double b, String operacao) throws InputInvalidoException {
        switch (operacao) {
            case "+":
                return a + b;
            
            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                if (b == 0) {
                 throw new InputInvalidoException("Divisão por zero não é permitida");
                }
                return a / b;

            default:
                throw new InputInvalidoException("Operação inválida");
        }
    }
}
