package lanchonete.aplicacao.service;

import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.cliente.CadastrarClienteUseCase;
import lanchonete.aplicacao.porta.out.persistencia.ClienteRepositorio;

public class ClienteService implements BuscarClienteUseCase, CadastrarClienteUseCase {

	private ClienteRepositorio clienteRepositorio;
	
	public ClienteService(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	
	
	@Override
	public Optional<Cliente> buscar(CPF cpf) {
	    if (cpf.isNull())
	    	return Optional.empty();
	    return clienteRepositorio.buscar(cpf);
	}

	
	@Override
	public Cliente cadastrar(CPF cpf, String nome, String email) {
	    if (cpf.isNull())
			throw new IllegalArgumentException("'cpf' é obrigatório");
	    if (nome == null || nome.isBlank() || nome.isEmpty())
			throw new IllegalArgumentException("'nome' é obrigatório");
	    nome = nome.trim();
	
	    if (email == null || email.isBlank() || email.isEmpty())
			throw new IllegalArgumentException("'email' é obrigatório");
	    email = email.trim();
	    
		Optional<Cliente> potencialCliente = buscar(cpf);
		if (potencialCliente.isPresent())
			throw new JaExisteUmClienteComEsseCPF(cpf);
		
		Cliente cliente = new Cliente(cpf, nome, email);
		clienteRepositorio.salvar(cliente);
		return cliente;
	}

}
