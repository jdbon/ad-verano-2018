package delegado;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.OrdenDeCompraException;
import excepcion.PedidoException;
import excepcion.SistemaException;
import interfaz.INegocio;

public class BusinessDelegate implements INegocio{
	
	private static BusinessDelegate instancia;
	private INegocio negocioRemoto;
	
	private BusinessDelegate() throws SistemaException   {
		conectar();
	}
	
	private void conectar() throws SistemaException {
		try {
			negocioRemoto = (INegocio) Naming.lookup("//localhost/ver");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SistemaException("Servidor no encontrado en URL");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SistemaException("Problemas en la red");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SistemaException("Recurso no encontrado");
		}
		
	}

	public static BusinessDelegate getInstancia() throws SistemaException{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}


//	public ClienteDTO getClienteById(ClienteDTO cliDTO) throws SistemaException {
//		try {
//			return negocioRemoto.getClienteById(cliDTO);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new SistemaException("Error en conexion");
//		}
//	}

	@Override 
	public List<ArticuloDTO> getAllArticulos() throws PedidoException  {
		try {
			return negocioRemoto.getAllArticulos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new PedidoException("Error al generar un pedido.");
		}

	}

	@Override
	public int generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items) throws PedidoException, ClienteException, ArticuloException, ItemPedidoException  {
		try {
			return negocioRemoto.generarNuevoPedido(idCliente, direccion, items);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PedidoException("Error al generar un pedido.");
		}
	}

	@Override
	public PedidoDTO obtenerEstadoPedido(int idPedido) throws PedidoException {
		try{
			return negocioRemoto.obtenerEstadoPedido(idPedido);
		} catch (RemoteException e){
			throw new PedidoException("Error al recuperar un pedido.");
		}
	}

	@Override
	public List<PedidoDTO> buscarPedidosPendiente() throws PedidoException {
		
		try {
			return negocioRemoto.buscarPedidosPendiente();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new PedidoException("Error al recuperar lista de pedidos pendientes.");
		}
		
	}

	@Override
	public void rechazarPedidoPendiente(PedidoDTO pedidoPendiente) throws PedidoException, ArticuloException, OrdenDeCompraException, ItemPedidoException {
		try {
			negocioRemoto.rechazarPedidoPendiente(pedidoPendiente);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PedidoException("Error al rechazar un pedido.");
		}
		
		
	}

	@Override
	public void aprobarPedidoPendiente(PedidoDTO pedidoPendiente) throws PedidoException, ArticuloException, OrdenDeCompraException, ItemPedidoException  {
			try {
				negocioRemoto.aprobarPedidoPendiente(pedidoPendiente);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new PedidoException("Error al aprobar un pedido.");
			}
			
		
	}

}

	
	
	
	
	

