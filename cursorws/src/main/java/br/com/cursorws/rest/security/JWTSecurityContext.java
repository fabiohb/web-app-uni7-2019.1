package br.com.cursorws.rest.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class JWTSecurityContext implements SecurityContext {

	private SecurityContext contexto;

	private Principal principal;

	public JWTSecurityContext(SecurityContext contextoOriginal, String usuario) {
		this.contexto = contextoOriginal;
		this.principal = new Principal() {
			@Override
			public String getName() {
				return usuario;
			}
		};
	}

	@Override
	public String getAuthenticationScheme() {
		return this.contexto.getAuthenticationScheme();
	}

	@Override
	public boolean isSecure() {
		return this.contexto.isSecure();
	}

	@Override
	public boolean isUserInRole(String role) {
		return false;
	}

	@Override
	public Principal getUserPrincipal() {
		return this.principal;
	}
}