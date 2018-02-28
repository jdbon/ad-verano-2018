package test;

import java.util.ArrayList;
import java.util.List;

import controlador.ControladorDeDespacho;
import dao.PedidoDAO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ItemPedidoException;
import excepcion.OrdenDeCompraException;
import excepcion.PedidoException;

public class Test2Despacho {

	public static void main(String[] args) {
		
		//Primero: Traer Pedidos Pendientes
		List<PedidoDTO> pedidosPendientes = new ArrayList<PedidoDTO>();
		try {
			pedidosPendientes = ControladorDeDespacho.getInstancia().buscarPedidosPendiente();
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Mostrarlos
		for(PedidoDTO pDTO: pedidosPendientes){
			System.out.println(pDTO.toString());
		}
		
		//Rechaza el primero
		try {
			System.out.println("Rechazar pedido nro: " + pedidosPendientes.get(0).getIdPedido());
			ControladorDeDespacho.getInstancia().rechazarPedidoPendiente(pedidosPendientes.get(0));
			System.out.println("El estado del pedido nro " + pedidosPendientes.get(0).getIdPedido() + " ahora es: " + PedidoDAO.getInstancia().findById(pedidosPendientes.get(0).getIdPedido()).getEstado());
		} catch (PedidoException | ArticuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Aprobar el segundo (queda Completado)
		try {
			System.out.println("Aprobar pedido nro: " + pedidosPendientes.get(1).getIdPedido());
			ControladorDeDespacho.getInstancia().aceptarPedidoPendiente(pedidosPendientes.get(1));
			System.out.println("El estado del pedido nro " + pedidosPendientes.get(1).getIdPedido() + " ahora es: " + PedidoDAO.getInstancia().findById(pedidosPendientes.get(1).getIdPedido()).getEstado());
		} catch (PedidoException | ArticuloException | OrdenDeCompraException | ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//Aprobar el tercero
		try {
			System.out.println("Aprobar pedido nro: " + pedidosPendientes.get(2).getIdPedido());
			ControladorDeDespacho.getInstancia().aceptarPedidoPendiente(pedidosPendientes.get(2));
			System.out.println("El estado del pedido nro " + pedidosPendientes.get(2).getIdPedido() + " ahora es: " + PedidoDAO.getInstancia().findById(pedidosPendientes.get(2).getIdPedido()).getEstado());
		} catch (PedidoException | ArticuloException | OrdenDeCompraException | ItemPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		

	}

}
