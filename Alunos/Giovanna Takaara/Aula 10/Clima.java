public class Clima {
    private String cidade;
    private double atual;
    private double max;
    private double min;
    private int umidade;
    private String condicao;
    private double ventoV;
    private double ventoD;


    public Clima(String cidade, double atual, double max, double min, int umidade, String
            condicao, double ventoV, double ventoD) {

        this.cidade = cidade;
        this.atual = atual;
        this.max = max;
        this.min = min;
        this.umidade = umidade;
        this.condicao = condicao;
        this.ventoV = ventoV;
        this.ventoD = ventoD;

    }
        @Override
        public String toString() {
            return "Cidade: " + cidade + "\nTemperatura Atual: " + atual + "\nTemperatura Máxima: " +
                    max + "\nTemperatura Mínima: " + min + "\nUmidade: " + umidade + "\nCondição: " +
                    condicao + "\nVelocidade do Vento: " + ventoV + "\nDireção do Vento: " + ventoD;

        }
    }

