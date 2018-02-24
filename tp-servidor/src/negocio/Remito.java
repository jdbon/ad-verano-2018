package negocio;

import java.util.Date;
import java.util.List;

public class Remito {
	
	private int nroRemito;
	private Date fecha;
	private Pedido pedido;
	private List<ItemRemito> items;
	private Cliente cliente;
	
	public Remito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNroRemito() {
		return nroRemito;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ItemRemito> getItems() {
		return items;
	}

	public void setItems(List<ItemRemito> items) {
		this.items = items;
	}
	
	
	
	

}
