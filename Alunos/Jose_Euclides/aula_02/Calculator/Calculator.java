package Calculator;
import java.util.Scanner;

public class Calculator {
    private static Scanner scan = new Scanner(System.in);

    public static double getDouble(String message) {
        System.out.println(message);
        return scan.nextDouble();
    }

    public static int getInt(String message) {
        System.out.println(message);
        return scan.nextInt();
    }

    public static double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }

    public static double calculateChange(double price, double paid) {
        return paid - price;
    }

    public static void pageCalculateTotalPrice() {
        double price = getDouble("Digite o preço do produto: ");
        int quantity = getInt("Digite a quantidade do produto: ");
        double total = calculateTotalPrice(price, quantity);
        System.out.println("O preço total do produto é: " + total);
    }

    public static void pageCalculateChange() {
        double priceTotal = getDouble("Digite o preço total: ");
        double amountPaid = getDouble("Digite o valor pago pelo cliente: ");

        double change = calculateChange(priceTotal, amountPaid);
        
        System.out.println("O troco para o cliente é: " + change);
    }

    public static void openMenu() {
        System.out.println("Welcome to the calculator");

        boolean next = true;

        while (next) {
            System.out.println(
                    "\n\nDigite o número da operação que deseja: \n[1] - Calcular Preço Total\n[2] - Calcular Troco\n[3] - Sair");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    pageCalculateTotalPrice();
                    break;
                case 2:
                    pageCalculateChange();
                    break;
                case 3:
                    System.out.println("Obrigaod por usar a calculadora!");
                    next = false;
                    break;
            }
        }
        
        scan.close();
    }
}