package br.com.cursorws.rest.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class CorsResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.putSingle("Access-Control-Allow-Headers", "origin, content-type, responseType, accept, Authorization");
		headers.putSingle("Access-Control-Allow-Credentials", "true");
		headers.putSingle("Access-Control-Allow-Origin", "*");
		headers.putSingle("Access-Control-Allow-Methods", "HEAD, OPTIONS, TRACE, GET, POST, PUT, PATCH, DELETE");
		headers.putSingle("Access-Control-Expose-Headers", "Authorization");
		headers.putSingle("Access-Control-Max-Age", "3600000");
	}

}