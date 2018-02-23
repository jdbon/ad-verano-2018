package dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6124688305587653596L;
	

	private Integer articulo;
	private Integer cantidadSolicitada;
	private Integer cantidadReservada;
	private Float subTotal;
	
	public ItemPedidoDTO() {
		super();
	}
	public Integer getArticulo() {
		return articulo;
	}
	public void setArticulo(Integer articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public Integer getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public Float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	} 
	

}
