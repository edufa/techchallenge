package lanchonete.aplicacao.dominio.pedido;

import java.math.BigDecimal;

public class ComboItem {
	private Long id;
	private Integer produtoId;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	
	
	public ComboItem() {
		this.quantidade = 0;
		this.valorUnitario = BigDecimal.ZERO.setScale(2);
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
