<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "dto.*"  %>
    <%@ page import = "delegado.*"  %>
    <%@ page import = "java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REALIZAR PEDIDO</title>
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
<form action="Controlador" method="get">
<%
	ArticuloDTO aDTO;
	String id; 	
	List<ArticuloDTO> losArticulosDTO = (List<ArticuloDTO>) request.getAttribute("articulosDTO");
	for(ArticuloDTO adto : losArticulosDTO)
	{
		int codigoArticulo = adto.getCodigoBarra();
%>
	<tr>
		<input type="hidden" name="codigoBarra<%=codigoArticulo%>" value="<%=codigoArticulo%>">
		<td><%=adto.getCodigoBarra()%></td>
		<td><%=adto.getDescripcion()%></td>
		<td><%=adto.getPrecioVenta()%></td>
		<td><input type="text" name="cantidad<%=codigoArticulo%>" value="0"></td>
	</tr>
<% } %>
</table>
<br>
<br>

<table border="1">
	<tr><td colspan="4"><b>Ingrese sus datos</b></td></tr>
	<tr><td>Numero de Cliente</td><td><input name="nroCliente", size="10"/></td></tr>
    <tr><td>Direccion</td><td><input name="direccion", size="50"/></td></tr>
    <tr><td colspan="2" align="right"><input name="boton" type="submit" value="ENVIAR"  /></td></tr>    
</table>
<input type="hidden" name="accion" value="pedidoCliente">
</form>
</body>
</html>