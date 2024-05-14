package lanchonete.aplicacao.dominio.cliente;

public class Cliente {
	private Integer id;
	private CPF cpf;
	private String nome;
	private String email;

	public Cliente(CPF cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	public Cliente(Integer id, CPF cpf, String nome, String email) {
		this(cpf, nome, email);
		this.id = id;
	}
	
	
	// GETTER
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CPF getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}

}
