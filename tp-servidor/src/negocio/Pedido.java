package negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private static int numerador;
	private Integer idPedido;
	private List<ItemPedido> items;
	private Cliente cliente;
	private String direccion;
	private EstadoPedido estado;
	private Date fechaCreacion;
	private Date fechaEntregaEstimada;
	private String motivoRechazo;
	
	public Pedido() {
		numerador++;
		this.idPedido = numerador;
		this.items = new ArrayList<ItemPedido>();
		
	}
}
