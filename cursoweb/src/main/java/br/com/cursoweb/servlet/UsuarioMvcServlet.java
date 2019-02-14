package br.com.cursoweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cursoweb.model.Usuario;

@WebServlet("/usuarioMvcServlet")
public class UsuarioMvcServlet extends HttpServlet {
    private static final long serialVersionUID = 6802030530738727745L;

    @Override
    protected void doGet(HttpServletRequest request,
       HttpServletResponse response) throws ServletException, IOException {

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Fabio", "fabio@gmail.com"));
        usuarios.add(new Usuario("Maria", "maria@gmail.com"));
        usuarios.add(new Usuario("Jose", "jose@gmail.com"));
        usuarios.add(new Usuario("Pedro", "pedro@gmail.com"));
        usuarios.add(new Usuario("Ana", "ana@gmail.com"));

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/usuarioMvc.jsp")
               .forward(request, response);
    }
}