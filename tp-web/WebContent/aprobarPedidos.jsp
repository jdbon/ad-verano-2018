<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "dto.*"  %>
    <%@ page import = "delegado.*"  %>
    <%@ page import = "java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTADO DE PEDIDOS PENDIENTES</title>
</head>
<body>

	
	<table cellspacing="3" cellpadding="3" border="1" width="500">
	<tr>
		<td colspan="4"><b>Lista de Pedidos Pendientes de Aprobacion</b></td>
	</tr>
	<tr>
		
		<td><b>CODIGO</b></td>
		<td><b>CLIENTE</b></td>
		<td><b>APROBAR</b></td>
		<td><b>RECHAZAR</b></td>
	</tr>
<form action="Controlador" method="get">
<%
	PedidoDTO aDTO;
	String id; 	
	List<PedidoDTO> losPedidosDTO = (List<PedidoDTO>) request.getAttribute("pedPend");
	for(PedidoDTO pdto : losPedidosDTO)
	{
		int codigoPed1 = pdto.getIdPedido();
%>
	<tr>
		<input type="hidden" name="codigoPedido" value="<%=codigoPed1%>">
		<td><%=pdto.getIdPedido()%></td>
		<td><%=pdto.getClienteDTO().getApellido()%>, <%=pdto.getClienteDTO().getNombre()%></td>
		<input type="hidden" name="accion" value="aprobarPedidos33">
		<td><input type="submit" value="<%=codigoPed1 %>" name="apPed" ></td>
		<td><input type="submit" value="<%=codigoPed1 %>" name="rePed" ></td>
	</tr>
<% } %>
</table>
<br>
<br>


</form>
</body>
</html>