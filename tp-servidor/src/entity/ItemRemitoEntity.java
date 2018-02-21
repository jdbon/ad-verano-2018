package entity;

import negocio.Articulo;

public class ItemRemitoEntity {
	
	private Articulo articulo;
	private Integer cantidad;
	
	public ItemRemitoEntity() {}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
