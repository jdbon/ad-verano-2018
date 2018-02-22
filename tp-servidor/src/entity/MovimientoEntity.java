package entity;

import negocio.Articulo;
import negocio.TipoMovimiento;

public abstract class MovimientoEntity {
	
	protected Integer nroMovimiento;
	protected Integer cantidad;
	protected Articulo articulo;
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
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public TipoMovimiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

}
