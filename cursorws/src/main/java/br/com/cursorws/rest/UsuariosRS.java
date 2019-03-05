package br.com.cursorws.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cursorws.business.UsuarioBC;
import br.com.cursorws.business.UsuarioNaoEncontradoException;
import br.com.cursorws.business.ValidacaoException;
import br.com.cursorws.model.Usuario;
import br.com.cursorws.rest.security.JWTRequired;

@JWTRequired
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
	public Usuario selecionar(@PathParam("id") Long id) throws UsuarioNaoEncontradoException {
		return usuarioBC.selecionar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Usuario body) throws ValidacaoException {
		Long id = usuarioBC.inserir(body);
		String url = "/api/usuarios/" + id;
		return Response
				.status(Status.CREATED)
				.header("Location", url)
				.entity(id)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, Usuario usuario) 
			throws UsuarioNaoEncontradoException, ValidacaoException {
		usuario.setId(id);
		usuarioBC.atualizar(usuario);
		return Response.ok(id).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) throws UsuarioNaoEncontradoException {
		Usuario usuario = usuarioBC.excluir(id);
		return Response.ok(usuario).build();
	}
}