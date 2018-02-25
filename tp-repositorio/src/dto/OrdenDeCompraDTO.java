package dto;

import java.util.Date;

import enumerator.EstadoOC;

public class OrdenDeCompraDTO {
	
	private Integer nroOrdenDeCompra;
	private ArticuloDTO articuloDTO;
	private int cantidadXcomprar;
	private EstadoOC estado;
	private Date fechaRecepcion;
	private int cantidadReservada;
	private Date fechaCreacion;
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	

	public OrdenDeCompraDTO() {}
	
	public Integer getNroOrdenDeCompra() {
		return nroOrdenDeCompra;
	}
	public void setNroOrdenDeCompra(Integer nroOrdenDeCompra) {
		this.nroOrdenDeCompra = nroOrdenDeCompra;
	}
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}
	public void setArticuloDTO(ArticuloDTO articulo) {
		this.articuloDTO = articulo;
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
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
