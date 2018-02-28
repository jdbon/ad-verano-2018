package vista;

import delegado.BusinessDelegate;
import dto.PedidoDTO;
import excepcion.PedidoException;
import excepcion.SistemaException;

public class Test2Cliente {
	
	public static void main(String[] args) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = BusinessDelegate.getInstancia().obtenerEstadoPedido(1);
		} catch (PedidoException | SistemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Estado: " + pDTO.getEstado().toString());
	}
}
