package lanchonete.adapter.out.persistencia.jpa;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lanchonete.aplicacao.dominio.produto.TipoDeProduto;

@Entity
@Table(name = "produto")
public class ProdutoJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoDeProduto tipo;

	@Column(name = "precoUnitario", nullable = false)
	private BigDecimal precoUnitario;

	
	// CONSTRUCTOR
	
	public ProdutoJpaEntity(String nome, TipoDeProduto tipo, BigDecimal precoUnitario) {
		this.nome = nome.trim();
		this.tipo = tipo;
		this.precoUnitario = precoUnitario;
	}
	public ProdutoJpaEntity(Integer id, String nome, TipoDeProduto tipo, BigDecimal precoUnitario) {
		this(nome, tipo, precoUnitario);
		this.id = id;
	}
	
	
	// GETTER / SETTER
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoDeProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeProduto tipo) {
		this.tipo = tipo;
	}
	
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	
	

}