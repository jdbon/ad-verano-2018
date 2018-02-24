package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import dto.PedidoDTO;
import excepcion.PedidoException;
import negocio.Pedido;



public class ControladorDeDespacho {

	private static ControladorDeDespacho instancia;
	
	private ControladorDeDespacho(){}
	
	public static ControladorDeDespacho getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeDespacho();
		return instancia;
	}

	//devuelve todos los pedidos pendientes de la base de datos
	public List<PedidoDTO> buscarPedidosPendiente() throws PedidoException{
		
		List<Pedido> pedidos_pen = PedidoDAO.getInstancia().getPendientes();
		List<PedidoDTO> pedidos_pen_DTO = new ArrayList<PedidoDTO>();
		for (Pedido p : pedidos_pen) {
			pedidos_pen_DTO.add(p.toDTO());   
		}
		
		return pedidos_pen_DTO;
	}



}


