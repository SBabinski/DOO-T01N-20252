import java.util.Scanner;

public class ConsoleUI {
    private final Scanner in;

    public ConsoleUI(Scanner in) { this.in = in; }

    public void println(String s) { System.out.println(s); }
    public void line() { System.out.println("--------------------------------------------------"); }
    public void error(String s) { System.err.println(s); }

    public String askLine(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }

    public int askInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Número inválido.");
            }
        }
    }
}
