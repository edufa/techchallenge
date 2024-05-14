package lanchonete.aplicacao.dominio.pedido;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

import lanchonete.aplicacao.dominio.produto.TipoDeProduto;

public class Pedido {
	private Long id;
	private Integer clienteId;
	private Map<TipoDeProduto,PedidoItem> itens;
	private SituacaoDoPedido situacao;
	
	public Pedido(Combo combo) {
		this.itens = new EnumMap<>(TipoDeProduto.class);
		this.situacao = SituacaoDoPedido.RECEBIDO;
		for (Entry<TipoDeProduto, ComboItem> entry : combo.getItens().entrySet())
			itens.put(entry.getKey(), new PedidoItem(
					entry.getValue().getProdutoId(), 
					entry.getValue().getQuantidade(),
					entry.getValue().getValorUnitario()));	
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}
	
	public Map<TipoDeProduto, PedidoItem> getItens() {
		return itens;
	}
	
	public Collection<PedidoItem> listar() {
		return getItens().values();
	}
	
	public BigDecimal getValor() {
		BigDecimal valor = BigDecimal.ZERO.setScale(2);
		for (PedidoItem item : listar())
			if (item.getQuantidade() > 0)
				valor = valor.add(item.getValor());
		return valor;
	}

	public SituacaoDoPedido getSituacao() {
		return situacao;
	}
	
}
