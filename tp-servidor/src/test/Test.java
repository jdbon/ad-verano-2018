package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controlador.ControladorDeClientes;
import dto.ArticuloDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.PedidoException;

public class Test {

	public static void main(String[] args) throws ClienteException, ArticuloException, PedidoException {
		
		CargaDeDatos.cargarClientes();
		@SuppressWarnings("unused")
		List<ArticuloDTO> articulos = ControladorDeClientes.getInstancia().getAllArticulos();
		System.out.println("TENGO EL LISTADO");
		
		//ControladorDeClientes.getInstancia().generarNuevoPedido(1, "La recalcada concha de tu hermana", items);
		
	}

}

