import java.util.ArrayList;
import java.util.Scanner;
import Product.Product;
import Sales.Sale;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Product> dataProducts = new ArrayList<>();
    private static ArrayList<Sale> listSales = new ArrayList<>();

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
            System.out.println(
                    "\n\nDigite o número da operação que deseja: \n[1] - Cadastrar Produto\n[2]- Relatório de Produtos\n[3] - Realizar Venda\n[4] - Report Vendas\n[5] - Sair");
            int option = scan.nextInt();

            if (option == 1) {
                createNewProduct();
            } else if (option == 2) {
                reportProducts();
            } else if (option == 3) {
                makeSale();
            } else if (option == 4) {
                reportSales();
            } else {
                System.out.println("Obrigado por usar o sistema!");
                next = false;
            }
        }

        scan.close();
    }

    public static void main(String[] args) {
        openMenu();
    }
}