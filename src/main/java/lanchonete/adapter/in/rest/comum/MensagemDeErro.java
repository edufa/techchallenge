package lanchonete.adapter.in.rest.comum;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.core.Response;

public class MensagemDeErro {
	
	public static ClientErrorException badRequest(String mensagem) {
		return new ClientErrorException(mensagem(Response.Status.BAD_REQUEST, mensagem));
	}
	
	public static Response mensagem(Response.Status status, String mensagem) { 
		ErroRest erroEntity = new ErroRest(status.getStatusCode(), mensagem);
    	return Response.status(status).entity(erroEntity).build();
	}
	
}
