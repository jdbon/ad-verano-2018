package entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerator.Presentacion;
import negocio.Lote;
import negocio.OrdenDeCompra;


@Entity
@Table(name="articulos")
public class ArticuloEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="art_id")
	private Integer codigoBarra;
	
	@Column(name="art_desc")
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="art_presentacion")
	private Presentacion presentacion;
	
	@Column(name="art_tamanio")
	private Integer tamaño;
	
	@Column(name="art_unidad")
	private Integer unidad;
	
	@Column(name="art_precio_vta")	
	private Float precioVenta;
	
	@Column(name="art_cant_x_comprar")
	private Integer cantidadOrdenDeCompra;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="lot_art")
	private Set<LoteEntity> lotes;

	@Column(name="art_cant_res")
	private Integer cantidadReservada;

    @OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="mov_art")
	private List<MovimientoEntity> movimientos;
	
	@OneToMany
	@JoinColumn(name="art_id")
	private List<OrdenDeCompraEntity> ordenes;
	
	
	
	public ArticuloEntity() {}
	
	

	public Integer getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(Integer codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Integer getTamaño() {
		return tamaño;
	}

	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getCantidadOrdenDeCompra() {
		return cantidadOrdenDeCompra;
	}

	public void setCantidadOrdenDeCompra(Integer cantidadOrdenDeCompra) {
		this.cantidadOrdenDeCompra = cantidadOrdenDeCompra;
	}

	

	public Set<LoteEntity> getLotes() {
		return lotes;
	}



	public void setLotes(Set<LoteEntity> lotes) {
		this.lotes = lotes;
	}



	public List<OrdenDeCompraEntity> getOrdenes() {
		return ordenes;
	}



	public void setOrdenes(List<OrdenDeCompraEntity> ordenes) {
		this.ordenes = ordenes;
	}



	public Integer getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	public List<MovimientoEntity> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoEntity> movimientos) {
		this.movimientos = movimientos;
	}
	
	
}
