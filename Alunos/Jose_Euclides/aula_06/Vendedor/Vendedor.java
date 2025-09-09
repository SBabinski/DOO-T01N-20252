package Vendedor;

import java.util.ArrayList;
import Loja.Loja;
import Pessoa.Pessoa;

public class Vendedor extends Pessoa {
    private Loja loja;
    private ArrayList<Double> salariosRecebidos;
    private double salarioBase; 


    public Vendedor() {
        super();
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public ArrayList<Double> getSalariosRecebidos() {
        return salariosRecebidos;
    }

    public void setSalariosRecebidos(ArrayList<Double> salariosRecebidos) {
        this.salariosRecebidos = salariosRecebidos;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void apresentarSe() {
         System.out.println("Nome: " + this.getNome());
         System.out.println("Idade: " + this.getIdade());
         System.out.println("Loja: " + (this.loja != null ? this.loja.toString() : "Nenhuma loja associada"));
    }

    public Double calcularMediaSalarial() {
        Double somaSalarios = 0.0;
        for(Double salario : this.salariosRecebidos) {
            somaSalarios += salario;
        }

        return (somaSalarios / this.salariosRecebidos.size());
    }

    public Double calcularBonus() {
        return (this.salarioBase * 0.2);
    }

    
}


