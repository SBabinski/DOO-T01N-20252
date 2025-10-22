import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherService service = new WeatherService();

        System.out.println("Digite o nome da cidade:");
        String cidade = scanner.nextLine();

        WeatherInfo info = service.getWeatherData(cidade);
        
        if (info != null) {
            System.out.println(info.toString());
        } else {
            System.out.println("Erro ao buscar informações do tempo para: " + cidade);
        }

        scanner.close();
    }
}