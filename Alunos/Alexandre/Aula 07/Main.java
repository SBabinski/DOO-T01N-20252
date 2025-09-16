public class Main {
    public static void main(String[] args) {
        Endereco e1 = new Endereco("SP", "Sao Paulo", "Centro", "100", "Sala 10");
        Loja loja = new Loja("LojaTech", "LojaTech LTDA", "12.345.678/0001-99", e1);

        Vendedor v = new Vendedor("Carlos", 30, e1, "LojaTech", 3000);
        Cliente c = new Cliente("Ana", 25, e1);
        Gerente g = new Gerente("Marcos", 40, e1, "LojaTech", 6000);

        loja.apresentarse();
        v.apresentarse();
        c.apresentarse();
        g.apresentarse();

        ProcessaPedido proc = new ProcessaPedido();
        Pedido p = proc.processar(1, c, v, loja);
        p.gerarDescricaoVenda();
    }
}
