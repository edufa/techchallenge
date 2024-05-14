package lanchonete.aplicacao.dominio.produto;

import java.math.BigDecimal;

public class Produto {
	private Integer id;
	private String nome;
	private BigDecimal valor;
	private TipoDeProduto tipo;
	
	public Produto() {
	}
	public Produto(Integer id, String nome, TipoDeProduto tipo, BigDecimal precoUnitario) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = precoUnitario;
	}

	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public TipoDeProduto getTipo() {
		return tipo;
	}

}
