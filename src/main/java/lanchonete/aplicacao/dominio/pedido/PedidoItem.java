package lanchonete.aplicacao.dominio.pedido;

import java.math.BigDecimal;

public class PedidoItem {
	private Long id;
	private Integer produtoId;
	private Integer quantidade;
	private BigDecimal valorUnitario;

	public PedidoItem(Integer produtoId, Integer quantidade, BigDecimal valorUnitario) {
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	
	public Long getId() {
		return id;
	}
	
	public Integer getProdutoId() {
		return produtoId;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public BigDecimal getValorUnitario() {
		if (valorUnitario == null)
			return BigDecimal.ZERO.setScale(2);
		return valorUnitario;
	}

	public BigDecimal getValor() {
		return getValorUnitario().multiply(new BigDecimal(quantidade)).setScale(2);
	}
	
}
