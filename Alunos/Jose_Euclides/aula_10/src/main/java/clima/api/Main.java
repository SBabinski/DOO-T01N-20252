package clima.api;

import clima.api.model.City;
import clima.api.model.Weather;
import clima.api.service.CityService;
import clima.api.service.WeatherService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

@SpringBootApplication
public class Main {

    private static WeatherService weatherService;
    private static CityService cityService;

    public static void main(String[] args) {
        // Configura o Spring Boot para não iniciar o servidor web
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);

        // Get services from Spring context
        weatherService = context.getBean(WeatherService.class);
        cityService = context.getBean(CityService.class);

        SwingUtilities.invokeLater(() -> createView());
    }

    public static JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    public static class InputException extends RuntimeException {
        public InputException(String message) {
            super(message);
        }
    }

    public static void createView() { // Cria toda a parte de visualização
        JFrame frame = createFrame("Clima - Consulta de Tempo");
        frame.setLayout(new BorderLayout());

        JPanel selectPanelCity = createCitySelectionPanel(frame);

        JPanel weatherPanel = createWeatherDisplayPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(selectPanelCity, BorderLayout.NORTH);
        mainPanel.add(weatherPanel, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);
    }

    private static JPanel createCitySelectionPanel(JFrame frame) {
        JPanel selectPanel = new JPanel(new FlowLayout());
        selectPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        selectPanel.setBackground(new Color(240, 248, 255));

        JLabel labelSelectCity = new JLabel("Cidade:");
        labelSelectCity.setFont(new Font("Arial", Font.BOLD, 14));

        JComboBox<String> cityComboBox = new JComboBox<>();
        cityComboBox.setPreferredSize(new Dimension(300, 30));
        cityComboBox.addItem("Selecione uma cidade...");
        cityComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        JButton loadingCitiesButton = new JButton("Carregando Cidades...");
        loadingCitiesButton.setFont(new Font("Arial", Font.BOLD, 12));
        loadingCitiesButton.setPreferredSize(new Dimension(150, 30));
        loadingCitiesButton.setBackground(new Color(70, 130, 180));
        loadingCitiesButton.setForeground(Color.WHITE);
        loadingCitiesButton.setFocusPainted(false);
        loadingCitiesButton.setBorderPainted(false);

        selectPanel.add(labelSelectCity);
        selectPanel.add(Box.createHorizontalStrut(10));
        selectPanel.add(cityComboBox);
        selectPanel.add(Box.createHorizontalStrut(10));
        selectPanel.add(loadingCitiesButton);

        try {
            cityComboBox.removeAllItems();
            cityComboBox.addItem("Carregando cidades...");
            loadingCitiesButton.setEnabled(false);

            Thread loadingThread = new Thread(() -> {
                try {
                    var cities = cityService.getAllCities();

                    SwingUtilities.invokeLater(() -> {
                        cityComboBox.removeAllItems();
                        cityComboBox.addItem("Selecione uma cidade...");
                        for (City city : cities) {
                            String cityDisplayName = city.getNameAndStateString();
                            cityComboBox.addItem(cityDisplayName);
                        }
                        cityComboBox.setSelectedItem("Selecione uma cidade...");
                        loadingCitiesButton.setEnabled(true);
                        loadingCitiesButton.setVisible(false);
                    });
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        cityComboBox.removeAllItems();
                        cityComboBox.addItem("Erro ao carregar cidades");
                        loadingCitiesButton.setEnabled(true);
                        JOptionPane.showMessageDialog(frame, "Erro ao carregar cidades: " + ex.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    });
                }
            });
            loadingThread.start();

        } catch (Exception ex) {
            cityComboBox.removeAllItems();
            cityComboBox.addItem("Erro ao carregar cidades");
            loadingCitiesButton.setEnabled(true);
            JOptionPane.showMessageDialog(frame, "Erro ao carregar cidades: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        cityComboBox.addActionListener(e -> {
            String selectedCity = (String) cityComboBox.getSelectedItem();
            if (selectedCity != null &&
                    !selectedCity.equals("Selecione uma cidade...") &&
                    !selectedCity.equals("Carregando cidades...") &&
                    !selectedCity.equals("Erro ao carregar cidades")) {

                try {
                    String[] parts = selectedCity.split(" - ");
                    String cityName = parts[0];
                    String state = parts.length > 1 ? parts[1] : "";

                    displayWeatherInfo(frame, cityName, state);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Erro ao buscar informações do clima: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return selectPanel;
    }

    private static JPanel createWeatherDisplayPanel() {
        JPanel weatherPanel = new JPanel(new GridBagLayout());
        weatherPanel.setBackground(Color.WHITE);
        weatherPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel infoLabel = new JLabel("Selecione uma cidade para ver informações do clima");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        infoLabel.setForeground(new Color(70, 70, 70));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        weatherPanel.add(infoLabel, gbc);

        return weatherPanel;
    }

    private static void displayWeatherInfo(JFrame frame, String cityName, String state) {
        try {
            Weather weather = weatherService.getWeatherByCity(cityName, state);
            Weather.Day today = getTodayWeather(weather);

            if (today == null) {
                JOptionPane.showMessageDialog(frame,
                        "Dados do clima não disponíveis para hoje",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JDialog weatherDialog = new JDialog(frame, "Informações do Clima - " + cityName, true);
            weatherDialog.setLayout(new BorderLayout());
            weatherDialog.setSize(600, 500);
            weatherDialog.setLocationRelativeTo(frame);
            weatherDialog.setResizable(false);

            JPanel contentPanel = new JPanel(new GridBagLayout());
            contentPanel.setBackground(Color.WHITE);
            contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST;

            JLabel cityLabel = new JLabel(cityName + ", " + state);
            cityLabel.setFont(new Font("Arial", Font.BOLD, 24));
            cityLabel.setForeground(new Color(70, 130, 180));

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            contentPanel.add(cityLabel, gbc);

            if (today.getTemp() != null) {
                JLabel currentTempLabel = new JLabel("Temperatura Atual: " + formatTemperature(today.getTemp()));
                currentTempLabel.setFont(new Font("Arial", Font.BOLD, 20));
                currentTempLabel.setForeground(new Color(220, 20, 60));

                gbc.gridy++;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.insets = new Insets(15, 10, 10, 10);
                contentPanel.add(currentTempLabel, gbc);
            }

            if (today.getTempMin() != null && today.getTempMax() != null) {
                JLabel tempRangeLabel = new JLabel(
                        "Mínima: " + formatTemperature(today.getTempMin()) +
                                " | Máxima: " + formatTemperature(today.getTempMax()));
                tempRangeLabel.setFont(new Font("Arial", Font.PLAIN, 16));

                gbc.gridy++;
                gbc.insets = new Insets(10, 10, 10, 10);
                contentPanel.add(tempRangeLabel, gbc);
            }

            if (today.getConditions() != null) {
                JLabel conditionsLabel = new JLabel("Condições: " + today.getConditions());
                conditionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
                conditionsLabel.setForeground(new Color(50, 50, 50));

                gbc.gridy++;
                contentPanel.add(conditionsLabel, gbc);
            }

            if (today.getHumidity() != null) {
                JLabel humidityLabel = new JLabel("Humidade: " + formatDecimal(today.getHumidity()) + "%");
                humidityLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                gbc.gridy++;
                contentPanel.add(humidityLabel, gbc);
            }

            if (today.getPrecip() != null && today.getPrecip() > 0) {
                JLabel precipLabel = new JLabel("Precipitação: " + formatDecimal(today.getPrecip()) + " mm");
                precipLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                precipLabel.setForeground(new Color(0, 100, 200));

                gbc.gridy++;
                contentPanel.add(precipLabel, gbc);
            }

            if (today.getWindSpeed() != null && today.getWindDir() != null) {
                String windDirText = getWindDirection(today.getWindDir());
                JLabel windLabel = new JLabel(
                        "Vento: " + formatDecimal(today.getWindSpeed()) + " km/h (" + windDirText + ")");
                windLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                gbc.gridy++;
                contentPanel.add(windLabel, gbc);
            }

            JLabel dateLabel = new JLabel("Data: " + today.getDatetime());
            dateLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            dateLabel.setForeground(new Color(120, 120, 120));

            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            contentPanel.add(dateLabel, gbc);

            JButton closeButton = new JButton("Fechar");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setPreferredSize(new Dimension(120, 35));
            closeButton.setBackground(new Color(70, 130, 180));
            closeButton.setForeground(Color.WHITE);
            closeButton.setFocusPainted(false);
            closeButton.setBorderPainted(false);
            closeButton.addActionListener(e -> weatherDialog.dispose());

            gbc.gridy++;
            gbc.insets = new Insets(20, 10, 10, 10);
            contentPanel.add(closeButton, gbc);

            weatherDialog.add(contentPanel, BorderLayout.CENTER);
            weatherDialog.setVisible(true);

        } catch (WeatherService.WeatherServiceException e) {
            JOptionPane.showMessageDialog(frame,
                    "Erro ao buscar dados do clima:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Weather.Day getTodayWeather(Weather weather) {
        if (weather == null || weather.getDays() == null || weather.getDays().isEmpty()) {
            return null;
        }
        return weather.getDays().get(0);
    }

    private static String formatTemperature(Double temp) {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(temp) + "°C";
    }

    private static String formatDecimal(Double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(value);
    }

    private static String getWindDirection(Double degrees) {
        String[] directions = { "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW" };
        int index = (int) Math.round((degrees % 360) / 22.5);
        return directions[index % 16];
    }
}
