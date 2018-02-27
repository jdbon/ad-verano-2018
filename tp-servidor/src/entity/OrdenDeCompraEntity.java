package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enumerator.EstadoOC;

import javax.persistence.*;

@Entity
@Table(name="ordenes_compras")
public class OrdenDeCompraEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="odc_id")
	private Integer nroOrdenDeCompra;
	
	@ManyToOne
	@JoinColumn(name="odc_art")
	private ArticuloEntity articulo;
	
	@Column(name="odc_cant_x_comprar")
	private int cantidadXcomprar;
	
	@Enumerated(EnumType.STRING)
	@Column(name="odc_estado")
	private EstadoOC estado;
	
	@Column(name="odc_fec_recepcion")
	private Date fechaRecepcion;
	
	@Column(name="odc_cant_res")
	private int cantidadReservada;
	
	@Column(name="odc_fec_creacion")
	private Date fechaCreacion;

	public OrdenDeCompraEntity() {
		
	}

	public Integer getNroOrdenDeCompra() {
		return nroOrdenDeCompra;
	}

	public void setNroOrdenDeCompra(Integer nroOrdenDeCompra) {
		this.nroOrdenDeCompra = nroOrdenDeCompra;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}
