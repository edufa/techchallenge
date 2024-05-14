package lanchonete.adapter.in.rest;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.CPFInvalido;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import lanchonete.aplicacao.porta.in.cliente.CadastrarClienteUseCase;
import lanchonete.aplicacao.service.ClienteService;
import lanchonete.aplicacao.service.JaExisteUmClienteComEsseCPF;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteController extends AbstractController {

	private final BuscarClienteUseCase buscarClienteUseCase;
	private final CadastrarClienteUseCase cadastrarClienteUseCase;

	public ClienteController(ClienteService clienteService) {
		this.buscarClienteUseCase = clienteService;
		this.cadastrarClienteUseCase = clienteService;
	}

	@GET
	@Path("/buscar/{cpf}")
	public ClienteWebModel buscar(@PathParam("cpf") String cpfString) {
		CPF cpf = CPF.parse(cpfString);
		if (cpf.isNull())
			throw badRequest("CPF inválido");

		Optional<Cliente> optional = Optional.empty();
		try {
			optional = buscarClienteUseCase.buscar(cpf);
		} catch (Exception e) {
			throw badRequest("Ocorreu um erro");
		}
		
		if (optional.isEmpty())
			throw badRequest("Cliente não encontrado");
		
		return ClienteWebModel.fromDominio(optional.get());
	}

	
	@POST
	@Path("/")
	public Response cadastrar(
			String requestJson
			) {

		ClienteWebModel model = null;
		try {
			model = lerJson(requestJson, ClienteWebModel.class);
		} catch (Exception e) {
			throw badRequest("Erro ao ler json");
		}
		
		CPF cpf = CPF.NULL;
		try {
			cpf = CPF.of(model.cpf());
		} catch (CPFInvalido e) {
			throw badRequest("CPF informado é inválido: "+e.getMessage());
		}
		
		Cliente cliente = null;
		try {
			cliente = cadastrarClienteUseCase.cadastrar(cpf, model.nome(), model.email());
		} catch (JaExisteUmClienteComEsseCPF e) {
			throw badRequest("Já existe um cliente com esse cpf");
		}
		
		return Response.ok("registro incluído com sucesso, código "+cliente.getId()).build();
	}
	
}
