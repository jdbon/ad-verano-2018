package test;

import java.util.ArrayList;
import java.util.List;

import controlador.ControladorDeClientes;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;

public class Test {

	public static void main(String[] args) throws ClienteException, ArticuloException, PedidoException, ItemPedidoException {
		
		CargaDeDatos.cargarClientes();

		List<ArticuloDTO> articulos = ControladorDeClientes.getInstancia().getAllArticulos();
		System.out.println("TENGO EL LISTADO");
		List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item1 = new ItemPedidoDTO();
		item1.setArticulo(articulos.get(0));
		item1.setCantidadSolicitada(20);
		ItemPedidoDTO item2 = new ItemPedidoDTO();
		item2.setArticulo(articulos.get(1));
		item2.setCantidadSolicitada(5);
		items.add(item1);
		items.add(item2);
		ControladorDeClientes.getInstancia().generarNuevoPedido(1, "Direccion", items);
		
	}

}

