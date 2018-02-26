package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.ArticuloDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.Pedido;

public class ControladorDeClientes {

	private static ControladorDeClientes instancia;
	
	private ControladorDeClientes(){}
	
	public static ControladorDeClientes getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeClientes();
		return instancia;
	}
	
	public List<ArticuloDTO> getAllArticulos(){
		
		List<ArticuloDTO> resultado = new ArrayList<ArticuloDTO>();
		List<Articulo> articulos = ArticuloDAO.getInstancia().findAll();
		for(Articulo articulo: articulos)
			resultado.add(articulo.toDTO());
		return resultado;
	}
	
	public Integer generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items) throws ArticuloException, PedidoException, ItemPedidoException, ClienteException {
		
		Cliente cliente = this.buscarCliente(idCliente);
		Pedido pedido = new Pedido(cliente, direccion);
		for(ItemPedidoDTO item: items) {
			pedido.agregarItemPedido(item.getArticulo().getCodigoBarra(), item.getCantidadSolicitada());
			
		}
		pedido.calcularTotal();
		PedidoDAO.getInstancia().save(pedido);
		return pedido.getIdPedido();
	}
	
	private Cliente buscarCliente(int idCliente) throws ClienteException {
		return ClienteDAO.getInstancia().findByID(idCliente);
	}
	
	public PedidoDTO buscarPedido(int idPedido) throws PedidoException{
		Pedido ped = PedidoDAO.getInstancia().findById(idPedido);
		return ped.toDTO();
	}
}

