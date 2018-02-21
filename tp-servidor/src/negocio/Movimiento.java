package negocio;

public abstract class Movimiento {
	
	private Integer nroMovimiento;
	private Integer cantidad;
	private Articulo articulo;
	private TipoMovimiento tipo;
	
	public Movimiento() {
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
