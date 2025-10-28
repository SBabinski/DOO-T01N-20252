# Aplicativo de Consulta de Clima

Aplicativo Java com interface gráfica Swing que consulta informações de clima e tempo para cidades brasileiras usando a API do Visual Crossing.

## Funcionalidades

- 📍 Consulta de clima para qualquer cidade do Brasil
- 🌡️ Temperatura atual, máxima e mínima
- 💧 Humidade do ar
- ☁️ Condições do tempo (chuva, sol, nublado, etc.)
- 🌧️ Precipitação em caso de chuva
- 💨 Velocidade e direção do vento

## Requisitos

- Java 21
- Maven 3.x
- API Key do Visual Crossing (gratuita)

## Configuração

### 1. Obter API Key

1. Acesse: https://www.visualcrossing.com/sign-up
2. Crie uma conta gratuita
3. Copie sua API Key

### 2. Configurar a API Key

Edite o arquivo `src/main/resources/application.properties` e substitua `YOUR_API_KEY_HERE` pela sua API Key:

```properties
weather.api.key=SUA_API_KEY_AQUI
```

## Como executar

### Usando Maven

```bash
mvn clean spring-boot:run
```

### Usando Maven Wrapper

No Windows:
```bash
mvnw.cmd spring-boot:run
```

No Linux/Mac:
```bash
./mvnw spring-boot:run
```

## Como usar

1. Execute o aplicativo
2. Clique em "Carregar Cidades" para carregar a lista de cidades brasileiras
3. Selecione uma cidade do dropdown
4. As informações do clima serão exibidas automaticamente em uma janela

## Estrutura do Projeto

```
src/main/java/clima/api/
├── Main.java          # Interface gráfica principal
├── Cities.java        # Classe para buscar cidades da API do IBGE
├── Weather.java       # Modelo de dados do clima
└── WeatherService.java # Serviço para buscar dados do Visual Crossing

src/main/resources/
└── application.properties  # Configurações da aplicação
```

## APIs Utilizadas

- **IBGE API**: https://servicodados.ibge.gov.br/api/v1/localidades/municipios
- **Visual Crossing Weather API**: https://www.visualcrossing.com/weather-api

## Documentação

- Documentação da API Visual Crossing: https://www.visualcrossing.com/resources/documentation/weather-api/timeline-weather-api/
- Plano gratuito: https://www.visualcrossing.com/sign-up

## Tecnologias

- Java 21
- Spring Boot 3.5.6
- Jackson (JSON parsing)
- Swing (Interface gráfica)

## Autor

Jose Euclides

## Licença

Este projeto é para fins educacionais.

