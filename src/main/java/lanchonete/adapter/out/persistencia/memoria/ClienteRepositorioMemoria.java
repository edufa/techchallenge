package lanchonete.adapter.out.persistencia.memoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.porta.out.persistencia.ClienteRepositorio;

public class ClienteRepositorioMemoria implements ClienteRepositorio {

	private AtomicInteger id = new AtomicInteger();
	private Map<Integer, Cliente> clientes;

	public ClienteRepositorioMemoria() {
		this.clientes = new HashMap<>();
	}


	@Override
	public Optional<Cliente> buscar(CPF cpf) {
		return clientes.entrySet().stream()
			.map(i -> i.getValue())
			.filter(c -> c.getCpf().equals(cpf))
			.findFirst();
	}

	@Override
	public void salvar(Cliente cliente) {
		if (cliente.getId() == null)
			cliente.setId(id.addAndGet(1));
		clientes.put(cliente.getId(), cliente);
	}

}
