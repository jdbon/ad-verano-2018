package entity;

import java.util.List;

import javax.persistence.*;

import negocio.Presentacion;


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
	@Column(name="art_x_comprar")
	private Integer cantidadOrdenDeCompra;
//	hay una doble navegacion---> asi que va un uno a muchos bidireccional
//	private List<LoteEntity> lotes;
	@Column(name="art_cant_res")
	private Integer cantidadReservada;
//	@OneToMany
//	@JoinColumn(name="art_id")
//	private List<MovimientoEntity> movimientos;
	
	
	
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

	public List<LoteEntity> getLotes() {
		return null; // reemplazar por: return lotes;
	}

	public void setLotes(List<LoteEntity> lotes) {
		// luego destomentar // this.lotes = lotes;
	}

	public Integer getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

//	public List<MovimientoEntity> getMovimientos() {
//		return movimientos;
//	}
//
//	public void setMovimientos(List<MovimientoEntity> movimientos) {
//		this.movimientos = movimientos;
//	}
	
	
}
