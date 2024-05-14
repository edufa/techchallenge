package lanchonete.aplicacao.dominio.pedido;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.dominio.produto.TipoDeProduto;

public class Combo {
	private Long id;
	private Integer clienteId;
	private Map<TipoDeProduto,ComboItem> itens;
	private SituacaoDoCombo situacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAlteracao;
	
	public Combo() {
		this.itens = new EnumMap<>(TipoDeProduto.class);
		this.situacao = SituacaoDoCombo.CRIADO;
		this.dataCriacao = LocalDateTime.now();
	}
	public Combo(Cliente cliente) {
		this.clienteId = cliente.getId();
		this.itens = new EnumMap<>(TipoDeProduto.class);
		this.situacao = SituacaoDoCombo.CRIADO;
		this.dataCriacao = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}
	
	public Map<TipoDeProduto, ComboItem> getItens() {
		return itens;
	}
	public void addItem(TipoDeProduto tipo, ComboItem item) {
		getItens().put(tipo, item);
		alterado();
	}
	
	public Collection<ComboItem> listar() {
		return getItens().values();
	}

	public SituacaoDoCombo getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoDoCombo situacao) {
		this.situacao = situacao;
		alterado();
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}
	public void alterado() {
		this.dataAlteracao = LocalDateTime.now();
	}
	
}
