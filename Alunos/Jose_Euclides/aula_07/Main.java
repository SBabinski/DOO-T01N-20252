import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Product> dataProducts = new ArrayList<>();
    private static ArrayList<Sale> listSales = new ArrayList<>();
    private static ArrayList<Loja> listLojas = new ArrayList<>();
    private static ArrayList<Cliente> listClientes = new ArrayList<>();
    private static ArrayList<Vendedor> listVendedores = new ArrayList<>();
    private static ArrayList<Gerente> listGerentes = new ArrayList<>();

    public static String getNameFromUser(String message) {
        System.out.println(message);
        return scan.next();
    }

    public static double getDoubleFromUser(String message) {
        System.out.println(message);
        return scan.nextDouble();
    }

    public static int getIntFromUser(String message) {
        System.out.println(message);
        return scan.nextInt();
    }

    public static void createNewProduct() {
        Product product = new Product((dataProducts.size() + 1));

        product.setName(getNameFromUser("Digite o nome do produto: "));
        product.setPrice(getDoubleFromUser("Digite o preco do produto: "));
        product.setDiscount(getDoubleFromUser("Digite o percentual de desconto produto: "));
        product.setQttMinimumForDiscount(
                getIntFromUser("Digite a quantidade minima necessaria para ativar o desconto: "));

        dataProducts.add(product);
    }

    public static void reportProducts() {
        if (dataProducts.size() > 0) {
            dataProducts.forEach(val -> System.out.println(val.toString()));
        } else {
            System.out.println("Infelizmente não há nenhum produto cadastrado ainda! ): ");
        }
    }

    public static void reportSales() {
        if (listSales.size() > 0) {
            listSales.forEach(val -> System.out.println(val.toString()));
        } else {
            System.out.println("Infelizmente não existe registro de vendas! ): ");
        }
    }

    public static void reportSalesByDayAndMonth() {
        System.out.println("Digite o mes que deseja filtrar:\n");
        int month = scan.nextInt();

        System.out.println("Digite o dia que deseja filtrar:\n");
        int day = scan.nextInt();

        int count = 0;
        for (Sale sale : listSales) {
            if (sale.getCreatedAt().getDayOfMonth() == day && sale.getCreatedAt().getMonthValue() == month) {
                System.out.println(sale.toString());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("\nNao existe nenhuma venda para para o mes (" + month + ") e dia (" + day + ")\n");
        } else {
            System.out.println("\nForam feitas " + count + " vendas nesse filtro!\n");
        }
    }

    public static void makeSale() {
        System.out.println("Você tem os seguintes produtos cadastrados!\n\n");
        reportProducts();

        boolean next = true;
        while (next) {
            System.out.println("Digite o ID do produto para adicioná-lo ou 0 para sair.\n");
            int option = scan.nextInt();
            if (option == 0) {
                next = false;
            } else {
                System.out.println("Digite a quantidade:\n");
                int qtt = scan.nextInt();

                Product selectedProduct = dataProducts.get(option - 1);
                Sale newSale = new Sale(selectedProduct, qtt);
                newSale.setProduct(selectedProduct);

                listSales.add(newSale);

                System.out.println("Venda registrada com sucesso! \n\n" + newSale.toString());
            }
        }

    }

    public static void createLoja() {
        Loja loja = new Loja();
        
        loja.setNomeFantasia(getNameFromUser("Digite o nome fantasia da loja: "));
        loja.setRazaoSocial(getNameFromUser("Digite a razão social da loja: "));
        loja.setCnpj(getNameFromUser("Digite o CNPJ da loja: "));
        
        Endereco endereco = new Endereco();
        endereco.setEstado(getNameFromUser("Digite o estado: "));
        endereco.setCidade(getNameFromUser("Digite a cidade: "));
        endereco.setBairro(getNameFromUser("Digite o bairro: "));
        endereco.setNumero(getNameFromUser("Digite o número: "));
        endereco.setComplemento(getNameFromUser("Digite o complemento (opcional): "));
        
        loja.setEndereco(endereco);
        
        listLojas.add(loja);
        System.out.println("Loja criada com sucesso!");
        loja.apresentarSe();
    }

    public static void createCliente() {
        Cliente cliente = new Cliente();
        
        cliente.setNome(getNameFromUser("Digite o nome do cliente: "));
        cliente.setIdade(getIntFromUser("Digite a idade do cliente: "));
        
        listClientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        cliente.apresentarSe();
    }

    public static void createVendedor() {
        Vendedor vendedor = new Vendedor();
        
        vendedor.setNome(getNameFromUser("Digite o nome do vendedor: "));
        vendedor.setIdade(getIntFromUser("Digite a idade do vendedor: "));
        vendedor.setSalarioBase(getDoubleFromUser("Digite o salário base do vendedor: "));
        
        vendedor.setSalariosRecebidos(new ArrayList<>());
        
        listVendedores.add(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");
        vendedor.apresentarSe();
    }

    public static void createGerente() {
        Gerente gerente = new Gerente();
        
        gerente.setNome(getNameFromUser("Digite o nome do gerente: "));
        gerente.setIdade(getIntFromUser("Digite a idade do gerente: "));
        gerente.setSalarioBase(getDoubleFromUser("Digite o salário base do gerente: "));
        
        listGerentes.add(gerente);
        System.out.println("Gerente cadastrado com sucesso!");
        gerente.apresentarSe();
        System.out.println("Média salarial: R$ " + String.format("%.2f", gerente.calcularMedia()));
        System.out.println("Bonus: R$ " + String.format("%.2f", gerente.calcularBonus()));
    }

    public static void processarPedido() {
        if (listClientes.size() == 0) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        if (listVendedores.size() == 0) {
            System.out.println("Nenhum vendedor cadastrado!");
            return;
        }
        
        if (listLojas.size() == 0) {
            System.out.println("Nenhuma loja cadastrada!");
            return;
        }

        System.out.println("Escolha o cliente:");
        for (int i = 0; i < listClientes.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listClientes.get(i).getNome());
        }
        
        int clienteIndex = getIntFromUser("Digite o número do cliente: ") - 1;
        if (clienteIndex < 0 || clienteIndex >= listClientes.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        System.out.println("Escolha o vendedor:");
        for (int i = 0; i < listVendedores.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listVendedores.get(i).getNome());
        }
        
        int vendedorIndex = getIntFromUser("Digite o número do vendedor: ") - 1;
        if (vendedorIndex < 0 || vendedorIndex >= listVendedores.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        System.out.println("Escolha a loja:");
        for (int i = 0; i < listLojas.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listLojas.get(i).getNomeFantasia());
        }
        
        int lojaIndex = getIntFromUser("Digite o número da loja: ") - 1;
        if (lojaIndex < 0 || lojaIndex >= listLojas.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(
            listClientes.size() + listVendedores.size() + 1,
            listClientes.get(clienteIndex),
            listVendedores.get(vendedorIndex),
            listLojas.get(lojaIndex)
        );
    }

    public static void listLojas() {
        if (listLojas.size() > 0) {
            System.out.println("\n=== LISTA DE LOJAS ===");
            for (int i = 0; i < listLojas.size(); i++) {
                System.out.println("\n--- Loja " + (i + 1) + " ---");
                listLojas.get(i).apresentarSe();
            }
        } else {
            System.out.println("Nenhuma loja cadastrada ainda!");
        }
    }

    public static void listClientes() {
        if (listClientes.size() > 0) {
            System.out.println("\n=== LISTA DE CLIENTES ===");
            for (int i = 0; i < listClientes.size(); i++) {
                System.out.println("\n--- Cliente " + (i + 1) + " ---");
                listClientes.get(i).apresentarSe();
            }
        } else {
            System.out.println("Nenhum cliente cadastrado ainda!");
        }
    }

    public static void listVendedores() {
        if (listVendedores.size() > 0) {
            System.out.println("\n --> LISTA DE VENDEDORES");
            for (int i = 0; i < listVendedores.size(); i++) {
                System.out.println("\n--- Vendedor " + (i + 1) + " ---");
                listVendedores.get(i).apresentarSe();
            }
        } else {
            System.out.println("Nenhum vendedor cadastrado ainda!");
        }
    }

    public static void listGerentes() {
        if (listGerentes.size() > 0) {
            System.out.println("\n --> LISTA DE GERENTES");
            for (int i = 0; i < listGerentes.size(); i++) {
                System.out.println("\n--- Gerente " + (i + 1) + " ---");
                listGerentes.get(i).apresentarSe();
                System.out.println("Média salarial: R$ " + String.format("%.2f", listGerentes.get(i).calcularMedia()));
                System.out.println("Bonus: R$ " + String.format("%.2f", listGerentes.get(i).calcularBonus()));
            }
        } else {
            System.out.println("Nenhum gerente cadastrado ainda!");
        }
    }

    public static void addClientesALoja() {
        if (listLojas.size() == 0) {
            System.out.println("Nenhuma loja cadastrada! Crie uma loja primeiro.");
            return;
        }
        
        if (listClientes.size() == 0) {
            System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("\n=== ADICIONAR CLIENTES À LOJA ===");
        System.out.println("Escolha a loja:");
        for (int i = 0; i < listLojas.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listLojas.get(i).getNomeFantasia());
        }
        
        int lojaIndex = getIntFromUser("Digite o número da loja: ") - 1;
        if (lojaIndex < 0 || lojaIndex >= listLojas.size()) {
            System.out.println("Índice de loja inválido!");
            return;
        }

        Loja lojaSelecionada = listLojas.get(lojaIndex);
        
        System.out.println("\nEscolha os clientes para adicionar à loja " + lojaSelecionada.getNomeFantasia() + ":");
        for (int i = 0; i < listClientes.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listClientes.get(i).getNome());
        }
        
        System.out.println("Digite os números dos clientes separados por vírgula (ex: 1,3,5) ou 0 para cancelar:");
        String input = scan.next();
        
        if (input.equals("0")) {
            System.out.println("Operação cancelada.");
            return;
        }

        String[] indices = input.split(",");
        int clientesAdicionados = 0;
        
        for (String indice : indices) {
            try {
                int clienteIndex = Integer.parseInt(indice.trim()) - 1;
                if (clienteIndex >= 0 && clienteIndex < listClientes.size()) {
                    System.out.println("Cliente " + listClientes.get(clienteIndex).getNome() + " selecionado para adicionar à loja.");
                    clientesAdicionados++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido: " + indice);
            }
        }
        
        System.out.println(clientesAdicionados + " cliente(s) selecionado(s) para adicionar à loja " + lojaSelecionada.getNomeFantasia());
    }

    public static void addVendedoresToLoja() {
        if (listLojas.size() == 0) {
            System.out.println("Nenhuma loja cadastrada! Crie uma loja primeiro.");
            return;
        }
        
        if (listVendedores.size() == 0) {
            System.out.println("Nenhum vendedor cadastrado! Cadastre um vendedor primeiro.");
            return;
        }

        System.out.println("\n== ADICIONAR VENDEDORES À LOJA ===");
        System.out.println("Escolha a loja:");
        for (int i = 0; i < listLojas.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listLojas.get(i).getNomeFantasia());
        }
        
        int lojaIndex = getIntFromUser("Digite o número da loja: ") - 1;
        if (lojaIndex < 0 || lojaIndex >= listLojas.size()) {
            System.out.println("Índice de loja inválido!");
            return;
        }

        Loja lojaSelecionada = listLojas.get(lojaIndex);
        
        System.out.println("\nEscolha os vendedores para adicionar à loja " + lojaSelecionada.getNomeFantasia() + ":");
        for (int i = 0; i < listVendedores.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listVendedores.get(i).getNome());
        }
        
        System.out.println("Digite os números dos vendedores separados por vírgula (ex: 1,3,5) ou 0 para cancelar:");
        String input = scan.next();
        
        if (input.equals("0")) {
            System.out.println("Operação cancelada.");
            return;
        }

        String[] indices = input.split(",");
        int vendedoresAdicionados = 0;
        
        for (String indice : indices) {
            try {
                int vendedorIndex = Integer.parseInt(indice.trim()) - 1;
                if (vendedorIndex >= 0 && vendedorIndex < listVendedores.size()) {
                    System.out.println("Vendedor " + listVendedores.get(vendedorIndex).getNome() + " selecionado para adicionar à loja.");
                    vendedoresAdicionados++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido: " + indice);
            }
        }
        
        System.out.println(vendedoresAdicionados + " vendedor(es) selecionado(s) para adicionar à loja " + lojaSelecionada.getNomeFantasia());
    }

    public static void addVendedorToLoja() {
        if (listLojas.size() == 0) {
            System.out.println("Nenhuma loja cadastrada! Crie uma loja primeiro.");
            return;
        }
        
        if (listVendedores.size() == 0) {
            System.out.println("Nenhum vendedor cadastrado! Cadastre um vendedor primeiro.");
            return;
        }

        System.out.println("\n=== ADICIONAR VENDEDOR À LOJA ===");
        System.out.println("Escolha a loja:");
        for (int i = 0; i < listLojas.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listLojas.get(i).getNomeFantasia());
        }
        
        int lojaIndex = getIntFromUser("Digite o número da loja: ") - 1;
        if (lojaIndex < 0 || lojaIndex >= listLojas.size()) {
            System.out.println("Índice de loja inválido!");
            return;
        }

        System.out.println("\nEscolha o vendedor:");
        for (int i = 0; i < listVendedores.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + listVendedores.get(i).getNome());
        }
        
        int vendedorIndex = getIntFromUser("Digite o número do vendedor: ") - 1;
        if (vendedorIndex < 0 || vendedorIndex >= listVendedores.size()) {
            System.out.println("Índice de vendedor inválido!");
            return;
        }
        Vendedor vendedorSelecionado = listVendedores.get(vendedorIndex);

        Loja lojaSelecionada = listLojas.get(lojaIndex);
        vendedorSelecionado.setLoja(lojaSelecionada);
        
        System.out.println("Vendedor " + vendedorSelecionado.getNome() + " foi adicionado à loja " + lojaSelecionada.getNomeFantasia() + " com sucesso!");
    }

    public static void openMenu() {
        System.out.println("Welcome to the systme!");

        Product product = new Product(dataProducts.size() + 1);
        product.setName("planta");
        product.setPrice(20);
        product.setDiscount(5);
        product.setQttMinimumForDiscount(10);
        dataProducts.add(product);

        boolean next = true;

        while (next) {
            System.out.println("\n\n=== SISTEMA DE GESTÃO ===");
            System.out.println("Digite o número da categoria que deseja:");
            System.out.println("\n-> PRODUTOS");
            System.out.println("  [1] - Cadastrar Produto");
            System.out.println("  [2] - Relatório de Produtos");
            System.out.println("\n-> VENDAS");
            System.out.println("  [3] - Realizar Venda");
            System.out.println("  [4] - Relatório de Vendas");
            System.out.println("  [5] - Relatório de Vendas por dia/mês");
            System.out.println("\n-> LOJAS");
            System.out.println("  [6] - Criar Loja");
            System.out.println("  [7] - Listar Lojas");
            System.out.println("  [8] - Adicionar Clientes à Loja");
            System.out.println("  [9] - Adicionar Vendedores à Loja");
            System.out.println("\n-> CLIENTES");
            System.out.println("  [10] - Cadastrar Cliente");
            System.out.println("  [11] - Listar Clientes");
            System.out.println("\n-> VENDEDORES");
            System.out.println("  [12] - Cadastrar Vendedor");
            System.out.println("  [13] - Listar Vendedores");
            System.out.println("  [14] - Adicionar vendedor à loja");
            System.out.println("\n-> GERENTES");
            System.out.println("  [15] - Cadastrar Gerente");
            System.out.println("  [16] - Listar Gerentes");
            System.out.println("\n-> PEDIDOS");
            System.out.println("  [17] - Processar Pedido");
            System.out.println("\n[0] - Sair");
            
            System.out.print("\nDigite sua opção: ");
            String option = scan.next();

            if (option.equals("1")) {
                createNewProduct();
            } else if (option.equals("2")) {
                reportProducts();
            } else if (option.equals("3")) {
                makeSale();
            } else if (option.equals("4")) {
                reportSales();
            } else if (option.equals("5")) {
                reportSalesByDayAndMonth();
            } else if (option.equals("6")) {
                createLoja();
            } else if (option.equals("7")) {
                listLojas();
            } else if (option.equals("8")) {
                addClientesALoja();
            } else if (option.equals("9")) {
                addVendedoresToLoja();
            } else if (option.equals("10")) {
                createCliente();
            } else if (option.equals("11")) {
                listClientes();
            } else if (option.equals("12")) {
                createVendedor();
            } else if (option.equals("13")) {
                listVendedores();
            } else if (option.equals("14")) {
                addVendedorToLoja();
            } else if (option.equals("15")) {
                createGerente();
            } else if (option.equals("16")) {
                listGerentes();
            } else if (option.equals("17")) {
                processarPedido();
            } else if (option.equals("0")) {
                System.out.println("Obrigado por usar o sistema!");
                next = false;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scan.close();
    }

    public static void main(String[] args) {
        openMenu();
    }
}