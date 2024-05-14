package lanchonete.adapter.in.rest;

import jakarta.json.bind.annotation.JsonbCreator;
import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;

public record ClienteWebModel(Integer id, String cpf, String nome, String email) {

    @JsonbCreator
    public ClienteWebModel {}
    
	public static ClienteWebModel fromDominio(Cliente cliente) {
		return new ClienteWebModel(cliente.getId(), cliente.getCpf().toString(), cliente.getNome(), cliente.getEmail());
	}
	
}
