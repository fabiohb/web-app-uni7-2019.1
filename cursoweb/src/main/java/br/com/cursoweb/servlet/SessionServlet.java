package br.com.cursoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 6802030530738727745L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Usuarios</title></head>");
		out.println("<body>");

		String invalidate = request.getParameter("invalidate");
		if (invalidate != null && invalidate.equals("true")) {
			request.getSession().invalidate();
			out.println("Session invalidada!");
		} else {
			out.println("Session não invalidada!");
		}

		out.println("<hr/><a href=\"/cursoweb/\">Voltar</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}