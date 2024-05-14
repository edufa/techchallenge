package lanchonete.aplicacao.porta.in.pedido;

import lanchonete.aplicacao.dominio.pedido.Combo;
import lanchonete.aplicacao.dominio.produto.Produto;

public interface AdicionarProdutoUseCase {

	void adicionarProduto(Combo combo, Produto produto);
	
}
