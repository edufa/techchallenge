package lanchonete.aplicacao.service;

import lanchonete.aplicacao.dominio.cliente.CPF;

public class JaExisteUmClienteComEsseCPF extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private CPF cpf;

	public JaExisteUmClienteComEsseCPF(CPF cpf) {
		this.cpf = cpf;
	}

	public CPF getCpf() {
		return cpf;
	}
	
}
