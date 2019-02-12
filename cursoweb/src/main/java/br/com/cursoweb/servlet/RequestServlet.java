package br.com.cursoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6802030530738727745L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		if (nome != null && !nome.equals("")) {
			request.setAttribute("NOME", nome);
			request.getSession().setAttribute("NOME", nome);
			request.getSession().getServletContext().setAttribute("NOME", nome);
		}

		String error = request.getParameter("error");
		if (error != null && !error.equals("")) {
			response.sendError(Integer.valueOf(error));
		}

		String redirect = request.getParameter("redirect");
		if (redirect != null && !redirect.equals("")) {
			response.sendRedirect(redirect);
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Usuarios</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("getRequestURL(): " + request.getRequestURL() + "<br/>");
		out.println("getContextPath(): " + request.getContextPath() + "<br/>");
		out.println("getQueryString(): " + request.getQueryString() + "<br/>");
		out.println("getMethod(): " + request.getMethod() + "<br/>");
		out.println("getProtocol(): " + request.getProtocol() + "<br/>");

		out.println("<br/>");

		out.println("NOME Request: " + request.getAttribute("NOME") + "<br/>");
		out.println("NOME Session: " + request.getSession().getAttribute("NOME") + "<br/>");
		out.println("NOME Context: " + request.getSession().getServletContext().getAttribute("NOME") + "<br/>");
		out.println("<hr/><a href=\"/cursoweb/\">Voltar</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}