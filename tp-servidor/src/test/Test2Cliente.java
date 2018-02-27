package test;



import controlador.ControladorDeClientes;
import dto.PedidoDTO;
import excepcion.PedidoException;

public class Test2Cliente {
	public static void main(String[] args) {
		
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = ControladorDeClientes.getInstancia().obtenerEstadoPedido(1);
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("estado: " + pDTO.getEstado().toString());
	}
}
