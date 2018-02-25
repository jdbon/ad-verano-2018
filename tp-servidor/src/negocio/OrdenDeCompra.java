package negocio;

import java.util.Date;

import dao.OrdenDeCompraDAO;
import enumerator.EstadoOC;
import excepcion.OrdenDeCompraException;

public class OrdenDeCompra {
	
	private Integer nroOrdenDeCompra;
	private Articulo articulo;
	private int cantidadXcomprar;
	private EstadoOC estado;
	private Date fechaRecepcion;
	private int cantidadReservada;
	
	public OrdenDeCompra() {
		super();
		
	}
	
	public void save() throws OrdenDeCompraException{
		OrdenDeCompraDAO.getInstancia().save(this);
	}

	public Integer getNroOrdenDeCompra() {
		return nroOrdenDeCompra;
	}

	public void setNroOrdenDeCompra(Integer nroOrdenDeCompra) {
		this.nroOrdenDeCompra = nroOrdenDeCompra;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidadXcomprar() {
		return cantidadXcomprar;
	}

	public void setCantidadXcomprar(int cantidadXcomprar) {
		this.cantidadXcomprar = cantidadXcomprar;
	}

	public EstadoOC getEstado() {
		return estado;
	}

	public void setEstado(EstadoOC estado) {
		this.estado = estado;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public int getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	
	
	

}
