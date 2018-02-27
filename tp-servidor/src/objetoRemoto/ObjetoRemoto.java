package objetoRemoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controlador.ControladorDeClientes;
import controlador.ControladorDeDespacho;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import interfaz.INegocio;

public class ObjetoRemoto extends UnicastRemoteObject implements INegocio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1123123L;

	public ObjetoRemoto() throws RemoteException {
		super();
	}


	
//	public ClienteDTO getClienteById(ClienteDTO cliDTO) throws RemoteException {
//	
//		return Controlador.getInstancia().obtenerCliente(cliDTO);
//	}




	public List<ArticuloDTO> getAllArticulos() throws RemoteException {
		
		return ControladorDeClientes.getInstancia().getAllArticulos();
	}



	@Override 
	public int generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items)
			throws RemoteException, PedidoException, ClienteException, ArticuloException, ItemPedidoException {
		
		return ControladorDeClientes.getInstancia().generarNuevoPedido(idCliente, direccion, items);
	}



	@Override
	public PedidoDTO obtenerEstadoPedido(int idPedido) throws RemoteException, PedidoException {
		
		return ControladorDeClientes.getInstancia().obtenerEstadoPedido(idPedido);
	}



	@Override
	public List<PedidoDTO> buscarPedidosPendiente() throws RemoteException, PedidoException {
		// TODO Auto-generated method stub
		return ControladorDeDespacho.getInstancia().buscarPedidosPendiente();
	}

}
