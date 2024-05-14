package lanchonete.adapter.out.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lanchonete.aplicacao.dominio.cliente.CPF;

@Entity
@Table(name = "cliente")
public class ClienteJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private CPF cpf;

	@Column(name = "email", nullable = false)
	private String email;

	
	// CONSTRUCTOR
	
	public ClienteJpaEntity(CPF cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome.trim();
		this.email = email;
	}
	
	
	// GETTER / SETTER
	
	public Integer getId() {
		return id;
	}
	
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}