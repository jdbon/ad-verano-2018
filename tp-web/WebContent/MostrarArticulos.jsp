<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "dto.*"  %>
    <%@ page import = "delegado.*"  %>
    <%@ page import = "java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MOSTRAR ARTICULOS</title>
</head>
<body>

	
	<table cellspacing="3" cellpadding="3" border="1" width="500">
	<tr>
		<td colspan="4"><b>Lista de Articulos</b></td>
	</tr>
	<tr>
		
		<td><b>CODIGO</b></td>
		<td><b>DESCRIPCION</b></td>
		<td><b>PRECIO</b></td>
		<td><b>CANTIDAD</b></td>
	</tr>
<%
	ArticuloDTO aDTO;
	String id; 	
	List<ArticuloDTO> losArticulosDTO = (List<ArticuloDTO>) request.getAttribute("articulosDTO");
	for(ArticuloDTO adto : losArticulosDTO)
	{
		
%>
	<tr>
		<td><%=adto.getCodigoBarra()%></td>
		<td><%=adto.getDescripcion()%></td>
		<td><%=adto.getPrecioVenta()%></td>
		<td><input type="text" name="cantidad"></td>
	</tr>
<% } %>
</table>
<b>Numero de Cliente</b>
<input type="text" name="nroCliente">
<br>
<b>Direccion</b>
<input type="text" name="direccion">
<br>
<input type="submit" value= "ENVIAR">
</body>
</html>