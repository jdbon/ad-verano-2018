package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import negocio.Cliente;
import negocio.EstadoPedido;
import negocio.ItemPedido;

public class PedidoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2071632209672397718L;

	private Integer idPedido;
	private List<ItemPedidoDTO> items;
	private ClienteDTO cliente;
	private String direccion;
	private EstadoPedido estado;
	private Date fechaCreacion;
	private Date fechaEntregaEstimada;
	private String motivoRechazo;
	
	public PedidoDTO() {
		
		
	}
	
	
}
