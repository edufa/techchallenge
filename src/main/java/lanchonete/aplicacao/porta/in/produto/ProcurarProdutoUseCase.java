package lanchonete.aplicacao.porta.in.produto;

import java.util.Collection;

import lanchonete.aplicacao.dominio.produto.Produto;
import lanchonete.aplicacao.dominio.produto.TipoDeProduto;

public interface ProcurarProdutoUseCase {

	Collection<Produto> buscar(TipoDeProduto tipo);

	void salvar(Produto produto);

}
