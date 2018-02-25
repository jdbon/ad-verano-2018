package controlador;

import java.util.List;

import dto.ItemPedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import negocio.Pedido;

public class ControladorDeClientes {

	private static ControladorDeClientes instancia;
	
	private ControladorDeClientes(){}
	
	public static ControladorDeClientes getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeClientes();
		return instancia;
	}
	
	public Integer generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items ) throws ClienteException, ArticuloException {
		Pedido pedido = new Pedido(idCliente, direccion);
		for(ItemPedidoDTO item: items) {
			pedido.agregarItemPedido(item.getArticulo().getCodigoBarra(), item.getCantidadReservada());
		}		
		
		return pedido.getIdPedido();
	}
}
