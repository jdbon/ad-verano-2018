<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NRO PEDIDO</title>
</head>
<body>
<b>Su pedido fue ingresado con exito. </b>
<br>
<h2>Su numero de pedido es: 
<%
	int nroPedido = (int) request.getAttribute("nroPedido");
%>
<br>
<b><%=nroPedido %></b>
</h2>
</body>
</html>