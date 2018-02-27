package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import dto.ArticuloDTO;
import dto.ClienteDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;



public interface INegocio extends Remote {
	
	//public ClienteDTO getClienteById(ClienteDTO cliDTO) throws RemoteException, SistemaException;
	public List<ArticuloDTO> getAllArticulos() throws RemoteException, PedidoException;
	
	public int generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO>  items) throws RemoteException, PedidoException, ClienteException, ArticuloException, ItemPedidoException;

	public PedidoDTO obtenerEstadoPedido(int idPedido) throws RemoteException, PedidoException;

	public List<PedidoDTO> buscarPedidosPendiente() throws RemoteException, PedidoException;
}
