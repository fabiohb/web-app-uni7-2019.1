package br.com.cursorws.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jose4j.lang.JoseException;

import br.com.cursorws.business.UsuarioBC;
import br.com.cursorws.business.UsuarioInvalidoException;
import br.com.cursorws.model.Usuario;
import br.com.cursorws.rest.security.JWTUtil;

@Path("login")
public class LoginRS {
  @Inject
  private UsuarioBC usuarioBC;
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public Response login(Usuario usuario) {
    try {
      usuarioBC.autenticarUsuario(usuario.getCpf(), usuario.getSenha());
      return Response.status(Response.Status.OK).entity("Usuário autorizado")
          .header(HttpHeaders.AUTHORIZATION, JWTUtil.BEARER + JWTUtil.criar(usuario.getCpf()))
          .build();
    } catch (UsuarioInvalidoException e) {
      return Response.status(Response.Status.FORBIDDEN)
          .entity("Usuário ou senha inválidos").build();
    } catch (JoseException e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity("Erro ao gerar o token de acesso").build();
    }
  }
}