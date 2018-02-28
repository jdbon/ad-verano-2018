<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "dto.*"  %>
    <%@ page import = "delegado.*"  %>
    <%@ page import = "java.util.*"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Die Verrückte Dose</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/modernizr.custom.js"></script>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Header -->
<header id="header">
  <div class="intro">
    <div class="container">
      <div class="row">
        <div class="intro-text">
          <h1>Die Verruckte Dose</h1>
          <hr>
          <font color="red"><p>Pedidos pendientes de aprobación</p></font>
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
<p></p>  <a href="index.jsp" class="btn btn-default btn-lg page-scroll"> < VOLVER </a></div>
      </div>
    </div>
  </div>
</header>

<div id="footer">
  <div class="container text-center">
    <div class="fnav">
      <font size="10"><p>&copy; GRUPO 9. Aplicaciones Distribuidas - Verano 2018</p></font>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="js/bootstrap.js"></script> 
<script type="text/javascript" src="js/SmoothScroll.js"></script> 
<script type="text/javascript" src="js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="js/jquery.isotope.js"></script> 
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="js/contact_me.js"></script> 
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>