<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
          <font color="red"><p>Consultar Estado de un Pedido</p></font>
 		  
<p></p>
		   <a href="index.jsp" class="btn btn-default btn-lg page-scroll"> < VOLVER </a></div>
      </div>
    </div>
  </div>
</header>
		<form action="Controlador" method="get">
			  <table border="1">
				  <tr><td colspan="4"><b>Ingrese el numero de pedido</b></td></tr>
		    	  <tr><td>Nro de Pedido</td><td><input name="nroPed" size="50"/></td></tr>
		    	  <tr><td colspan="2" align="right"><input name="boton" type="submit" value="ENVIAR"/></td></tr>    
			  </table>
		<input type="hidden" name="accion" value="statusPedido">
		</form> 
<div id="footer">
  <div class="container text-center">
    <div class="fnav">
      <font size="10"><p>&copy; GRUPO 9. Aplicaciones Distribuidas - Verano 2018</p></font>
    </div>
  </div>
</div>

</body>
</html>