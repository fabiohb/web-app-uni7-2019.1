<%@ page language="java" contentType="text/html" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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