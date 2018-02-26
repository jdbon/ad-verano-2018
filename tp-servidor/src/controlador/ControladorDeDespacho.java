package controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import dto.PedidoDTO;
import enumerator.EstadoPedido;
import excepcion.ArticuloException;
import excepcion.ItemPedidoException;
import excepcion.OrdenDeCompraException;
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

	//devuelve todos los pedidos PENDIENTES de la base de datos
	public List<PedidoDTO> buscarPedidosPendiente() throws PedidoException{
		
		List<Pedido> pedidos_pen = PedidoDAO.getInstancia().getPendientes();
		List<PedidoDTO> pedidos_pen_DTO = new ArrayList<PedidoDTO>();
		for (Pedido p : pedidos_pen) {
			pedidos_pen_DTO.add(p.toDTO());   
		}
		
		return pedidos_pen_DTO;
	}
	
	//devuelve todos los pedidos COMPLETADOS de la base de datos
		public List<PedidoDTO> buscarPedidosCompletados() throws PedidoException{
			
			List<Pedido> pedidos_pen = PedidoDAO.getInstancia().getCompletados();
			List<PedidoDTO> pedidos_pen_DTO = new ArrayList<PedidoDTO>();
			for (Pedido p : pedidos_pen) {
				pedidos_pen_DTO.add(p.toDTO());   
			}
			
			return pedidos_pen_DTO;
		}

		//devuelve todos los pedidos DESPACHADOS de la base de datos
		public List<PedidoDTO> buscarPedidosDespechados() throws PedidoException{
						
			List<Pedido> pedidos_pen = PedidoDAO.getInstancia().getDespachados();
			List<PedidoDTO> pedidos_pen_DTO = new ArrayList<PedidoDTO>();
			for (Pedido p : pedidos_pen) {
				pedidos_pen_DTO.add(p.toDTO());   
			}
						
			return pedidos_pen_DTO;
		}
		
		//RECHAZA el pedido PENDIENTE
		public void rechazarPedidoPendiente(PedidoDTO pedidoPendiente, String motivoRech) throws PedidoException, ArticuloException{

			Pedido pedido;
			pedido = PedidoDAO.getInstancia().findById(pedidoPendiente.getIdPedido());
			pedido.setEstado(EstadoPedido.Rechazado);
			pedido.setMotivoRechazo(motivoRech);
			PedidoDAO.getInstancia().update(pedido);
		}
		
		//ENTREGA al delivery pedido DESPACHADO
		public void entregarPedidoDespachado(PedidoDTO pedidoPendiente, Date fechaEntregaEstimada) throws PedidoException, ArticuloException{

			Pedido pedido;
			pedido = PedidoDAO.getInstancia().findById(pedidoPendiente.getIdPedido());
			pedido.setEstado(EstadoPedido.Entregado);
			pedido.setFechaEntregaEstimada(fechaEntregaEstimada);
			PedidoDAO.getInstancia().update(pedido);
		}
		
		//ACEPTA el pedido PENDIENTE
		public void aceptarPedidoPendiente(PedidoDTO pedidoPendiente) throws PedidoException, ArticuloException, OrdenDeCompraException, ItemPedidoException{

			Pedido pedido;
			pedido = PedidoDAO.getInstancia().findById(pedidoPendiente.getIdPedido());
			if (pedido.verificarStock() == false){
				pedido.setEstado(EstadoPedido.Pendiente);
				PedidoDAO.getInstancia().update(pedido);
			}else{
				pedido.setEstado(EstadoPedido.Completo);
				PedidoDAO.getInstancia().update(pedido);
			}
		}
}


