package br.com.cursorws.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cursorws.business.UsuarioBC;
import br.com.cursorws.business.UsuarioNaoEncontradoException;
import br.com.cursorws.model.Usuario;

@Path("usuarios")
public class UsuariosRS {

	@Inject
	private UsuarioBC usuarioBC;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> selecionar() {
		return usuarioBC.selecionar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario selecionar(@PathParam("id") Long id) {
		try {
			return usuarioBC.selecionar(id);
		} catch (UsuarioNaoEncontradoException e) {
			throw new NotFoundException();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Usuario body) {
		Long id = usuarioBC.inserir(body);
		String url = "/api/usuarios/" + id;
		return Response
				.status(Status.CREATED)
				.header("Location", url)
				.entity(id)
				.build();
	}
}