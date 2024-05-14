package lanchonete.aplicacao.porta.out.persistencia;

import java.util.Collection;

import lanchonete.aplicacao.dominio.produto.Produto;
import lanchonete.aplicacao.dominio.produto.TipoDeProduto;

public interface ProdutoRepositorio {

	Collection<Produto> buscar(TipoDeProduto tipo);

	Collection<Produto> buscar();

	void salvar(Produto produto);
	
}
