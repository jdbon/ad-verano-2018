package negocio;

import dto.MovimientoDTO;
import enumerator.TipoMovimiento;

public abstract class Movimiento {
	
	protected Integer nroMovimiento;
	protected Integer cantidad;
	
	//protected Articulo articulo; --> el movimiento no conoce al articulo
	protected TipoMovimiento tipo;
	
	public Movimiento() {
		super();
	}
	
	public abstract String toString();
	
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

	public MovimientoDTO toDTO() {
		//FALTA IMPLEMENTAR 
		return null;
	}
	
	

}
