package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.pedido.Pedido;

public interface CriarPedidoUseCase {

	Pedido criar(Combo combo);
	
}
