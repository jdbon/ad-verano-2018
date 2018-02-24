package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import enumerator.TipoMovimiento;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="mov_tmo",discriminatorType=DiscriminatorType.STRING)
public abstract class MovimientoEntity {
	@Id
	@Column(name="mov_id")
	protected Integer nroMovimiento;
	@Column(name="mov_cant")
	protected Integer cantidad;
	
	//protected Articulo articulo; --> el movimiento no conoce al articulo
	@Enumerated(EnumType.STRING)
	protected TipoMovimiento tipo;
	
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
