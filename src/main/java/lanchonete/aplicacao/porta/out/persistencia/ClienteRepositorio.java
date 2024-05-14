package lanchonete.aplicacao.porta.out.persistencia;

import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;

public interface ClienteRepositorio {

	Optional<Cliente> buscar(CPF cpf);

	void salvar(Cliente cliente);

}
