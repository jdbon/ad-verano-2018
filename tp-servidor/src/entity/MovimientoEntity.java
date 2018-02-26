package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumerator.TipoMovimiento;

@Entity
@Table(name="movimientos")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="mov_tmo",discriminatorType=DiscriminatorType.STRING)
public abstract class MovimientoEntity {
	@Id
	@Column(name="mov_id")
	protected Integer nroMovimiento;
	@Column(name="mov_cant")
	protected Integer cantidad;
	
	@Enumerated(EnumType.STRING)
	@Column(name="mov_tipoEnum")
	protected TipoMovimiento tipo;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="mov_art")
	private ArticuloEntity artE;
	
	public MovimientoEntity() {
		super();
	}
	
	public Integer getNroMovimiento() {
		return nroMovimiento;
	}
	public void setNroMovimiento(Integer nroMovimiento) {
		this.nroMovimiento = nroMovimiento;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
//	public Articulo getArticulo() {
//		return articulo;
//	}
//	public void setArticulo(Articulo articulo) {
//		this.articulo = articulo;
//	}
	public TipoMovimiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

}
