package br.com.cursorws.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.cursorws.business.UsuarioNaoEncontradoException;

@Provider
public class UsuarioNaoEncontradoExceptionMapper implements ExceptionMapper<UsuarioNaoEncontradoException> {

	@Override
	public Response toResponse(UsuarioNaoEncontradoException exception) {
		return Response.status(Status.NOT_FOUND).build();
	}
}