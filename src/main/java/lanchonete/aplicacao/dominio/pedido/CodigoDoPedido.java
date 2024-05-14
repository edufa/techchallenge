package lanchonete.aplicacao.dominio.pedido;

import java.time.Year;

public class CodigoDoPedido {
	private Integer codigo;
	private Year ano;
	
	private CodigoDoPedido() {
		this.codigo = 1;
		this.ano = Year.now();
	}
	private CodigoDoPedido(int codigo, Year ano) {
		this.codigo = codigo;
		this.ano = ano;
	}
	
	
	public static CodigoDoPedido of(int codigo, int ano) {
		return new CodigoDoPedido(codigo, Year.of(ano));
	}

	public CodigoDoPedido proximo() {
		return new CodigoDoPedido(codigo+1, ano);
	}
	

	@Override
	public String toString() {
		return codigo.toString();
	}
	
}
