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

public class TestControladorCliente {

	public static void main(String[] args) {
		
		int numeroPedido = 0;
		
		int idCliente = 1;
		String direccion = "Lima 775";
		List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
		
		ItemPedidoDTO item1 = new ItemPedidoDTO();
		ArticuloDTO art1 = new ArticuloDTO();
		art1.setCodigoBarra(1);
		item1.setArticulo(art1);
		item1.setCantidadSolicitada(2);
		items.add(item1);
		
		ItemPedidoDTO item2 = new ItemPedidoDTO();
		ArticuloDTO art2 = new ArticuloDTO();
		art2.setCodigoBarra(2);
		item2.setArticulo(art2);
		item2.setCantidadSolicitada(2);
		items.add(item2);
		
		
		try {
			numeroPedido = ControladorDeClientes.getInstancia().generarNuevoPedido(idCliente, direccion, items);
			System.out.println("Pedido creado exitosamente");
			System.out.println("Su número de pedido es " + numeroPedido);
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
