package com.example.apiclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoInfo {

    public double temp;
    public double tempmax;
    public double tempmin;
    public double humidity;
    public String conditions;
    public double precip;
    public double windspeed;
    public double winddir;

    // Método para converter JSON da API em objeto RepoInfo
    // É estático para poder ser chamado diretamente: RepoInfo.fromJson(json)
    public static RepoInfo fromJson(String jsonResponse) throws Exception {
        // Cria o parser JSON do Jackson para processar a string
        ObjectMapper mapper = new ObjectMapper();
        
        // Converte a string JSON em uma árvore de nós para navegar pelos dados
        JsonNode root = mapper.readTree(jsonResponse);    
        
        // Extrai as condições atuais (temperatura, umidade, vento atuais)
        JsonNode current = root.get("currentConditions");
        
        // Extrai dados do primeiro dia (temperatura máxima/mínima, precipitação)
        // A API Visual Crossing separa dados atuais dos dados diários
        JsonNode today = root.get("days").get(0); // primeiro dia
        
        // Cria nova instância para preencher com os dados extraídos
        RepoInfo info = new RepoInfo();
        
        // DADOS ATUAIS (do currentConditions):
        info.temp = current.get("temp").asDouble();           // Temperatura atual
        info.humidity = current.get("humidity").asDouble();   // Umidade atual
        info.conditions = current.get("conditions").asText(); // Condições
        info.windspeed = current.get("windspeed").asDouble(); // Velocidade do vento atual
        info.winddir = current.get("winddir").asDouble();     // Direção do vento atual
        
        // DADOS DO DIA (do primeiro item do array days):
        info.tempmax = today.get("tempmax").asDouble();       // Temperatura máxima do dia
        info.tempmin = today.get("tempmin").asDouble();       // Temperatura mínima do dia
        info.precip = today.get("precip").asDouble();         // Precipitação do dia
        
        // Retorna o objeto preenchido com todos os dados do clima
        return info;
    }

    @Override
    public String toString() {
        return " Temperatura atual: " + temp + "°C" +
                "\n Temperatura Máxima: " + tempmax + "°C" +
                "\n Temperatura Minima: " + tempmin + "°C" +
                "\n Humidade atual: " + humidity + "%" +
                "\n Condição atual: " + conditions +
                "\n Precipitação: " + precip + "mm" +
                "\n Velocidade do vento : " + windspeed + "Km/h, direção: " + winddir;
    }
}