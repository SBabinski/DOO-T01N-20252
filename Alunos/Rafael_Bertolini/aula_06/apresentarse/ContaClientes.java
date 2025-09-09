package apresentarse;

import java.util.List;

import model.Clientes;
import services.CadastroDeClientes;

public class ContaClientes {

	public void contaClientes(CadastroDeClientes chamaListaClientes) {

		List<Clientes> listaDeClientesParaCont = chamaListaClientes.chamaListaDeClientes();
		int cont = 0;

		if (listaDeClientesParaCont.isEmpty()) {

			System.out.println("Não existe cliente cadastrado no sistema da loja MyPlant");

		} else {

			System.out.println("A seguir, o nome de todos clientes registrados: ");
			System.out.println(" ");

			for (Clientes listaClientes : listaDeClientesParaCont) {

				System.out.println("Nome: " + listaClientes.getNome());
				cont++;

			}
		}

		System.out.println(" ");
		System.out.println("O numero total de clientes é de: " + cont);
		System.out.println(" ");

	}

}
