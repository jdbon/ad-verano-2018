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
import negocio.ItemPedido;

public class TestCliente1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PRIMERO: LLegan la lista de articulos
		List<ArticuloDTO> articulosDTO = ControladorDeClientes.getInstancia().getAllArticulos();
		
		for(ArticuloDTO aDTO : articulosDTO){
			System.out.println(aDTO.toString());
		}
		
		//SEGUNDO: Selecciona articulos y cantidades, ingresa direccion
		int idCliente = 1;
		String direccion = "Lima 776";
		
		List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item1 = new ItemPedidoDTO();
		item1.setArticulo(articulosDTO.get(0));
		item1.setCantidadSolicitada(5);
		
		ItemPedidoDTO item2 = new ItemPedidoDTO();
		item2.setArticulo(articulosDTO.get(1));
		item2.setCantidadSolicitada(15);
		
		items.add(item1);
		items.add(item2);
		
		
		try {
			int codigoPedido = ControladorDeClientes.getInstancia().generarNuevoPedido(idCliente, direccion, items);
			System.out.println("Nro de pedido: " + codigoPedido);
		} catch (ClienteException | ArticuloException | PedidoException | ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
