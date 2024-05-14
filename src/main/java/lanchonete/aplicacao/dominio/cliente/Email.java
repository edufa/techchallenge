package lanchonete.aplicacao.dominio.cliente;

public class Email {
	public static final Email NULL = new Email(null);
	private String valor;
	
	private Email(String valor) {
		this.valor = valor;
	}
	
	public Email of(String valor) {
		if (valor == null || valor.isBlank() || valor.isEmpty())
			return NULL;
		valor = valor.trim();
		if (valor.indexOf("@") < 0)
			throw new IllegalArgumentException("Obrigatório @ no email");
		return new Email(valor);
	}
	
	public String getValor() {
		return valor;
	}
	
}
