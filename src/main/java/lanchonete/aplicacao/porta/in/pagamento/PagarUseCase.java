package lanchonete.aplicacao.porta.in.pagamento;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface PagarUseCase {

	void adicionarProduto(Combo combo, Produto produto);
	
}
