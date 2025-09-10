package services;

import java.util.List;

import model.Clientes;

public class ApresentarClientes {

	public void apresentarseClientes(CadastroDeClientes chamandoCadastroClientes) {

		List<Clientes> listaDeClientes = chamandoCadastroClientes.chamaListaDeClientes();

		if (listaDeClientes.isEmpty()) {
			System.out.println("Não existe nenhum cliente registrado!");
			return;
		}

		for (Clientes clientes : listaDeClientes) {

			System.out.println("Nome: " + clientes.getNome() + " | Idade: " + clientes.getIdade());

		}
	}

}
