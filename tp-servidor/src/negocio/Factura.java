package negocio;

import java.util.Date;
import java.util.List;

import dao.FacturaDAO;
import enumerator.TipoFactura;
import excepcion.ArticuloException;
import excepcion.FacturaException;

public class Factura {
	
	private Integer nroFactura;
	private Cliente cliente;
	private List<ItemFactura> items;
	private TipoFactura tipo;
	private float total;
	private Pedido pedido;
	private Date fecha;
	
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void save() throws FacturaException, ArticuloException{
		FacturaDAO.getInstancia().save(this);
	}

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	public TipoFactura getTipo() {
		return tipo;
	}

	public void setTipo(TipoFactura tipo) {
		this.tipo = tipo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	

}
