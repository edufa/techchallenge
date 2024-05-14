package lanchonete.aplicacao.porta.in.cliente;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;

public interface CadastrarClienteUseCase {

	Cliente cadastrar(CPF cpf, String nome, String email);
	
}
