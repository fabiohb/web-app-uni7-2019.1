<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.cursoweb.model.Usuario"%>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    List<Usuario> usuarios = new ArrayList<Usuario>();
    usuarios.add(new Usuario("Fabio", "fabio@gmail.com", "M"));
    usuarios.add(new Usuario("Maria", "maria@gmail.com", "F"));
    usuarios.add(new Usuario("Jose", "jose@gmail.com", "M"));
    usuarios.add(new Usuario("Pedro", "pedro@gmail.com", ""));
    usuarios.add(new Usuario("Ana", "ana@gmail.com", "F"));
    pageContext.setAttribute("usuarios", usuarios);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usu&aacute;rios</title>
</head>
<body>
<c:if test="${not empty usuarios}">
  <ul>
  <c:forEach var="usuario" items="${usuarios}">
    <li><a href="mailto:${usuario.email}">${usuario.nome}</a></li>
  </c:forEach>
  </ul>
</c:if>
</body>
</html>