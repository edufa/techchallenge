package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.pedido.Combo;

public interface CriarComboUseCase {

	Combo criar(Cliente cliente);
	
}
