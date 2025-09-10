package services;

import java.math.BigDecimal;
import java.util.List;

//import apresentarse.ApresentarCalculoBonus;
import model.Vendedores;

public class CalculoBonusVendedores {

	//ApresentarCalculoBonus acb = new ApresentarCalculoBonus();

	public void apresentarseCalculoBonusDeVendedores(CadastroVendedores v) {

		List<Vendedores> listaDosVendedores = v.printaVendedoresNaTela();

		if (listaDosVendedores.isEmpty()) {
			System.out.println("Não existe nenhum vendedor registrado!");
			return;
		}

		for (Vendedores vendedores : listaDosVendedores) {

			BigDecimal base = vendedores.getSalarioBase();
			BigDecimal pegandoBonus = base.multiply(new BigDecimal("0.20"));
			BigDecimal resultFinal = base.add(pegandoBonus);

			// acb.apresentandoCalculoDeBonusDosSalarios(v, resultFinal);

			System.out.println("Nome: " + vendedores.getNome() + " | Salario Base: " + vendedores.getSalarioBase()
					+ " | Salario Base com Bonus de 20%: " + resultFinal);

		}

	}

}
