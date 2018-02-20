package controlador;

import java.util.List;

import negocio.Cliente;
import negocio.ItemPedido;
import negocio.Pedido;

public class ControladorDeClientes {

	private static ControladorDeClientes instancia;
	
	private ControladorDeClientes(){}
	
	public static ControladorDeClientes getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeClientes();
		return instancia;
	}
	
	public Integer generarNuevoPedido(Cliente cliente, List<ItemPedido> items, String direccion) {
		Pedido pedido = new Pedido();
		
		return null;
	}
}
