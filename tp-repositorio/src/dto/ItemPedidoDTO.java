package dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6124688305587653596L;
	

	private ArticuloDTO articuloDTO;
	private int cantidadSolicitada;
	private int cantidadReservada;
	private Float subTotal;
	
	public ItemPedidoDTO() {
		super();
	}
	public ArticuloDTO getArticulo() {
		return this.articuloDTO;
	}
	public void setArticulo(ArticuloDTO articulo) {
		this.articuloDTO = articulo;
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
