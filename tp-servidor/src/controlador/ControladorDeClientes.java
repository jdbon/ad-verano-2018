package controlador;

import java.util.List;

import dto.ItemPedidoDTO;
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
	
	public Integer generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items ) throws ClienteException {
		Pedido pedido = new Pedido(idCliente, direccion);
		
		
		
		
		return pedido.getIdPedido();
	}
}
