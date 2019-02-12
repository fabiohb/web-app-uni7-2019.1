package br.com.cursoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cursoweb.model.Usuario;

/**
 * Servlet implementation class UsuarioServlet.
 */
@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3162419944663739724L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Fabio", "fabio@gmail.com"));
		usuarios.add(new Usuario("Maria", "maria@gmail.com"));
		usuarios.add(new Usuario("Jose", "jose@gmail.com"));
		usuarios.add(new Usuario("Pedro", "pedro@gmail.com"));
		usuarios.add(new Usuario("Ana", "ana@gmail.com"));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Usuarios</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		
		for (Usuario usuario : usuarios) {
			out.println("<li>");
			out.println("<a href=\"mailto:" + usuario.getEmail() + "\">");
			out.println(usuario.getNome());
			out.println("</a>");
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("<hr/><a href=\"/cursoweb/\">Voltar</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}