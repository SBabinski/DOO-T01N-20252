public class Tempo {
    private String cidade;
    private double tAtual;
    private double tMax;
    private double tMin;
    private int umidade;
    private String condicao;
    private double precipitacao;
    private double ventoVeloc;
    private double ventoDirec;

    public Tempo(String cidade, double tAtual, double tMax, double tMin,int umidade,
                 String condicao, double precipitacao, double ventoVeloc, double ventoDirec){
        this.cidade = cidade;
        this.tAtual = tAtual;
        this.tMax = tMax;
        this.tMin = tMin;
        this.umidade = umidade;
        this.condicao = condicao;
        this.precipitacao = precipitacao;
        this.ventoVeloc = ventoVeloc;
        this.ventoDirec = ventoDirec;
    }
    @Override
    public String toString(){
        return String.format(
                "Cidade: %s\n" +
                "Temperatura atual: %.1f °C\n" +
                "Máxima: %.1f °C\n" +
                "Mínima %.1f °C\n" +
                "Umidade: %d%%\n" +
                "Condição: %s\n" +
                "Precipitação: %.1f mm\n" +
                "Vento: %.1f km/h (%.0f°)",
                cidade, tAtual, tMax, tMin, umidade, condicao, precipitacao,
                ventoVeloc, ventoDirec);
    }
}




