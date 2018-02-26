package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controlador.ControladorDeClientes;
import controlador.ControladorDeDespacho;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import enumerator.TipoFactura;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.FacturaException;
import excepcion.PedidoException;
import negocio.*;

public class Test {

	public static void main(String[] args) throws ClienteException, ArticuloException, PedidoException {
		
		CargaDeDatos.cargarClientes();
		ControladorDeClientes.getInstancia().getAllArticulos();
		
		//ControladorDeClientes.getInstancia().generarNuevoPedido(1, "La recalcada concha de tu hermana", items);
		
	}

}

