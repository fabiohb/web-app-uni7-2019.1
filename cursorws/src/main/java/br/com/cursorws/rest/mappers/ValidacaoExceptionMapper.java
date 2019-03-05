package br.com.cursorws.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.cursorws.business.ValidacaoException;

@Provider
public class ValidacaoExceptionMapper implements ExceptionMapper<ValidacaoException> {

	@Override
	public Response toResponse(ValidacaoException exception) {
		return Response
				.status(422) // Unprocessable Entity
				.entity(exception.getErros()).build();
	}
}