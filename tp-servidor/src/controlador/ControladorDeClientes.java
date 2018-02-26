package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.ArticuloDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
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
	
	public Integer generarNuevoPedido(int idCliente, String direccion, List<ItemPedidoDTO> items ) throws ClienteException, ArticuloException, PedidoException, ItemPedidoException {
		Cliente cliente = ClienteDAO.getInstancia().findByID(idCliente);
		Pedido pedido = new Pedido(cliente, direccion);
		for(ItemPedidoDTO item: items) {
			pedido.agregarItemPedido(item.getArticulo().getCodigoBarra(), item.getCantidadSolicitada());
		}		
		PedidoDAO.getInstancia().save(pedido);
		
		return pedido.getIdPedido();
	}
}
