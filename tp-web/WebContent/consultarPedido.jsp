<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONSULTAR PEDIDO</title>
</head>
<body>
<form action="Controlador" method="get">
<table border="1">
	<tr><td colspan="4"><b>Ingrese el numero de pedido</b></td></tr>
    <tr><td>Nro de Pedido</td><td><input name="nroPed" size="50"/></td></tr>
    <tr><td colspan="2" align="right"><input name="boton" type="submit" value="ENVIAR"  /></td></tr>    
</table>
<input type="hidden" name="accion" value="statusPedido">
</form>
</body>
</html>