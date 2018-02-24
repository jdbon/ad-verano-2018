package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import negocio.EstadoOC;

@Entity
@Table(name="ordenes_compras")
public class OrdenDeCompraEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="odc_id")
	private Integer nroOrdenDeCompra;
	
	@OneToOne
	@JoinColumn(name="odc_art")
	private ArticuloEntity articulo;
	
	@Column(name="odc_cant_x_comprar")
	private int cantidadXcomprar;
	
	@Enumerated(EnumType.STRING)
	private EstadoOC estado;
	
	@Column(name="odc_fec_ent")
	private Date fechaEntrega;
	
	@Column(name="odc_cant_res")
	private int cantidadReservada;

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

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	
	

}
