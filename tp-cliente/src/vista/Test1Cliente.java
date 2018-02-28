package vista;

import java.util.ArrayList;
import java.util.List;


import delegado.BusinessDelegate;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import excepcion.SistemaException;


public class Test1Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PRIMERO: LLegan la lista de articulos
		List<ArticuloDTO> articulosDTO = new ArrayList<ArticuloDTO>();
		try {
			
			articulosDTO = BusinessDelegate.getInstancia().getAllArticulos();
			for(ArticuloDTO aDTO : articulosDTO){
				System.out.println(aDTO.toString());
			}
		} catch (PedidoException | SistemaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("cant art: " + articulosDTO.size());
		
		
		//SEGUNDO: Selecciona articulos y cantidades, ingresa direccion
		///////////////////////              Pedido 1
		int idCliente = 1;
		String direccion = "Lima 776";
		
			//Articulo 1
		List<ItemPedidoDTO> itemsPedido1 = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item11 = new ItemPedidoDTO();
		item11.setArticulo(articulosDTO.get(0));
		item11.setCantidadSolicitada(5);
		
			//Articulo 2
		ItemPedidoDTO item12 = new ItemPedidoDTO();
		item12.setArticulo(articulosDTO.get(1));
		item12.setCantidadSolicitada(15);
		
		itemsPedido1.add(item11);
		itemsPedido1.add(item12);
		
		
		try {
			int codigoPedido = BusinessDelegate.getInstancia().generarNuevoPedido(idCliente, direccion, itemsPedido1);
			System.out.println("Nro de pedido: " + codigoPedido);
		} catch (SistemaException | PedidoException | ClienteException | ArticuloException | ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		///////////////////      Pedido 2
		idCliente = 2;
		direccion = "Lima 222";
		
			//Articulo 1
		List<ItemPedidoDTO> itemsPedido2 = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item21 = new ItemPedidoDTO();
		item21.setArticulo(articulosDTO.get(0));
		item21.setCantidadSolicitada(5);
		
			//Articulo 2
		ItemPedidoDTO item22 = new ItemPedidoDTO();
		item22.setArticulo(articulosDTO.get(1));
		item22.setCantidadSolicitada(15);
		
		itemsPedido2.add(item21);
		itemsPedido2.add(item22);
		
		try {
			int codigoPedido = BusinessDelegate.getInstancia().generarNuevoPedido(idCliente, direccion, itemsPedido2);
			System.out.println("Nro de pedido: " + codigoPedido);
		} catch (PedidoException | SistemaException | ClienteException | ArticuloException | ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		///////////////////      Pedido 3 (grandes cantidades)
		idCliente = 3;
		direccion = "Lima 333";
		
			//Articulo 1
		List<ItemPedidoDTO> itemsPedido3 = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item31 = new ItemPedidoDTO();
		item31.setArticulo(articulosDTO.get(0));
		item31.setCantidadSolicitada(50000);
		
			//Articulo 2
		ItemPedidoDTO item32 = new ItemPedidoDTO();
		item32.setArticulo(articulosDTO.get(1));
		item32.setCantidadSolicitada(15000);
		
		itemsPedido3.add(item31);
		itemsPedido3.add(item32);
		
		int codigoPedido;
		
			try {
				codigoPedido = BusinessDelegate.getInstancia().generarNuevoPedido(idCliente, direccion, itemsPedido3);
				System.out.println("Nro de pedido: " + codigoPedido);
			} catch (PedidoException | ClienteException | ArticuloException | ItemPedidoException
					| SistemaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
