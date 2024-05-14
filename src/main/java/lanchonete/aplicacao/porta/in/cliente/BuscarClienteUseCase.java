package lanchonete.aplicacao.porta.in.cliente;

import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;

public interface BuscarClienteUseCase {

	Optional<Cliente> buscar(CPF cpf);
	
}
